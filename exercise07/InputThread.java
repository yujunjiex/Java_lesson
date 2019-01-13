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
public class InputThread implements Callable<Object>{

    private BlockingQueue<String> queue;

    public InputThread(BlockingQueue queue){
        this.queue = queue;
    }

    @Override
    public Object call() throws InterruptedException {
        while(true){
            boolean flag = true;
            for(int cnt=0;cnt<50;cnt++){
                flag = queue.offer("一立方米");
                if(!flag){
                    break;
                }
            }
            System.out.println("注水50立方米，当前水量："+queue.size());
            if(!flag){
                break;
            }
            TimeUnit.SECONDS.sleep(1);
        }
        return "success";
    }
}
