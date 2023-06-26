import java.util.*;

class ExceptionUseTry {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr =new int[100];

		for (int i = 0 ; i < 3 ; i++ ) {
			try {
				System.out.print("나누어 지는 수 : ");		int n1 = sc.nextInt();
				System.out.print("나누는 수 : ");			int n2 = sc.nextInt();
				
				System.out.print("결과 저장 인덱스 : ");	int idx = sc.nextInt();

				arr[idx] = n1 / n2;
				System.out.println("나눗셈 결과 : " + arr[idx]);
				System.out.println("저장된 위치 : " + idx);				
				
			} catch (ArithmeticException e) {								//	try문 안에서 ArithmeticException이 발생할 경우 처리하는 영역
				System.out.println("나누는 수가 0이 될 수는 없습니다.");
				i--;
			}catch (ArrayIndexOutOfBoundsException e) {								
				System.out.println("유효하지 않은 인덱스 번호 입니다.");
				i--;
			}catch (Exception e) {											//	try문 안에서 Exception 발생할 경우 처리하는 영역
				System.out.println("예기치 않은 예외가 발생했습니다.");
				i--;
			}
		}
	}
}
