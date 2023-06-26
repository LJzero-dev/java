class BreakLabel{
	public static void main(String[] args){
		//	i와 j의 값이 둘 다 짝수일 경우 출력을 멈춤 -> [1, 1] [1, 2]
		for(int i=1; i<=4 ; i++){	
			for(int j=1; j<=4; j++){
				System.out.println("[" + i + ", " + j + "]");
				if (i % 2 == 0 && j % 2 ==2)	break;
				// 중첩 루프문에서 break를 사용하면 현재 속해있는 루프문만을 빠져나감
			}				
		}
		outerLoop:	//	특정 루프문을 표시해주는 레이블(lable)
		for(int i=1; i<4 ; i++){
			for(int j=1; j<4; j++){
				System.out.println("[" + i + ", " + j + "]");
				if (i % 2 == 0 && j % 2 ==0)	break outerLoop;
				// outerLoop라는 레이블을 가진 루프문을 빠져나가라는 의미
			}
		}
	}
}
