import java.util.*;

class ArrayListLinkedList {
	public static void main(String[] args) {
		ArrayList a1 = new ArrayList(2000000);
		LinkedList l1 = new LinkedList();
		System.out.println("= 순차적으로 추가하기 =");
		System.out.println("ArrayList : " + add1(a1));
		System.out.println("LinkedList : " + add1(l1));
		System.out.println();
		System.out.println("= 중간에 추가하기 =");
		System.out.println("ArrayList : " + add2(a1));
		System.out.println("LinkedList : " + add2(l1));
		System.out.println();
		System.out.println("= 중간에 삭제하기 =");
		System.out.println("ArrayList : " + del2(a1));
		System.out.println("LinkedList : " + del2(l1));
		System.out.println();
		System.out.println("= 순차적으로 삭제하기 =");
		System.out.println("ArrayList : " + del1(a1));
		System.out.println("LinkedList : " + del1(l1));
	}
	//	add1() : 100만개의 데이터(i + "") 추가
	public static long add1(List list) {
		long start = System.currentTimeMillis();
		for (int i = 0; i < 1000000 ;i++ ) {	list.add(i + ""); }
		long end = System.currentTimeMillis();
		return end - start;
	}
	//	add2() : 10000번에 걸쳐 500번 인덱스에 "X"추가
	public static long add2(List list) {
		long start = System.currentTimeMillis();
		for (int i = 0; i < 10000 ;i++ ) { list.add(500, "X"); }
		long end = System.currentTimeMillis();
		return end - start;
	}
	//	del1() : 모든 데이터 삭제(for문을 이용하여 remove()로 하나씩 삭제)
	public static long del1(List list) {
		long start = System.currentTimeMillis();
		for (int i = list.size()-1; i >= 0 ;i-- ) { list.remove(i); }
		long end = System.currentTimeMillis();
		return end - start;
	}
	//	del2() : 1000번 인덱스 이하의 데이터 삭제(for문을 이용하여 remove()로 하나씩 삭제)
	public static long del2(List list) {
		long start = System.currentTimeMillis();
		for (int i = 0; i <= 1000 ;i++ ) { list.remove(i); }
		long end = System.currentTimeMillis();
		return end - start;
	}
}
