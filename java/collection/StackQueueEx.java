import java.util.*;

class StackQueueEx {
	public static void main(String[] args) {
															// Stack st와 Queue를 각각 생성한 후 "0" , "1" , "2"를 차례로 저장한 후 출력
		Stack st = new Stack();
		Queue q = new LinkedList();							//	Queue는 인터페이스므로 Queue를 implements한 LinkedList로 생성

		st.push("0");	st.push("1");	st.push("2");
		q.offer("0");	q.offer("1");	q.offer("2");

		while (!st.empty())	{
		System.out.print("= Stack =" + st.pop() + "  ");	//	= Stack =2  = Stack =1  = Stack =0
		}													//	Stack은 저장한 역순으로 데이터들이 추출됨
		while (!q.isEmpty()) {
		System.out.print("= Queue =" + q.poll() + "  ");	//	Queue =0  = Queue =1  = Queue =2
		}													//	Queue는 저장한 순서대로 데이터들이 추출됨		
	}
}
