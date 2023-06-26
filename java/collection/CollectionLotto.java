import java.util.*;

class CollectionLotto{
	public static void main(String[] args) {
		Set set = new HashSet();
		while (set.size() < 6) {
			int num = (int)(Math.random() * 45)+1;
			set.add(num);
		}		
		System.out.println(set);

		// set에 들어있는 숫자들을 오름차순 정렬하여 출력
		List list = new LinkedList(set);
		//	set은 Collection 인터페이스를 상속받았으므로 List의 인스턴스로 생성가능
		Collections.sort(list);	//	Collections	클래스의 sort() 메소드는 매개변수의 자료형이 List이므로 set을 List형 인스턴스로 생성하여 정렬 시킴
		System.out.println(list);
	}
}
