class BrakeContinue{
	public static void main(String[] args){
		int num1 = 1;
		while (num1 < 10){
			System.out.print(num1 + " ");
			if(num1 == 5) break;
			num1++;
		}
		System.out.println();

		// 100이하의 자연수 중 5와 7의 최소 공배수를 구하여 출력 - while문 이용
		int num2 = 1;
		while (num2 <= 100){
			if (num2 % 5 == 0 && num2 % 7 == 0){
				break;
			}			
			num2++;
		}
		System.out.println("5와 7의 최소 공배수 : " + num2);

		// 100이하의 자연수 중 5와 7의 공배수를 구하여 출력 - while문 이용
		int num3 = 0, count = 0;

		while (num3 < 100){
			num3++;
			if (num3 % 5 != 0 || num3 % 7 != 0){
				continue;
			}
			count++;
			System.out.println("5와 7의 최소 공배수 : " + num3);				
		}
		System.out.println("5와 7의 최소공배수 개수 : " + count);

	}
}

