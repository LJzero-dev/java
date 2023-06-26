class ArrayEx2{
	public static void main(String[] args){
		int[] arrInt = {1,2,3,4,5,6};		//	arrInt 배열의 값들 중 짝수들만 출력하여 문자열로 만들어 출력
		String str = "";
		for (int i = 0;i < arrInt.length ;i++ )	{
			if(arrInt[i]%2==0){
				str +="," + arrInt[i];
			}
		}
		System.out.println(str.substring(1));			


		/*
		for(int i = 0; i < arrInt.length; i++){
			if (arrInt[i]%2==0)
				System.out.println(String.valueOf(arrInt[i]));
		}*/
			

		//	arrInt 배열의 값을 역순(6 5 4 3 2 1)로 출력(가로로)
		for(int i = arrInt.length-1 ; i >= 0 ; i--){
			System.out.print(arrInt[i] + " " );
		}










	}
}
