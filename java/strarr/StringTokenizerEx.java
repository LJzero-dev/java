import java.util.*;

class StringTokenizerEx{
	public static void main(String[] args){
		String data = "11 22 33";
		String[] arrData = data.split(" ");
		
		
																						// data 문자열을 띄어쓰기를 기준으로 문자열 배열로 만들어 각 데이터를 출력(가로로)
		for(String x : arrData)System.out.print(x + " ");
		System.out.println();

																						// 위와 동일한 작업을 StringTokenizer를 이용하여 작업
		StringTokenizer st = new StringTokenizer(data);
																						// StringTokenizer 인스턴스 생성 시 특정 구분자를 지정하지 않으면 띄어쓰기를 기준으로 잘라냄
		while (st.hasMoreElements())	System.out.print(st.nextElement() + " "); 
		System.out.println();
		while (st.hasMoreElements())	System.out.print(st.nextElement() + " "); 
		System.out.println();
																						//	StringTokenizer는 한 번만 루프를 돌릴 수 있으며, 다시 돌리려면 새로 만들거나 배열에 담아야 함

		String data2 = "1+2-3*4/5";
		StringTokenizer st2 = new StringTokenizer(data2, "+-*/");
		while (st2.hasMoreElements())	System.out.print(st2.nextElement() + " ");		//	1 2 3 4 5
		System.out.println();
		
		String data3 = "1+2-3*4/5";
		StringTokenizer st3 = new StringTokenizer(data3, "+-*/", true);					//	true : 구분자들도 토큰으로 취급됨
		while (st3.hasMoreElements())	System.out.print(st3.nextElement() + " ");		//	1 + 2 - 3 * 4 / 5
		System.out.println();

		
	}
}
//	오픈 api 및 현장 개발 api의 활용 능력 포트폴리오 에서의 본인 파트 및 실질적인 작업부분 구현 가능한지	개발함에 있어서의 경험 