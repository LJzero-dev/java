class StringEx5 {
	public static void main(String[] args) {
		/*	1~1000 사이의 정수들 중 8이 들어있는 숫자의 개수를 구하여 출력
		int count = 0;		String j;
		for(int i = 1; i<=1000; i++){
		if ( Integer.toString(i).indexOf('8')!=-1)count++;
		}
		System.out.print("8이 들어있는 숫자의 개수 : " + count);
		*/

		/*
		int count = 0;
		for(int i = 1; i<= 1000; i++){
			String tmp = i + "";
			if (tmp.indexOf('8')>= 0) count++;
		}
		System.out.print("8이 들어있는 숫자의 개수 : " + count);
*/
		//	1 ~ 1000 사이의 정수에 들어있는 8의 총 개수를 구하여 출력
		int count = 0;
		for(int i = 1; i<= 1000; i++){
			String tmp = i + "";
			for (int j = 0;j < tmp.length() ;j++ )	{
				if (tmp.charAt(j)=='8') count++;
			}
		}
		System.out.print("8이 들어있는 숫자의 개수 : " + count);
	}
}
