class ArrayForEach{
	public static void main(String[] args){
		int sum = 0;
		int[] arr = {1, 2, 3, 4, 5};
		for(int x : arr){										//	arr 모든 요소들을 차례대로 변수 x에 넣으면서 루프를 돔
			sum += x;											//	무조건 처음부터 끝까지 루프를 돔(역방향이나 도는 횟수 등의 지정이 불가능)
		}
		System.out.println("배열 요소들의 합(for) : " + sum);

		// for-each문을 이용하여 arr배열의 모든 값에 1을 더하여 가로로 출력 (2 3 4 5 6)

		System.out.print("(");
		for(int x : arr){
			x++;
		System.out.print( x + " ");
		}
		System.out.print(")");
		
		System.out.println();

		for (int i = 0 ; i < arr.length ; i++ ){
			arr[i]++;	System.out.print(arr[i] + " ");			//	(2 3 4 5 6)
		}
		for(int x : arr){
			System.out.print(x + " ");							//	(2 3 4 5 6)
			}

	}
}
