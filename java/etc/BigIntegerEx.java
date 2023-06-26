import java.math.*;

class BigIntegerEx{
	public static void main(String[] args) {
		System.out.println("기본 자료형 최대 정수 : " + Long.MAX_VALUE);	//	기본 자료형 최대 정수 : 9223372036854775807
		System.out.println("기본 자료형 최대 정수 : " + Long.MIN_VALUE);	//	기본 자료형 최대 정수 : -9223372036854775808

		BigInteger bigValue1 = new BigInteger("100000000000000000000");
		BigInteger bigValue2 = new BigInteger("-99999999999999999999");
		System.out.println(bigValue1.add("addResult " + bigValue2));			//	1
		System.out.println(bigValue1.multiply("multiplyResult " + bigValue2));	//	-9999999999999999999900000000000000000000

		//	bigValue1과 bigValue2를 각각 더하고, 곱한 결과를 출력
	}
}
