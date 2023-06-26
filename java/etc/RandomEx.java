import java.util.*;

class RandomEx{
	public static void main(String[] args) {
		Random rnd = new Random();
		System.out.println("난수 : " + rnd.nextDouble());	//	0이상 1미만의 난수 출력

		//	0이상 100미만의 정수 10개를 무작위로 출력
		for (int i = 0; i < 10 ;i++ ) {
			int rndNum = rnd.nextInt(100);
			System.out.print(rndNum + " ");
		}
		System.out.println();

		// 최소값과 최대값을 입력받아 최소값 이상 최대값 이하의 난수를 5개 출력
		Scanner sc = new Scanner(System.in);
		System.out.print("최소값 : ");		int num1 = sc.nextInt();
		System.out.print("최대값 : ");		int num2 = sc.nextInt();
		for (int i = 0;i < 50 ;i++ )	{
			int num = rnd.nextInt(num2 - num1 +1);
			num += num1;
			System.out.print(num + " ");
		}
	}
}
