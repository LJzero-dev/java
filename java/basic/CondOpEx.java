class CondOpEx{
	public static void main(String[] args){
		int n1 = 20, n2= 20, result;
		// n1과 n2 중 더 큰 수를 찾아 result에 저장한 후 출력(if문 사용)

		
		result = n2;
		if (n1 == n2) result = 0;
		if (n1 > n2) result = n1;
		System.out.println("result1 : " + result); // result1 : 20
		
		result = 0;
		//result = n1 > n2 ? n1 : n2;
		System.out.println("result2 : " + result); // result2 : 20
		System.out.println("result3 : " + (result = n1 == n2 ? 0 : (n1 > n2 ? n1 : n2) )); // result3 : 20		
	}
}
