class RuntimeExceptionCase {
	public static void main(String[] args) {

		try	{
			int[] arr = new int[3];
			arr[-1] = 20;
		} catch (ArrayIndexOutOfBoundsException e) {	//	배열의 인덱스 번호가 범위를 벗어났을 때 발생하는 예외
			System.out.println(e.getMessage());			//	Index -1 out of bounds for length 3
		}

		try	{
			Object obj = new int[10];
			String str = (String)obj;
		} catch (ClassCastException e)					//	불가능한 형 변환을 시행할 경우 발생하는 예외
		{
			System.out.println(e.getMessage());			//	class [I cannot be cast to class java.lang.String ([I and java.lang.String are in module java.base of loader 'bootstrap')
		}

		try	{
			int[] arr = new int[-10];
		} catch (NegativeArraySizeException e)			//	배열의 크기를 음수로 입력했을 떄 발생하는 예외
		{
			System.out.println(e.getMessage());			//	-10
		}

		try	{
			String str = null;
			int len = str.length();
		} catch (NullPointerException e)				//	객체가 비어있을 떄(null이 들어 있을 때) 객체를 사용하는 경우 발생하는 예외
		{
			System.out.println(e.getMessage());			//	Cannot invoke "String.length()" because "<local1>" is null
		}		
	}
}
