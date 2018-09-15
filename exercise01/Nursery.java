public class Nursery{
	void speak(){
		for (int i=99;i>0 ;i--) {
			System.out.printf("%d bottles of beer on the wall,%d bottles of beer.\n",i,i);
			System.out.println("Take one down.   pass it around");
			if(i!=1){
				System.out.println(i-1 + " bottles of beer on the wall");
				System.out.printf("\n");
			}
			else
				System.out.println("No more bottles of beer pn the wall!\n");
		}
		
	}
}

class Exercise{
	public static void main(String args[]){
		Nursery wolf=new Nursery();
		wolf.speak();
	}
}