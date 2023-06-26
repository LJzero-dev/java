import java.util.*;//	총 10자의 임시 암호 생성(영문+숫자) : 첫글자는 영문		//	1~10 사이의 정수들 중 3개를 무작위로 추출하여 출력 : 단, 홀수가 짝수가 두 배 높은 확률로 나와야 함

class RandomPassword {
	public static void main(String[] args) {
		Random rnd = new Random();
		System.out.print("당신의 임시 암호는 : ");
		char[] arr = new char[10];
		for(int i = 1; i < 10; i++) {
			char numChar = (char)(rnd.nextInt(10)+48);
			char strChar = (char)(rnd.nextInt(26)+65);
			arr[0]=strChar;
				if(rnd.nextInt(2)==1)	arr[i]=numChar;
				else					arr[i]=strChar;
		}
		for(int i = 0 ; i<10; i++){
			System.out.print(arr[i]);
		}


		char[] arr2 = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
		String pwd = arr2[rnd.nextInt(26)]+"";
		for (int i = 1 ; i < 10 ; i++ ) {
			pwd += arr2[rnd.nextInt(arr2.length)];
		}
		System.out.println("\n"+pwd.toUpperCase());

		
		int[] arrInt = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 3, 5, 7, 9};
		for(int i = 0 ; i < 3 ; i++){
			System.out.print(arrInt[arrInt[rnd.nextInt(arrInt.length)]] + "	");
		}
	}
}
/*				
48이상 숫자
57이하 숫자

65이상
90이하

97이상
122이하
*/