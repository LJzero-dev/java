import java.util.*;


class ArrayListEx2 {
	public static void main(String[] args) {
		final int LIMIT = 10;
		String source = "0123456789abcdefghijABCDEFGHIJ!@#$%^&*()ZZZ";

		//	source의 문자열을 10개씩 잘라 ArrayList에 저장한 후 하나씩 출력

		/*
		ArrayList list1 = new ArrayList(LIMIT);
		ArrayList list2 = new ArrayList(LIMIT);
		ArrayList list3 = new ArrayList(LIMIT);
		ArrayList list4 = new ArrayList(LIMIT);
		ArrayList list5 = new ArrayList(LIMIT);

		for(int i = 0 ; i < LIMIT; i++){
			list1.add(source.substring(i,i+1));
		}
		for(int i = 10 ; i < LIMIT*2; i++){
			list2.add(source.substring(i,i+1));
		}
		for(int i = 20 ; i < LIMIT*3; i++){
			list3.add(source.substring(i,i+1));
		}
		for(int i = 30 ; i < LIMIT*4; i++){
			list4.add(source.substring(i,i+1));
		}
		for(int i = 40 ; i < 43; i++){
			list5.add(source.substring(i,i+1));
		}
		print(list1);
		print(list2);
		print(list3);
		print(list4);
		print(list5);*/

		int length = source.length();
		List list = new ArrayList(length / LIMIT + 10);						//	list는 List형으로 선언했기 때문에 list의 메소드와 ArrayList에서 오버라이딩된 메소드들만 사용가능
																			//	대부분의 메소드가 오버라이딩 되어 있기 때문에 성능상의 문제는 없음
		for (int i = 0 ; i < length ; i += LIMIT) {							//	list형으로 선언했기 때문에 다른 List객체(LinkedList)로의 형변환이 자유로움
																			//	ArrayList의 크기는 넉넉하게 잡아주는 것이 좋음
			if (i + LIMIT < length ) {										//	자를 문자열의 글자 수가 LIMIT 이상 남았으면
				list.add(source.substring(i,i+LIMIT));
			} else {														//	자를 문자열의 글자 수가 LIMIT 보다 작으면
				list.add(source.substring(i));
			}
		}
		
		for(int i = 0 ; i < list.size() ; i++) {
			System.out.println(list.get(i));
		}
	}																		
																			
	public static void print(ArrayList list) {
		System.out.println("list : " + list);
		System.out.println();
	}
}
