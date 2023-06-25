package test;

// 자바빈 테스트를 위한 클래스로 이름name과 성별gender을 저장하는 클래스
// name : Hong-GilDong, gender = 남자
public class BeanTest {
	private String name = "Hong-GilDong", gender = "남자";	// 정보저장 위한 멤버변수 선언

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}	
}
