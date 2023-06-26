import java.util.*;

/* 회원 정보 관리 - MemberManage.java
회원정보(아이디, 암호, 이름)를 저장할 클래스 - MemberInfo
정보를 입력받고, 저장 처리 및 각종 기능을 담당할 클래스 - MemberHandler
메뉴
1. 회원 등록 - 회원 정보를 입력받아 ArrayList에 저장(제네릭 사용, 아이디 중복체크)
2. 전체 회원정보 보기
3. 회원 검색 - 아이디로 검색하여 정보 보여줌
9. 프로그램 종료
*/
class MemberInfo {	//	회원 정보 저장용 클래스
	private String id, pwd, name;
	public MemberInfo(String id, String pwd, String name) {
		this.id = id;	this.pwd = pwd; this.name = name;
	}
	public void setPwd(String pwd) { this.pwd = pwd; }
	public String getId() { return id; }
	public String getPwd() { return pwd; }
	public String getName() { return name; }
	public void showInfo() {
		System.out.println("아이디 : " + id + " / 암호 : " + pwd + " / 이름 : " + name);
	}
}

class MemberHandler {													//	회원 정보(MemberInfo 클래스의 인스턴스)를 입력받아 처리하는 클래스	
	private ArrayList<MemberInfo> members;								//	MemberInfo형 인스턴스만 저장하는 회원정보 저장용 ArrayList
	public MemberHandler() { members = new ArrayList<MemberInfo>(); }	//	제네릭으로 MemberInfo형만 저장되도록 제한 했으므로 members에서 객체를 참조할 때 MemberInfo형으로 형변환 불필요

	// d아이디 중복 여부를 리턴하는 메소드
	private boolean isDupId(String id) {
		for (int i = 0; i < members.size() ; i++ ) {
			if (id.equals(members.get(i).getId())) {					//	받아온 id와 members 에 있는 인스턴스들 중 동일한 id를 가진 객체가 있으면
				return true;
			}
		}return false;
	}


//	회원 정보를 사용자에게 입력받아 저장(회원가입) 시키는 메소드
	public void joinMember() {
		String id, pwd, name;
		Scanner sc = new Scanner(System.in);

		System.out.print("아이디 : ");		id = sc.nextLine().trim().toLowerCase();
		if (isDupId(id)) {
			System.out.println("이미 사용중인 아이디 입니다.");
			joinMember();	//	재귀호출로 아이디를 다시 입력받게 함
			return;
		}
		System.out.print("비밀번호 : ");		pwd = sc.nextLine().trim();
		System.out.print("이름 : ");		name = sc.nextLine().trim();


		members.add(new MemberInfo(id, pwd, name));
		System.out.println("회원 가입을 축하합니다.\n");
	}	

	//	전체 회원 정보를 보여주는 메소드
	public void showAllInfo() {
		for (int i = 0; i < members.size() ; i++ ) {
			members.get(i).showInfo();
		}		
	}

	// 검색어를 받아 회원정보를 검색하는 메소드
	public void searchMember() {
		String keyword;
		Scanner sc = new Scanner(System.in);
		System.out.print("검색할 아이디 를 입력해주세요: ");		keyword = sc.nextLine().trim().toLowerCase();
		boolean isSch = false;

		// 입력한 아이디와 동일한 아이디를 가진 회원 정보 출력(한 명만 존재) 정보 출력
		/*
		for (int i = 0; i < members.size() ; i++ ) {
			if (members.get(i).getName().equals(keyword))	{	//	현 회원정보 인스턴스의 id가 keyword와 같으면
				members.get(i).showInfo();
				return;
			} else {
				System.out.println("정보가 없습니다.");
				return;
			}
		}*/

		//	입력한 검색어를 포함가고 있는 아이디를 가진 회원들의 정보 출력

		for (int i = 0; i < members.size() ; i++ ) {
			if (members.get(i).getName().indexOf(keyword)!=-1)	{	//	현 회원 정보 인스턴스의 id에 keyword의 문자열을 포함하고 있으면
				members.get(i).showInfo();
				isSch = true;
			}
		}
		if (isSch) {
			System.out.println("검색 결과는 위와 같습니다.");
		} else {
			System.out.println("검색결과가 없습니다.");
		}
	}

	//	아이디와 암호를 받아 로그인을 시키는 메소드
	public void loginMember() {	//	성공 : 로그인 되었습니다. / 실패 : 로그인에 실패했습니다.
		String id, pwd;
		Scanner sc = new Scanner(System.in);
		System.out.print("아이디 를 입력해주세요: ");		id = sc.nextLine().trim().toLowerCase();
		System.out.print("비밀번호 를 입력해주세요: ");	pwd = sc.nextLine().trim();

		boolean isLogin = false;	//	로그인 성공여부를 저장할 변수
		for (int i = 0; i < members.size() ; i++ ) {
			MemberInfo mi = members.get(i);
			if(mi.getId().equals(id) && mi.getPwd().equals(pwd)) {
				isLogin=true;
			}
			if (isLogin) {
				System.out.println("로그인 되었습니다.\n");
				break;
			} else {
				System.out.println("로그인에 실패했습니다.\n");
				loginMember();
			}
		}
	}
}											

class MemberManage {
	public static void main(String[] args) {
		MemberHandler handler = new MemberHandler();

		while (true) {
			System.out.println("*** 메뉴 선택 ***");
			System.out.println("1. 회원 등록");
			System.out.println("2. 전체 회원정보 보기");
			System.out.println("3. 회원 검색");
			System.out.println("4. 로그인");
			System.out.println("9. 프로램 종료");
			System.out.print(" 메뉴 선택 >> ");

			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt();

			switch (choice) {
				case 1:
					handler.joinMember();	break;
				case 2:
					handler.showAllInfo();	break;
				case 3:
					handler.searchMember();	break;
				case 4:
					handler.loginMember();	break;
				case 9:
					System.out.println("프로그램을 종료합니다.");
					return;
			}
		}
	}
}
