package PoolManager;
import java.util.Calendar;
import java.util.Timer;

/**
 * 描述: Todo
 *
 * @author YuJunJie
 * @create 2019-01-13 21:23
 */
public class MainDrive {

    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DATE),
                20,0,0
        );
        WaterTimeTask task = new WaterTimeTask();
        Timer timer = new Timer();
        //timer.schedule(task,calendar.getTime(),1000*60*60*24);
        timer.schedule(task, 1);
    }
}