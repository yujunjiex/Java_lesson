package ThreadSafe;

import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * 描述: 线程安全演示类
 *
 * @author YuJunJie
 * @create 2019-01-09 11:07
 */
public class ThreadSafeDemo1 implements Runnable{

    private List<String> list;

    public ThreadSafeDemo1(List<String> list){
        this.list = list;
    }

    @Override
    public void run() {
        Random random = new Random();
        System.out.println("线程："+ random.nextInt());
        synchronized(list){ //如果是this的话，就不能两个实例分别开启线程，
            System.out.println(Thread.currentThread().getName()+"正在移除元素");
            Iterator<String> iterator = list.iterator();
            int cnt = 0;
            while(iterator.hasNext()){
                iterator.next();
                iterator.remove();
                cnt++;
                try {
                    TimeUnit.MILLISECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("移除元素的数量："+cnt);
        }
    }
}
