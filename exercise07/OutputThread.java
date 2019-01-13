package PoolManager;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * 描述: Todo
 *
 * @author YuJunJie
 * @create 2019-01-13 21:23
 */
public class OutputThread implements Callable<Object>{

    private BlockingQueue<String> queue;

    public OutputThread(BlockingQueue queue){
        this.queue = queue;
    }

    @Override
    public Object call() throws InterruptedException {
        while(true){
            if(queue.size()==1000){
                break;
            }
            for(int cnt=0;cnt<30;cnt++){
                queue.poll(10, TimeUnit.SECONDS);
            }
            System.out.println("放水30立方米，当前水量：" + queue.size());
            TimeUnit.SECONDS.sleep(1);
        }
        return "success";
    }
}
