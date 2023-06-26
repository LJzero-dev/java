class SimpleMath{
	public static final double PI = 3.1415;
    public static double add(double n1, double n2) { return n1 + n2;}
    public static double mul(double n1, double n2) { return n1 * n2;}
    
}

class AreaMath{
	public static double claCircleArea(double rad){		
		return SimpleMath.mul(SimpleMath.mul(rad,rad),SimpleMath.PI);

		/*
		SimpleMath sm = new SimpleMath();
		double result = sm.mul(rad, rad);
		result = sm.mul(result, sm.PI);
		return result;
		*/
	}
	public static double calRectArea(double width, double height){		
		return SimpleMath.mul(width,height);					
		
		/*
		SimpleMath sm = new SimpleMath();
		return sm.mul(width,height);
		*/

	}
}

class  ClassMethod2{
	public static void main(String[] args){
	//	AreaMath am = new AreaMath();
		System.out.println("원의 넓이 : " + AreaMath.claCircleArea(2.4));
		System.out.println("직사각형의 넓이 : " + AreaMath.calRectArea(2.0,4.0));
	}
}
