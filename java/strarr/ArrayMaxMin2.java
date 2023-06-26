import java.util.*;

class ArrayMaxMin2{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[5];
		for(int i = 0; i<arr.length; i++){
		System.out.print((i+1)+"번 정수를 입력해 주세요 >> ");
		arr[i] = sc.nextInt();
		}

		System.out.println("최소값 : " + minValue(arr));
		System.out.println("최대값 : " + maxValue(arr));
		System.out.println("홀수의 개수 : " + oddCount(arr));
	}
	public static int minValue(int[] arr) {
		int min = arr[0];						//	arr배열의 최소값을 저장할 변수로 배열 첫번째 값을 복사하여 다른 값들과 비교하면서 작업을 함
		for(int i=0 ; i < arr.length; i++){
			if(arr[i]<min)	min=arr[i];
		}return min;
	}

	public static int maxValue(int[] arr) {
		int max = arr[0];
		for(int i=0 ; i < arr.length; i++){
			if(arr[i]>max)	max=arr[i];
		}return max;
	}

	public static int oddCount(int[] arr){
		int cnt = 0;
		for(int i=0 ; i < arr.length; i++){
			if(arr[i]%2==1)	cnt++;
		}return cnt;
	}
}
