class InstCnt {
	static int clsNum = 0;					//	멤버변수 중 클래스 변수	//	변하지 않는 특정 값을 매 인스턴스 변수에 할당 및 관리하기 힘들기 때문에 별도로 클래스변수 사용

	int insNum = 0;							//	멤버변수 중 인스턴스 변수
	InstCnt(){
		clsNum++;
		System.out.println("클래스 변수 : " + clsNum);
		insNum++;
		System.out.println("인스턴스 변수 변수 : " + insNum);
	}
}

class  ClassVar{
	public static void main(String[] args){
		InstCnt cnt1 = new InstCnt();	//	클래스 변수 : 1	인스턴스변수 : 1
		InstCnt cnt2 = new InstCnt();	//	클래스 변수 : 2	인스턴스변수 : 1
		InstCnt cnt3 = new InstCnt();	//	클래스 변수 : 3	인스턴스변수 : 1

		System.out.println("cnt1.clsNum : " + cnt1.clsNum + ", cnt2.clsNum : " + cnt2.clsNum + ", cnt3.clsNum : " + cnt3.clsNum); // 3,3,3
		System.out.println("cnt1.insNum : " + cnt1.insNum + ", cnt2.insNum : " + cnt2.insNum + ", cnt3.insNum : " + cnt3.insNum); // 1,1,1
	}
}
