import java.util.*;

class ArrayListEx1 {
	public static void main(String[] args) {
		ArrayList list1 = new ArrayList(10);													//	list1에 정수형 인스턴스 5 4 2 0 1 3을 저장

		list1.add(5);		list1.add(4);
		list1.add(2);		list1.add(0);
		list1.add(1);		list1.add(3);
																								//	list1에서 4 2 0 데이터 부분을 잘라서 list2로 생성
		ArrayList list2 = new ArrayList(list1.subList(1, 4));
																								//	subList()의 리터타입이 List이므로 바로 ArrayList에는 들어갈 수 없으므로
																								//	Collection을 매개변수로 하는 생성자를 이용하여 새로운 ArrayList 인스턴스 list2를 생성
		print(list1, list2);																	//	list1 : [5, 4, 2, 0, 1, 3]	/	list2 : [4, 2, 0]		

		Collections.sort(list1);	Collections.sort(list2);									//	Collections 클래스의 sort() 메소드를 이용하여 두 ArrayList를 오름차순 정렬
		print(list1, list2);																	//	list1 : [5, 4, 3, 2, 1, 0]	/	list2 : [4, 2, 0]
		
		System.out.println("list1.containsAll(list2) : " + list1.containsAll(list2) + "\n");	//	list1.containsAll(list2) : true
		// list2의 맨 뒤에 "B"와 "C"를 추가하고, 3번 자리에 "A"를 추가 후 출력						//	list1에 list2의 데이터들이 모두 들어있는지 여부
		list2.add("B");	list2.add("C");	list2.add(3,"A");										//	Collection 인터페이스의 add() 메소드를 이용하여 맨 뒤에 "B", "C" 데이터 추가
																								//	List 인터페이스의 add() 메소드를 이용하여 3번 인덱스 자리에 "A" 데이터 추가
		print(list1, list2);																	//	list1 : [0, 1, 2, 3, 4, 5]	/	list2 : [0, 2, 4, A, B, C]
		list2.set(3, "AA");																		//	list2의 3번자리 데이터를 "AA"로 변경
		print(list1, list2);																	//	list1 : [0, 1, 2, 3, 4, 5]	/	list2 : [0, 2, 4, AA, B, C]
		//	list1에서 list2의 데이터와 동일한 데이터들만 남기고 나머지는 삭제 후 출력
		System.out.println("list1.retainAll(list2) : " + list1.retainAll(list2));				//	true : list1에서 삭제한 데이터가 있다는 의미
		System.out.println("list1.retainAll(list2) : " + list1.retainAll(list2));				//	false : list1에서 삭제한 데이터가 없다는 의미
		print(list1, list2);																	//	list1 : [0, 2, 4]	/	list2 : [0, 2, 4, AA, B, C]
																								//	list2에서 list1과 동일한 데이터가 있으면 찾아내어 하나씩 삭제 후 출력(for문)
		for(int i = list2.size()-1; i >= 0; i--) {												//	여러 데이터를 삭제할 경우 거꾸로 루프를 돌면서 삭제하는 것이 효율적임
			if(list1.contains(list2.get(i))) list2.remove(i);									//	list1에 list2의 i 인덱스에 해당하는 데이터가 들어있으면 삭제
		}
		print(list1,list2);																		//	list1 : [0, 2, 4]	/	list2 : [AA, B, C]
	}
	public static void print(ArrayList list1, ArrayList list2) {
		System.out.println("list1 : " + list1);
		System.out.println("list2 : " + list2);
		System.out.println();
	}
}