class MathodPrimeNumber{
	public static void main(String[] args){
		/* 1~100 사이의 정수들 중 소수를 구하여 출력
		단, 전달된 값이 소수인지 여부를 판단하는 메소드를 제작하여 작업
		*/
		for (int i = 1; i<=100 ;i++){
			if (isPrime(i)){
				System.out.print( i + " ");
			}
		}
	}
	public static boolean isPrime(int num){
	//	받아온 정수(n)가 소수인지 여부를 리턴하는 메소드
		if (num == 1 || (num !=2 && num % 2 == 0)){
			return false;
		}
		 for(int i = 3; i <= num/2; i += 2){
			if(num%i == 0) return false;
			}
				return true;
		}
}
