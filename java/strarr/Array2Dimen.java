class Array2Dimen{
	public static void main(String[] args){
		int[][] arr = new int[3][4];												//	int형 데이터 12개를 저장할 수 있는 3행 4열 짜리 2차원 배열 생성

		for(int i = 0 ; i < arr.length ; i++){
			for(int j = 0; j < arr[i].length ; j++){
				arr[i][j] = i + j;
			}
		}

		for(int i = 0 ; i < arr.length ; i++){
			for(int j = 0; j < arr[i].length ; j++){
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}

		int[][] arr2 = {
			{1, 2},
			{3, 4, 5},
			{6, 7, 8, 9}
		};																			//	2차원 배열에 들어가는 1차원 배열들의 크기가 각각 달라도 무방
		System.out.println("arr2 배열의 행 수 : " + arr2.length);					//	arr2 배열의 행 수 : 3
		for(int i = 0 ; i < arr2.length ; i++){
			System.out.println(i + 1 + "행의 길이(열 수) : " + arr2[i].length);		/*
																					1행의 길이(열 수) : 2
																					2행의 길이(열 수) : 3
																					3행의 길이(열 수) : 4
																					*/
			}
		}
	}

