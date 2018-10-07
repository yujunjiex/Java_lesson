import java.util.ArrayList;
import java.util.List;

public class ListTest {
	public static void main(String args[]) {
		ArrayList<Integer> list=new ArrayList<Integer>();
		list.add(10);
		Integer integer1=list.get(0);
		integer1 = 3;
		System.out.println(list.get(0));
		// result: 把List中的成员赋给另一个变量时进行了拷贝，指向的是不同的地址
	}
}