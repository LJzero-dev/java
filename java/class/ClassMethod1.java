class ClsMethodPrinter{
	public static void showInt(int n) { System.out.println(n); }
	public static void showDouble(double n) { System.out.println(n); }
}

class ClassMethod1{
	public static void main(String[] args){
		ClsMethodPrinter.showInt(20);						//	클래스 메소드도 클래스를 통해 접근할 수 있음
		ClsMethodPrinter cmp = new ClsMethodPrinter();
		cmp.showDouble(1.2);								//	인스턴스를 통해서도 접근할 수 있음
	}
}
