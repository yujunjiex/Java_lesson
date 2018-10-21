import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**  
* Title: ExceptionOfLoop.java 
* Description:   当需要抛出异常的代码在循环语句中的捕获测试
* @author Yjj  
* @date 2018年10月20日 下午8:00:53
* @version 1.0  
*/
public class ExceptionOfLoop {
	public static void main(String[] args) {
		SimpleDateFormat dateformat= new SimpleDateFormat("yyyy-MM-dd");
		List<Date> list =new ArrayList<>(10);
		/*try-catch嵌入到for循环中*/
//		for(int cnt=0;cnt<10;cnt++){
//			try{
//				Date date = dateformat.parse("09-12");
//				list.add(date);
//			}
//			catch (ParseException e){
//			e.printStackTrace();
//			}
//		}
		
		/*for循环放到try中*/
		try{
			for(int cnt=0;cnt<10;cnt++){
				Date date = dateformat.parse("09-12");
				list.add(date);
			}
		}catch (ParseException e){
			e.printStackTrace();
		}
	}
	
}

/**
* 结论：如果当抛出异常时不想继续后面的循环就第二种
*      想让后面的循环继续执行就第一种
*/
