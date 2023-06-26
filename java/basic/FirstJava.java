/*
FirstJava.java 실행순서
C:\Users\Administrator>e:	// FirstJava.java가 저장된 e드라이브로 이동
e:\>cd LJY/java/basic		// FirstJava.java가 저장된 폴더로 이동
e:\LJY\java\basic>javac FirstJava.java를 컴파일 하여 FirstJava.class 생성
e:\LJY\java\basic>java FirstJava // 컴파일하여 생성된 클래스 파일을 실행시킴
*/
class FirstJava{
	public static void main(String[] args){
		System.out.print("Java를 자바라!!\n\n");
		System.out.println("2 + 5 =" + 2 + 5);		// 2 + 5 =25
		System.out.println("2 + 5 =" + (2 + 5));	// 2 + 5 =7
		System.out.println(2 + 5 + " = 2 + 5");		// 7 = 2 + 5
	}
}
