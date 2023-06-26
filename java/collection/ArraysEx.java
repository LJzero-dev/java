import java.util.*;

class ArraysEx {
	public static void main(String[] args) {
		int[] arr = {0, 1, 2, 3, 4};
		int[][] arr2D = { {11, 12, 13},{21, 22, 23} };
		System.out.println("arr : " + Arrays.toString(arr));						//	arr : [0, 1, 2, 3, 4]
		System.out.println("arr2D : " + Arrays.deepToString(arr2D));				//	arr2D : [[11, 12, 13], [21, 22, 23]]

		int[] arr2 = Arrays.copyOf(arr, arr.length);								//	arr배열의 처음부터 개수만큼 복사(전체를 복사할 경우 그냥 넣어도 됨, arr2 = arr)
		System.out.println("arr2 : " + Arrays.toString(arr2));						//	arr2 : [0, 1, 2, 3, 4]
		int[] arr3 = Arrays.copyOf(arr, 3);											//	arr배열의 처음부터 3개만큼 복사
		System.out.println("arr3 : " + Arrays.toString(arr3));						//	arr3 : [0, 1, 2]
		int[] arr4 = Arrays.copyOf(arr, 7);											//	arr배열의 처음부터 7개만큼 복사(넘칠경우 기본값을 넣어줌)
		System.out.println("arr4 : " + Arrays.toString(arr4));						//	arr4 : [0, 1, 2, 3, 4, 0, 0]

		int[] arr5 = Arrays.copyOfRange(arr, 2, 4);									//	arr배열의 2~4 복사
		System.out.println("arr5 : " + Arrays.toString(arr5));						//	arr5 : [2, 3]
		
		int[] arr6 = Arrays.copyOfRange(arr, 0, 7);									//	arr배열의 0~7 복사
		System.out.println("arr6 : " + Arrays.toString(arr6));						//	arr6 : [0, 1, 2, 3, 4, 0, 0]

		int[] arr7 = new int[5];
		Arrays.fill(arr7, 9);														//	arr7 배열의 값을 모두 9로 채움
		System.out.println("arr7 : " + Arrays.toString(arr7));						//	arr7 : [9, 9, 9, 9, 9]

		String[][] str2D1 = { {"aaa", "bbb"}, {"AAA","BBB"} };
		String[][] str2D2 = { {"aaa", "bbb"}, {"AAA","BBB"} };
		System.out.println("equals : " + Arrays.equals(str2D1, str2D2));			//	equals : false 1차원 비교용으로 다차원에선 무조건 flase
		System.out.println("deepEquals : " + Arrays.deepEquals(str2D1, str2D2));	//	deepEquals : true 다차원 배열 비교용

		char[] chArr = { 'A', 'D', 'C', 'B', 'E' };									//	chArr 배열에서 'B'를 binarySearch() 메소드를 이용하여 위치를 출력
		System.out.println("chArr : " +Arrays.toString(chArr));						//	chArr : [A, D, C, B, E]
		System.out.println("index of 'B' : " +Arrays.binarySearch(chArr,'B'));		//	index of 'B' : -2(정렬이 되어있지 않으므로 'B'의 위치를 찾을 수 없음)
		System.out.println("= After sorting =");	
		Arrays.sort(chArr);															//	오름차순 정렬
		System.out.println("chArr : " + Arrays.toString(chArr));					//	chArr : [A, B, C, D, E]
		System.out.println("index of 'B' : " + Arrays.binarySearch(chArr,'B'));		//	index of 'B' : 1
																					//	binarySearch() : 오름차순 정렬된 상태에서 이분 검색으로 데이터의 위치 리턴
		List list1 = Arrays.asList("a", "b", "c", "d");								//	입력받은 데이터 들을 List로 생성(단, List에 대한 추가나 삭제등의 작업 불가)
		
		for(int i = 0 ; i < list1.size() ; i++) {
			if(i==0) System.out.print("list1 : ");
		System.out.print(list1.get(i) + " ");										//	a b c d
		}
		System.out.println();

		System.out.print("list1 : ");
		ListIterator lit = list1.listIterator();
		while (lit.hasNext()) {
			System.out.print(lit.next() + " ");										//	a b c d
		}
		System.out.println();														
		List list2 = new ArrayList(Arrays.asList("a", "b", "c", "d"));				//	asList()로 만든 리스트에 추가나 삭제가 필요하면 직접 생성해야 함
		list2.add("z");																//	asList() 메스드의 리턴타입이 List이므로 Collection을 사용하는
		for(int i = 0 ; i < list2.size() ; i++) {									//	ArrayList 생성자 사용가능(List는 Collection을 상속받으므로)
			if(i==0) System.out.print("list2 : ");
		System.out.print(list2.get(i) + " ");										//	a b c d z
		}
		System.out.println();

		System.out.print("list2 : ");
		ListIterator lit2 = list2.listIterator();
		while (lit2.hasNext()) {
			System.out.print(lit2.next() + " ");									//	a b c d z
		}		
	}
}
