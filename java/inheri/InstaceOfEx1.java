class BasicBox {
	public void basicWrap() { System.out.println("basic wrap"); }
}
class PaperBox extends BasicBox {
	public void paperWrap() { System.out.println("paper wrap"); }
}
class GoldBox extends PaperBox {
	public void goldWrap() { System.out.println("gold wrap"); }
}
class InstaceOfEx1{
	public static void main(String[] args) {
		BasicBox box1 = new BasicBox();
		PaperBox box2 = new PaperBox();
		GoldBox box3 = new GoldBox();

		wrapBox(box1);	wrapBox(box2);	wrapBox(box3);
	}
	public static void wrapBox(BasicBox box) {	//	매개변수를 BasicBox형으로 선언했기 떄문에 그 하위 클래스인 PaperBox와 GoldBox형 인스턴스도 매개변수로 받을 수 있음
												//	단, 상위클래스인 BasicBox형으로 받았으므로 PaperBox와 GoldBox형 인스턴스도 BasicBox형으로 인식됨
		if (box instanceof GoldBox)	{			//	instanceof : 형변환 가능여부를 묻는 연산자
			((GoldBox)box).goldWrap();			//	받아온 box 인스턴스가 GoldBox로 형변환이 가능하면	/	GoldBox형으로 형변환 후 glodWrap() 메소드 호출
		} else if (box instanceof PaperBox){	//	받아온 box 인스턴스가 PaperBox로 형변환이 가능하면
			((PaperBox)box).paperWrap();		//	instanceof : 형변환 가능여부를 묻는 연산자로 조건 검사는 최하위 클래스부터 해야 함
		} else{									//	GoleBox형 인스턴스 box3는 PaperBox로도 형변환이 가능하므로 조건을 먼저 검사해야 함
			box.basicWrap();
		}													
	}
}
