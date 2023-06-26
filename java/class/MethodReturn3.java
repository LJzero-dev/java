class MethodReturn3{
	public static void main(String[] args) {
		char grade = getGrade(78);
		System.out.println("학점은 '" + grade + "' 학점입니다.");

		int num = getNumber(5,7);
		if (num == -1){
			System.out.println("5와 7의 최소 공배수가 없습니다.");
		} else {			
			System.out.println("5와 7의 최소 공배수 : " + num);
		}
	}
	public static int getNumber(int num1, int num2){
	// 100 이하의 자연수들 중에서 5와 7의 최소 공배수를 찾아 리턴하는 메소드(없으면 -1을 리턴)
			for(int i=1;i<=100;i++){
				if(i % num1 == 0 && i % num2 == 0)return i;
				// 루프문에서 if문을 사용하여 조건에 따라 return 할 때 절대 else문을 사용하면 안됨
			}
			return -1;
			// 루프문은 그 자체로 들어가기 위한 조건이 있으므로 조건에 위배되면 return이 안될 수 있기 떄문에
			루프문 안에서 return 할 경우 반드시 루프문 밖에서도 return을 한번더 해줘야 함
	}

	public static char getGrade(int score){
	//	90 a	80 b	70 c	60 d	이하 f
		if (score >= 90){
			return 'A';
		} else if(score >=80){
			return 'B';
		} else if(score >=70){
			return 'C';
		} else if(score >=60){
			return 'D';
		} else {
			return 'F';
		}
		// if 문 안에서 return 할 경우 반드시 else문이 있거나 if문 밖에서 return 해야 함	
	}
}