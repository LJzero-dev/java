class FruitSeller{					
	int numOfApples;			
	int	myMoney;			
	final int APPLE_PRICE;											
					
	public FruitSeller(int num,int money, int price){
		numOfApples = num;
		myMoney = money;
		APPLE_PRICE = price;		
	}																
/*
	public void initMember(int num,int money, int price) {		
		numOfApples = num;
		myMoney = money;
		APPLE_PRICE = price;
	}
*/
	public int saleApple(int money) {	
		int num = money / APPLE_PRICE;	
		myMoney += money;				
		numOfApples -= num;				
		return num;						
	}
	public void showSaleResult() {
		System.out.println("보유 사과 : " + numOfApples);
		System.out.println("판매 수익 : " + myMoney);
	}
}

class FruitBuyer {
	int numOfApples;
	int myMoney;

		public FruitBuyer(int num,int money){
		numOfApples = num;
		myMoney = money;	
	}		

	public void buyApple(FruitSeller seller,int money) {
		numOfApples += seller.saleApple(money);	
		myMoney -= money;						
	}

	public void showBuyResult() {
		System.out.println("보유 사과 : " + numOfApples);
		System.out.println("현재 잔액 : " + myMoney);
	}
}

class FruitSalesMain3{
	public static void main(String[] args) {
		FruitSeller seller1 = new FruitSeller(30, 0, 1500);
		FruitSeller seller2 = new FruitSeller(20, 0, 1000);
		FruitBuyer buyer = new FruitBuyer(0, 10000);		
										
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
