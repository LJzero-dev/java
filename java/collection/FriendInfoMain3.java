import java.util.*;

class Friend {												
	String name, phone, addr;								
	public Friend(String name, String phone, String addr) {		
		this.name = name;	this.phone = phone; this.addr = addr;
	}
	public void showAllInfo() {
		System.out.println("이름 : " + name);
		System.out.println("전화 : " + phone);
		System.out.println("주소 : " + addr);
	}
	public void showBasicInfo() {}
	public void searchFriend() {}
}

class HighFriend extends Friend {
	String work;				
	public HighFriend(String name, String phone, String addr, String work){
		super(name,phone,addr);
		this.work = work;
	}
	public void showAllInfo() {
		super.showAllInfo();
		System.out.println("직업 : " + work);
	}
	public void showBasicInfo() {
		System.out.println("이름 : " + name);
		System.out.println("전화 : " + phone);
		System.out.println("주소 : " + addr);	
	}
}

class UnivFriend extends Friend {
	String major;				
	public UnivFriend(String name, String phone, String addr, String major){
		super(name,phone,addr);
		this.major = major;
	}
	public void showAllInfo() {
		super.showAllInfo();
		System.out.println("전공 : " + major);
	}
	public void showBasicInfo() {
		System.out.println("이름 : " + name);
		System.out.println("전화 : " + phone);
		System.out.println("주소 : " + addr);														
	}
}

class FriendHandler {											
	private ArrayList<Friend> myFriends;		//	Friend형 인스턴스만 저장할 수 있는 ArrayList 선언
																
	private int numOfFriends;									
	public FriendHandler(int num) {
		myFriends = new ArrayList<Friend>(num);							
		numOfFriends = 0;										
	}
	private void addFriendInfo(Friend fren) {
		myFriends.add(fren);
	}

	public void addFriend(int choice) {
		String name, phone, addr, work, major;
		
		Scanner sc = new Scanner(System.in);
		System.out.print("이름 : ");		name = sc.nextLine();
		System.out.print("전화 : ");		phone = sc.nextLine();
		System.out.print("주소 : ");		addr = sc.nextLine();
		if (choice == 1){
			System.out.print("직업 : ");		work = sc.nextLine();
			myFriends.add(new HighFriend(name,phone,addr,work));
		} else {
			System.out.print("전공 : ");		major = sc.nextLine();
			myFriends.add(new UnivFriend(name,phone,addr,major));
		}

		System.out.println("입력완료\n");
	}
	public void showAllInfo() {
		for (int i = 0; i < myFriends.size() ; i++ ) {
			myFriends.get(i).showAllInfo();
		}
	}

	public void showBasicInfo() {
		for (int i = 0; i < myFriends.size() ; i++ ) {
			myFriends.get(i).showBasicInfo();
			}		
	}

	public void searchFriend() {
		Scanner sc = new Scanner(System.in);
		System.out.print("검색할 이름 : ");
		String keyword = sc.nextLine();

		for (int i = 0; i < myFriends.size() ; i++ ) {
			if (keyword.equals(myFriends.get(i).name)) {
				myFriends.get(i).showAllInfo();
				return;
			}				
		}
		System.out.println("검색결과가 없읍니다.");	
	}
}


class FriendInfoMain3 {
	public static void main(String[] args) {
		FriendHandler handler = new FriendHandler(100);
		while (true){
			System.out.println("*** 메뉴 선택 ***");
			System.out.println("1. 고교친구 저장");
			System.out.println("2. 대학친구 저장");
			System.out.println("3. 전체정보 출력");
			System.out.println("4. 기본정보 출력");
			System.out.println("5. 친구검색-이름");
			System.out.println("9. 프로그램 종료");
			System.out.print("메뉴 선택 >>");

			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt();

			switch (choice) {
			case 1: case 2:
				handler.addFriend(choice);						break;
			case 3:
				handler.showAllInfo();							break;
			case 4:
				handler.showBasicInfo();						break;
			case 5:
				handler.searchFriend();							break;
			case 9:
				System.out.println("프로그램을 종료합니다.");	
				return;
			
			}
		}
	}
}
