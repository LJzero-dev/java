class FruitSeller{					
	private int numOfApple;			
	private int	myMoney;			
	private final int APPLE_PRICE;											
					
	public FruitSeller(int num,int money, int price){
		numOfApple = num;
		myMoney = money;
		APPLE_PRICE = price;		
	}																
/*
	public void initMember(int num,int money, int price) {		
		numOfApple = num;
		myMoney = money;
		APPLE_PRICE = price;
	}
*/
	public int saleApple(int money) {	
		int num = money / APPLE_PRICE;	
		myMoney += money;				
		numOfApple -= num;				
		return num;						
	}
	public void showSaleResult() {
		System.out.println("보유 사과 : " + numOfApple);
		System.out.println("판매 수익 : " + myMoney);
	}
}

class FruitBuyer {
	private int numOfApple;
	private int myMoney;

		public FruitBuyer(int num,int money){
		numOfApple = num;
		myMoney = money;	
	}		

	public void buyApple(FruitSeller seller,int money) {
		numOfApple += seller.saleApple(money);	
		myMoney -= money;						
	}

	public void showBuyResult() {
		System.out.println("보유 사과 : " + numOfApple);
		System.out.println("현재 잔액 : " + myMoney);
	}
}

class FruitSalesMain5{
	public static void main(String[] args) {
		FruitSeller seller1 = new FruitSeller(30, 0, 1500);
		FruitSeller seller2 = new FruitSeller(20, 0, 1000);
		FruitBuyer buyer = new FruitBuyer(0, 10000);
/*
		seller1.myMoney += 500;		buyer.myMoney -= 500;
		seller1.numOfApple -= 20;	buyer.numOfApple += 20;		// private 접근지시 제어자로 인한 접근 불가로 컴파일 불가능함 오류코드로 나옴
		
		seller2.myMoney += 500;		buyer.myMoney -= 500;
		seller2.numOfApple -= 20;	buyer.numOfApple += 20;
*/
		buyer.buyApple(seller1, 4500);	
		buyer.buyApple(seller2, 2000);	
													
													
		System.out.println("사과 판매자1 현황");
		seller1.showSaleResult();				
													
													
		System.out.println("사과 판매자2 현황");
		seller2.showSaleResult();					

		System.out.println("사과 구매자 현황");		
		buyer.showBuyResult();
	}
}


/*
문제점
 - 인스턴스를 통해 멤버변수에 직접 접근하여 값을 자유롭게 변경 할 수 있음

해결책
 - 인스턴스의 멤버변수에는 직접적으로 접근할 수 없게 해야 함(정보 은닉)
 - Main5
*/