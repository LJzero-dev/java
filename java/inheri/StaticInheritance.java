class Adder{
	static int val = 0;
	public void add(int num) { val += num; }
}

class AddCount extends Adder {
	public void countAdd(int num) { val += num; }
	public void showVal() { System.out.println("Val : " + val); }
}

class StaticInheritance {
	public static void main(String[] args) {
		Adder a = new Adder();
		AddCount ac = new AddCount();
		a.add(1);
		ac.countAdd(3);
		AddCount.val += 5;	//	static 멤버도 상속이 되어 하위클래스에서 상위클래스의 static 멤버에 자유롭게 접근 가능
		ac.showVal();
	}
}
