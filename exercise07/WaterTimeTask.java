package PoolManager;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import PoolManager.ThreadUtil;

/**
 * 描述: 定期放水类
 *
 * @author YuJunJie
 * @create 2019-01-13 21:23
 */
public class WaterTimeTask extends TimerTask {

    @Override
    public void run() {
        BlockingQueue<String> queue = new ArrayBlockingQueue<String>(1000);
        InputThread thread1 = new InputThread(queue);
        OutputThread thread2 = new OutputThread(queue);
        List<Callable<Object>> threadList = new ArrayList<>(2);

        int threadSize = threadList.size();

        threadList.add(thread1);
        threadList.add(thread2);

        List<Object> returnValue = null;
        try {
            returnValue = ThreadUtil.runCheckCallable(threadList,true);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("泳池已经注满");
        for(int i = 0; i < threadSize; i++) {
            System.out.println(returnValue.get(i));
        }
    }
}
