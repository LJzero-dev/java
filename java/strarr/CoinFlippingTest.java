import java.util.*;
/*	정수를 입력받아 정수만큼의 랜덤숫자(1~50)를 출력한 후 짝수와 홀수가 각각 몇개인지 출력*/

class CoinFlippingTest {
	public static void main(String[] args) {
		System.out.print("동전 던지기 횟수 : ");
		Scanner sc = new Scanner(System.in);/*
		int amount = sc.nextInt();
		int num1 = 0, num2 = 0;
		ArrayList al = new ArrayList();
		for(int i = 0; i <amount ; i++) {
			al.add((int)(Math.random()*50)+1);			
			if ((int)(al.get(i))%2==1)	num1++;
			else						num2++;
		}
		Collections.sort(al);
		for(int i = 0 ; i <al.size(); i++) {
			System.out.print(al.get(i) + " ");
		}
		System.out.println();
		System.out.println("짝수 : " + num2 + "/ 홀수 : " + num1);*/
		int amount = sc.nextInt();
		int[] arrNum = new int[amount];	//	입력받은 개수만큼의 난수를 저장할 배열
		int even = 0;					//	짝수와 홀수의 개수를 저장할 변수
		
		for (int i = 0; i < amount ;i++ ) {
			arrNum[i] = (int)(Math.random() * 50 + 1);
			System.out.print(arrNum[i] + " ");
			if (arrNum[i]%2==0) even++;
		}
		System.out.println("\n짝수 : " + even + " / 홀수 : " + (amount-even));
	}
	
}
