abstract class PersonalNumberStorage {											//	클래스 메소드들중 하나 이상이 abstract메소드이므로 클래스도 abstract로 선언됨
	public abstract void addPersonalInfo(String name, String pNum);
	public abstract String searchName(String pNum);
	public void showAllInfo() {}
}

class PersonalInfo {
	private String name, number;
	public PersonalInfo(String name, String number) {
		this.name = name; this.number = number;
	}
	public String getName() { return name; }
	public String getNumber() { return number; }
}

class PersonalNumberStorageImpl extends PersonalNumberStorage {					//	abstract 클래스인 PersonalNumberStorage를 상속받았으므로 반드시 PersonalNumberStorage클래스에 있는 abstract 메소드를 모두 오버라이딩하여 완성 해야함
	PersonalInfo[] perArr;														//	사람들의 개인정보를 담은 PersonalInfo형 인스턴스를 저장할 배열 선언
	int numOfPerInfo;															//	perArr 배열의 인덱스 겸 현재 들어있는 데이터 개수를 저장할 변수

	public PersonalNumberStorageImpl(int sz) {
		perArr = new PersonalInfo[sz];
		numOfPerInfo = 0;
	}
	public void addPersonalInfo(String name, String pNum) {						//	상위 클래스인 PersonalNumberStorage 메소드로 오버라이딩하여 완성해야 함
		perArr[numOfPerInfo] = new PersonalInfo(name, pNum);					//	인수로 받아온 name과 pNum을 이용하여 PersonalInfo형 인스턴스를 생성한 후 perArr 배열에 저장
		numOfPerInfo++;															//	현재 저장된 데이터 개수와 다음에 저장될 위치 인덱스를 위해 1씩 증가
	}
	public String searchName(String pNum) {										//	상위 클래스인 PersonalNumberStorage 메소드로 오버라이딩하여 완성해야 함
		for(int i=0;i<numOfPerInfo;i++){
			if(pNum.equals(perArr[i].getNumber())) return perArr[i].getName();	//	인수로 받아온 pNum과 perArr 배열의 i인덱스에 있는 인스턴스 getNumber() 메소드로 추출한 번호가 같이면
		}return null;															//	검색 결과가 없을 때 null 을 리턴	null 은 비어있는 객체(인스턴스)를 의미하므로 리턴타입이 기본 자료형만 아니면 어떤 리턴타입이라도 사용가능
	}

	public void showAllInfo() {
		for (int i = 0; i < numOfPerInfo ; i++) {
		System.out.println("이름 : " + perArr[i].getName() + ",	" + "번호 : " + perArr[i].getNumber());
		}
	}
}

class AbstractInterface1 {
	public static void main(String[] args) {
	PersonalNumberStorage storage = new PersonalNumberStorageImpl(100);

	storage.addPersonalInfo("홍길동","1234");
	storage.addPersonalInfo("전우치","1235");
	
	storage.showAllInfo();

	String result = storage.searchName("1234");
	if (result == null)	result = "검색결과가 없음";
	System.out.println(result);

	result = storage.searchName("1235");
	if (result == null)	result = "검색결과가 없음";
	System.out.println(result);

	result = storage.searchName("1236");
	if (result == null)	result = "검색결과가 없음";
	System.out.println(result);
	}
}
