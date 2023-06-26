import java.math.*;

class BigDecimalEx{
	public static void main(String[] args) {
		double d1 = 1.6, d2 = 0.1;
		System.out.println("1.6 + 0.1 : " + (d1 + d2));			//	1.6 + 0.1 : 1.7000000000000002
		System.out.println("1.6 * 0.1 : " + (d1 * d2));			//	1.6 * 0.1 : 0.16000000000000003
		//	자바에서의 실수는 정확한 연산보다 실수표현 범위에 좀 더 신경을 써서 연산결과가 정확하지 않음

		BigDecimal d3 = new BigDecimal(1.6);
		BigDecimal d4 = new BigDecimal(0.1);
		System.out.println("1.6 + 0.1 : " + (d3.add(d4)));		//	1.7000000000000000943689570931383059360086917877197265625
		System.out.println("1.6 * 0.1 : " + (d3.multiply(d4)));	//	0.1600000000000000177635683940025051398161724525855033823303533017413935457540219431393779814243316650390625
		//	BigDecimal 인스턴스 생성전에 이미 double형 데이터를 사용했으므로 정확한 연산이 불가능
		BigDecimal d5 = new BigDecimal("1.6");
		BigDecimal d6 = new BigDecimal("0.1");
		System.out.println("1.6 + 0.1 : " + (d5.add(d6)));		//	1.7
		System.out.println("1.6 * 0.1 : " + (d5.multiply(d6)));	//	0.16
		//	BigDecimal 인스턴스 생성시에는 문자열로 실수를 표현해야 정확한 연산이 가능함	
	}
}
