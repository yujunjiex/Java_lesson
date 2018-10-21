/**  
* Title: TransportationTool.java 
* Description:   简单的交通费用计算工具
* @author Yjj  
* @date 2018年10月20日 下午9:50:29
* @version 1.0  
*/


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


abstract class Traffic{
	public String vehicle;	//车辆名称
	public Date arriveTime;	//到达车站时间
	public Date backTime;	//从车站返回时间
	public Date checkinTime;	//取票时间
	public Date secCheckTime;	//安检时间
	public Date waitingTime;	//候车时间
	public double speed;	//车速
	public double pricePerKM;	//单价(每公里)
	abstract ArrayList<String> cost(double distance,String departure,String arrival);	//消耗的时间和价格
	void showSpendTime(double distance,String departure,String arrival) {	//输出花费的时间		
		ArrayList<String> list=cost(distance,departure,arrival);
		System.out.println("乘坐"+vehicle+"花费时间:"+list.get(0));
		System.out.println("花费金钱:"+list.get(1));
	}	
}

class Car extends Traffic{
	Car(){
		vehicle="汽车";
		SimpleDateFormat dateformat = new SimpleDateFormat("HH:mm:ss");
		try {
			arriveTime=dateformat.parse("00:10:00");
			backTime=dateformat.parse("00:10:00");
			checkinTime=dateformat.parse("00:10:00");
			secCheckTime=dateformat.parse("00:10:00");
			waitingTime=dateformat.parse("00:10:00");
		} catch (ParseException e) {
			e.printStackTrace();
		}		
		speed=60;
		pricePerKM=0.32;
	}
	@Override
	ArrayList<String> cost(double distance,String departure,String arrival) {
		double money=distance*pricePerKM;
		double time=distance/speed;
		double time_m=(time-(int)time)*60;
		String h=String.valueOf((int)time);
		String m=String.valueOf((int)(time_m));
		String s=String.valueOf((time_m-(int)(time_m))*60);
		SimpleDateFormat dateformat = new SimpleDateFormat("HH:mm:ss");
		Date times = null;
		try {
			times=dateformat.parse(h+":"+m+":"+s);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		ArrayList<String> list=new ArrayList<String>();
		list.add(dateformat.format(times));
		list.add(String.valueOf(money));
		return list;
	}
}

class HighSpeedRail extends Traffic{

	HighSpeedRail(){
		vehicle="高铁";
		SimpleDateFormat dateformat = new SimpleDateFormat("HH:mm:ss");
		try {
			arriveTime=dateformat.parse("00:8:00");
			backTime=dateformat.parse("00:8:00");
			checkinTime=dateformat.parse("00:8:00");
			secCheckTime=dateformat.parse("00:8:00");
			waitingTime=dateformat.parse("00:8:00");
		} catch (ParseException e) {
			e.printStackTrace();
		}	
		speed=300;
		pricePerKM=0.42;
	}
	@Override
	ArrayList<String> cost(double distance,String departure,String arrival) {
		double money=distance*pricePerKM;
		double time=distance/speed;
		double time_m=(time-(int)time)*60;
		String h=String.valueOf((int)time);
		String m=String.valueOf((int)(time_m));
		String s=String.valueOf((time_m-(int)(time_m))*60);
		SimpleDateFormat dateformat = new SimpleDateFormat("HH:mm:ss");
		Date times = null;
		try {
			times=dateformat.parse(h+":"+m+":"+s);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		ArrayList<String> list=new ArrayList<String>();
		list.add(dateformat.format(times));
		list.add(String.valueOf(money));
		return list;
	}
}

class AirPlane extends Traffic{

	AirPlane(){
		vehicle="飞机";
		SimpleDateFormat dateformat = new SimpleDateFormat("HH:mm:ss");
		try {
			arriveTime=dateformat.parse("00:6:00");
			backTime=dateformat.parse("00:6:00");
			checkinTime=dateformat.parse("00:6:00");
			secCheckTime=dateformat.parse("00:6:00");
			waitingTime=dateformat.parse("00:6:00");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		speed=900;
		pricePerKM=0.75;
	}
	@Override
	ArrayList<String> cost(double distance,String departure,String arrival) {
		double money=distance*pricePerKM;
		double time=distance/speed;
		double time_m=(time-(int)time)*60;
		String h=String.valueOf((int)time);
		String m=String.valueOf((int)(time_m));
		String s=String.valueOf((time_m-(int)(time_m))*60);
		SimpleDateFormat dateformat = new SimpleDateFormat("HH:mm:ss");
		Date times = null;
		try {
			times=dateformat.parse(h+":"+m+":"+s);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		ArrayList<String> list=new ArrayList<String>();
		list.add(dateformat.format(times));
		list.add(String.valueOf(money));
		return list;
	}

}

public class TransportationTool {
	public static void main(String[] args) {
		TransportationTool demo=new TransportationTool();
		demo.show();
	}
	public void show() {
		Traffic traffic=null;
		Car car=new Car();
		HighSpeedRail rail=new HighSpeedRail();
		AirPlane airplane=new AirPlane();
		Scanner sc = new Scanner(System.in);
		
		System.out.print("请输入出发地:");
		String departure=sc.nextLine();
		System.out.print("目的地:");
		String arrival=sc.nextLine();
		System.out.print("两地间距离(KM):");
		double distance=sc.nextDouble();
		
		traffic=car;
		traffic.showSpendTime(distance, departure, arrival);
		traffic=rail;
		traffic.showSpendTime(distance, departure, arrival);
		traffic=airplane;
		traffic.showSpendTime(distance, departure, arrival);
		sc.close();
	}
}
