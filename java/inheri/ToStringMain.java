class MemberInfo {
//	이름과 거주 도시를 저장할 수 있는 클래스 생성(인스턴스 생성과 동시에 초기화 진행)
	private String name, city;
	MemberInfo(String name, String city){
		this.name = name;		this.city = city;
	}
	public String toString(){
		return this.name + this.city;
	}
	//	이름과 도시를 보여주는 toString() 메소드를 오버라이딩
}

class ToStringMain {
	public static void main(String[] args){
	MemberInfo mi1 = new MemberInfo("홍길동", "서울");
	System.out.println(mi1);							//	오버라이딩 전 : MemberInfo@2ff4acd0
	
	MemberInfo mi2 = new MemberInfo("전우치", "부산");
	System.out.println(mi2);							//	오버라이딩 전 : MemberInfo@54bedef2
	}
}
