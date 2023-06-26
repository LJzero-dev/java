import java.util.*;

class HashMapEx{
	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<String, String>();
		
		map.put("test","1234");
		map.put("abcd","1111");	//	Map의 Key값은 중복되지 않음으로 덮어쓰기 돼버림
		map.put("abcd","1234");
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("id와 password를 입력하세요.");
			System.out.print("ID : ");			String id = sc.nextLine();
			System.out.print("Password : ");	String pwd = sc.nextLine();
			System.out.println();

			if (!(map.containsKey(id))) {	//	map의 키들 중에 지정한 id와 동일한 키가 없으면(로그인 실패)
				System.out.println("존재하지 않는 id입니다. 다시 입력하세요.");
			} else {
				if (!map.get(id).equals(pwd)) {		//	map에서 id를 키로 하는 value와 pwd가 다르면
				System.out.println("비밀번호가 틀렸습니다.");					
				}
				else {	
				System.out.println("로그인 성공");
				break;
				}
			}
		}

	}
}
/*
				id와 password를 각각 입력받아 로그인 실행
				로그인 성공시 while문을 빠져나가 프로그램 종료
				로그인 실패 시 "존재하지 않는 id입니다."와 "비밀번호가 틀렸습니다." 중 하나의 메시지를 보여주고 다시 id와 password를 각각 입력받아 로그인 실행
				*/