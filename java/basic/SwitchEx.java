class SwitchEx{
	public static void main(String[] args){
		int num = 2;
		
		switch (num){
		case 1:
			System.out.println("num 값은 1");	break;
		case 2:
			System.out.println("num 값은 2");	break;
		case 3:
			System.out.println("num 값은 3");	break;
		default:
			System.out.println("num 값은 1,2,3은 아니야");		
		}/*
		int score = 77, gread,gradeScore;
		// score 점수를 이용하여 학점을 출력하는 switch문 작성
		//gread = score>=(90 ? 1 : (score>=(80 ? 2 : (score>=(70 ? 3 : (score>=(80 ? 1 : ()))))
		int gradeScore=score/10;
				
		switch (gread){
			for(int i = 10;i<5;i--){}
		case 9: case 10:
			greadScore=+1;
			System.out.println("너의 학점은 : " + gradeScore + " 학점 이야");	break;
		case 8:
			greadScore=+2;
			System.out.println("너의 학점은 : " + gradeScore + " 학점 이야");	break;	
		case 7:
			greadScore=+3;
			System.out.println("너의 학점은 : " + gradeScore + " 학점 이야");	break;			
		case 6:
			greadScore=+4;	
			System.out.println("너의 학점은 : " + gradeScore + " 학점 이야");	break;				
		case 5:
			greadScore=+5;
			System.out.println("너의 학점은 : " + gradeScore + " 학점 이야");	break;			
		}*/

		switch ("bb"){
		case "ab":
			System.out.println("값은 ab");	break;
		case "bb":
			System.out.println("값은 bb");	break;
		case "cb":
			System.out.println("값은 cb");	break;
		}
		
		}
	}

