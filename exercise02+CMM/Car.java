public class Car{
	String model = "五菱宏光";
	float tank = 100;
	float oilConsumption = 25;
	Car(String mo,float t,float oil){
		model = mo;
		tank = t;
		oilConsumption = oil;
	}
	public Car() {}
	public Boolean addGas(float g){	//加油
		if(g!=0)
			tank = tank+g;
		return true;
	}
	public Boolean isRun(){	//判断油量是否耗尽
		if(tank>0)
			return true;
		if(tank==0)
			return false;
		return null;
	}
	public void showAttributes(){
		System.out.println("型号:"+model+" 剩余油量:"+tank+" 耗油量:"+oilConsumption);
	}
}

class Exercise{
	public static void main(String args[]) {
	Car[] cars =new Car[6];
	cars[0] = new Car("布加迪",500,100);
	cars[1] = new Car("宝马",200,30);
	cars[2] = new Car("大众",100,20);
	cars[3] = new Car("奔驰",200,40);
	cars[4] = new Car("别克",180,40);
	cars[5] = new Car();
	for(int i=0;i<6;i++) {
		cars[i].showAttributes();
	}
	}
}