class IfEx{
	public static void main(String[] args){
		int num = 120;
		if (num < 0){
			System.out.println("0 미만");
		} else {
			System.out.println("0 이상");
			if(num < 100){
				System.out.println("0 이상 100 미만");
			} else {
				System.out.println("100 이상");							
			}
		}
		if(num >0 && num % 2 == 0){
		// num 변수의 값이 양수이면서 짝수인지를 검사하여 출력하는 if문 작성
		// 출력 값 : 120은 양수 이면서 짝수
					System.out.println(num + "은 양수 이면서 짝수");
		} else {
			System.out.println(num + "은 음수 또는 0이거나 홀수");			
		}
		// 120은 양수 이면서 짝수

		int score = 97;
		// score의 점수가 70이상이면 'C', 80이상이면 'B', 90이상이면 'A', 60이상이면 'D', 60미만이면 'F' 출력
		if(score>=90){
			System.out.println("A");	
		} else if(score>=80){
			System.out.println("B");	
		} else if(score>=70){
			System.out.println("C");	
		} else if(score>=60){
			System.out.println("D");				
		} else{
			System.out.println("F");			
		}
		// 이상이나 초과의 경우 높은 숫자부터 조건을 주고, 이하나 미만일 경우 낮은 숫자부터 조건을 줘야 정상작동함
	}
}

	