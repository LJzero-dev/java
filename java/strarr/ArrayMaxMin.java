class Max {
	public static int 
}

import java.util.*;
//	사용자에게 5개의 정수를 입력받아 배열에 저장함
//	저장된 배열에서 가장 큰 값과 자은 값을 구하는 메소드를 작성하여 출력
class ArrayMaxMin {
	public static void main(String[] args) {
		/*
		System.out.print("정수를 입력해 주세요");
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		char[] arr = str.toCharArray();
		//int[] arr = new int[5];
		char result=arr[0];
		for (int i =0;i<arr.length ;i++ ) {
			for(int j=0;j<arr.length;j++) {
				if(arr[j]>arr[i]&&arr[j]>result)result = arr[j];
			}
		}System.out.print(result);*/
		
		int [] arr = new int[5];
		int result = 0;
		
		/*
		System.out.print("1번 정수를 입력해 주세요 >> ");
		arr[1] = sc2.nextInt();
		System.out.print("2번 정수를 입력해 주세요 >> ");
		arr[2] = sc2.nextInt();
		System.out.print("3번 정수를 입력해 주세요 >> ");
		arr[3] = sc2.nextInt();
		System.out.print("4번 정수를 입력해 주세요 >> ");
		arr[4] = sc2.nextInt();
		System.out.print("5번 정수를 입력해 주세요 >> ");
		int num5 = sc2.nextInt();
		*/
		Scanner sc2 = new Scanner(System.in);
		for(int i = 0; i<5; i++){
		System.out.print((i+1)+"번 정수를 입력해 주세요 >> ");
		arr[i] = sc2.nextInt();
		}
		for (int i=0;i<arr.length ;i++ ) {

			}
		}System.out.println(result);
	}
}
