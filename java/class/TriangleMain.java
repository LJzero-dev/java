/*밑변과 높이 정보를 저장할 수 있는 Triangle 클래스 제작
1. 인스턴스 생성과 동시에 멤버변수들을 초기화 시킴				//	만족
2. 밑변과 높이 정보를 변경할 수 있는 메소드 제작				//	
3. 삼각형의 넓이를 구하여 리턴하는 메소드를 제작				//	만족
 - 밑변 10.2, 높이 17.3인 삼각형 인스턴스 생성 후 넓이 출력		//	만족
 - 밑변 9.2, 높이 7.5로 변경한 후 다시 넓이 출력
*/

class Triangle{
	private double baseOfTriangle, heightOfTriangle;	//	밑변과 높이를 저장할 멤버변수
														//	정보 은닉화를 위해 접근제어지시자를 private로 설정
	public Triangle(double base, double height ) {	
	baseOfTriangle=base;	heightOfTriangle=height;	//	매개변수로 받아온 값들을 멤버변수에 넣어 초기화 시킴
	}
	
	public double getareaOfTriangle(){
		return baseOfTriangle*heightOfTriangle/2;
	}

	public void setBaseOfTriangle(double base){
		baseOfTriangle=base;
	}
	public void setHeightOfTriangle(double height){
		baseOfTriangle=height;
	}
}


class  TriangleMain{
	public static void main(String[] args) {
		Triangle triangle1 = new Triangle(10.2,17.3);
		System.out.println("삼각형 넓이 : " + triangle1.getareaOfTriangle());
		triangle1.setBaseOfTriangle(9.2);		triangle1.setHeightOfTriangle(7.5);
		System.out.println("변경된 삼각형 넓이 : " + triangle1.getareaOfTriangle());
	}
}
