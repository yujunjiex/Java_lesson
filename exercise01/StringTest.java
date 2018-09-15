class Exercise{
	public static void main(String[] args) {
		String c1="Hello Java";
		String c2=c1;
		c2="Hello Python";
		System.out.printf("%s\n%s\n",c1,c2);
		System.out.println("对象指向的内存地址:");
		System.out.println(c1.getClass()+"@"+c1.hashCode());
		System.out.println(c2.getClass()+"@"+c2.hashCode());
		System.out.println("引用对象的内存地址:");
		System.out.println(System.identityHashCode(c1));
		System.out.println(System.identityHashCode(c2));
		//System.out.printf(c1.hashCode()+","+c2.hashCode());
		//System.out.println(Objects.hashCode(c1));
		//Object test=new Object();
		//System.out.println(test.hashCode());
	}
}