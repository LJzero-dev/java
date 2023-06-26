interface SimpleInterface {
	public void showYourName();
}

class UpperClass {
	public void showYourAncestor() { System.out.println("Upper Class"); }
}

class Aa extends UpperClass implements SimpleInterface {
	public void showYourName() { System.out.println("class Aa"); }
}

class Bb extends UpperClass implements SimpleInterface {
	public void showYourName() { System.out.println("class Bb"); }
}


class BoundedTypeParam1{
	public static void main(String[] args) {
		Aa a = new Aa();	Bb b = new Bb();

		showIntstanceAncestor(a);	showInstanceName(a);
		showIntstanceAncestor(b);	showInstanceName(b);
	}
	public static <T> void showIntstanceAncestor(T param) {
		((SimpleInterface)param).showYourName();		//	인터페이스도 크래스처럼 형변환이 가능함
	}
	public static <T> void showInstanceName(T param) {
		((UpperClass)param).showYourAncestor();
	}
}