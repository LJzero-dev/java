import java.util.*;

class HashSetEx {
	public static void main(String[] args) {
		Object[] objArr = {"1", new Integer(1), "2", "2", "3", "3", "4", "4", "4"};
		Set set = new HashSet();					//objArr 배열의 값들을 모두 set에 저장한 후 출력
		for (int i = 0;i < objArr.length ; i++ ) {
			set.add(objArr[i]);
		}
		System.out.println(set);					//	[1, 1, 2, 3, 4]
	}
}
