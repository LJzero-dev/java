class ForEx{
	public static void main(String[] args){
		for(int i=1;i<=3;i++){
		System.out.println("I like Java" + i);
		}

		int n;
		for(n=1;n<=5;n+=2){
		// 외부 변수를 사용할 경우 초기화만 하면 됨
			System.out.print(n+"\n");	// 1, 3, 5	
		}
		System.out.print(n+"\n");		// 7

		int m = 1;
		for(; m <= 5 ; m += 2){
		// 외부 변수 사용 시 초기화가 되어 있으면 변수 선언 및 초기화 부분을 생략할 수 있음
			System.out.print(m+"\n");	// 1, 3, 5
		}
		System.out.print(m+"\n");		// 7


		int j = 10;
		for(int i = 0; i<=4; i++){
			j--;
			System.out.println("i : " + i +", j :"+j );			
		}

		for(int i = 0, j = 9; i<=4; i++,j--){
			// 쉼표로 구분하면 여러 개의 변수를 사용할 수 있음(증감식 포함)
			System.out.println("i : " + i +", j :"+j );
		}



		/*
		i : 0, j :9
		i : 1, j :8
		i : 2, j :7
		i : 3, j :6
		i : 4, j :5

		*/
	}
}
