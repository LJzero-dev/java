class WhileDoEx{
	public static void main(String[] args){
		int num = 0, sum = 0;
			while (num < 3){
				num++;
			System.out.println("I like Java" + num);		
			}

			num = 1;
			while (num < 8){
				System.out.println("I like Java" + num);
				num+=2;
			}
				System.out.println("num : " + num); // num : 9
				
			while (num < 8){
				System.out.println("I like Java" + num);
				num+=2;	
			}		// num의 값이 9이므로 두번째 while문은 동작 안함

			do{
			System.out.println("I like Java" + num);
			num+=2;
			}while (num < 8);		// I like Java 9
			// do-while 이므로 num값에 상관없이 최초 한번은 작동함

			// 자연수 1부터 100까지의 합을 while문을 이용하여 구한 뒤 출력
			num = 1;						
			while(num <= 100){
			sum+=num;	num++;
			}
			System.out.println("자연수 1부터 100까지의 합 : " + sum); sum=0; // 자연수 1부터 100까지의 합 : 5050
	}
}