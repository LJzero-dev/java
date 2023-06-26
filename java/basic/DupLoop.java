class DupLoop{
	public static void main(String[] args){
		for (int i = 0; i < 3 ; i++){
			System.out.println("변수 i의 값 : " + i);
			System.out.print("j :");
			for (int j = 0 ; j < 3 ; j++){
				System.out.print(j + " ");
			}
			System.out.println();
		}	
		
		/* 2~4단 까지의 구구단 출력 - 중첩 for문 사용
		2 X 1 = 2
		...
		2 X 9 = 18
		3 x 1 = 3
		...
		
		

		for(int i=2; i<=4 ; i++){
			System.out.println("구구단 " + i + "단");
			for(int j=1; j<=9; j++)
				System.out.println(i + " X " + j + " = " + i*j);			
		}
		*/
		/* 구구단 출력(2~5단)
		2 X 1 = 2 3 X 1 = 3		...		5 X 1 = 5
		...
		2 X 9 = 18 3 X 9 = 27	...		5 X 9 = 45
		*/
		for(int i=1; i<=9 ; i++){			
			for(int j=2; j<=5; j++){
				System.out.print(j + " X " + i + " = " + i*j + (i*j<10 ? "   " : "  "));		
			}
			System.out.println();
		}
	}
}
