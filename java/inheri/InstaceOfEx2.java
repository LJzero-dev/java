class BasicBox {
	public void basicWrap() { System.out.println("basic wrap"); }
}
class PaperBox extends BasicBox {
	public void paperWrap() { System.out.println("paper wrap"); }
}
class GoldBox extends PaperBox {
	public void goldWrap() { System.out.println("gold wrap"); }
}
class InstaceOfEx2{
	public static void main(String[] args) {
		BasicBox box1 = new BasicBox();
		PaperBox box2 = new PaperBox();
		GoldBox box3 = new GoldBox();

		wrapBox(box1);	wrapBox(box2);	wrapBox(box3);
	}
	public static void wrapBox(Object box) {
		if (box instanceof GoldBox)	{
			((GoldBox)box).goldWrap();
		} else if (box instanceof PaperBox){
			((PaperBox)box).paperWrap();
		} else{
			((BasicBox)box).basicWrap();
		}													
	}
}
