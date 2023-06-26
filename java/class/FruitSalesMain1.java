/* 사과 판매 및 구매 프로그램
사과 판매자 : class FruitSeller
 - 가져야 할 값(멤버변수, 멤버상수) : 사과보유개수, 사과 가격(정찰제), 매출액
 - 가져야 할 기능(메소드) : 판매(), 현상황보기()

사과 구매자 : class FruitBuyer
 - 가져야 할 값(멤버변수, 멤버상수) : 사과구매할 돈, 구매한 사과 개수
 - 가져야 할 기능(메소드) : 판매(), 현상황보기()

프로그램 제어 : class FruitSalesMain1
 - 판매자와 구매자의 인스턴스를 생성하여 사과 판매 및 구매를 시킥, 상황을 봄
*/
class FruitSeller{					// 사과 판매자 클래스
	int numOfApples = 20;			// 사과 보유 개수
	int	myMoney = 0;				// 매출액
	final int APPLE_PRICE = 1000;	// 사과 가격		

	public int saleApple(int money) {	//	사과 판매 메소드(구매자에게 사과값을 받아 그에 해당하는 사과개수를 리턴하는 메소드)
		int num = money / APPLE_PRICE;	//	판매할 사과 개수를 구하는 식으로 구매자가 지불한 돈만큼 사과개수를 구함
		myMoney += money;				//	구매자가 낸 돈만큼 매출액 증가
		numOfApples -= num;				//	판매한 사과개수 만큼 보유개수 감소
		return num;						//	구매자에게 사과를 넘김 - saleApple() 메소드를 호출한 곳으로 리턴
	}
	public void showSaleResult() {
		System.out.println("보유 사과 : " + numOfApples);
		System.out.println("판매 수익 : " + myMoney);
	}
}

class FruitBuyer {			// 사과 구매자 클래스
	int numOfApples = 0;	// 구매한 사과 개수
	int myMoney = 10000;	// 사과 구매할 돈

	public void buyApple(FruitSeller seller,int money) {
		numOfApples += seller.saleApple(money);		// 사과를 구매할 돈(money)을 인수로 하여 seller 인스턴스의 saleApple()메소드 호출		//	line 18
		myMoney -= money;							// 구매 후 보유금액에서 사과를 구매한 만큼 감소
	}

	public void showBuyResult() {
		System.out.println("보유 사과 : " + numOfApples);
		System.out.println("현재 잔액 : " + myMoney);
	}
}

class FruitSalesMain1{
	public static void main(String[] args) {
		FruitSeller seller = new FruitSeller();		//	FruitSeller 인스턴스 seller를 선언 및 생성										//	사과 판매자 (line 13)
		FruitBuyer buyer = new FruitBuyer();		//	FruitBuyer 인스턴스 Buyer 선언 및 생성											//	사과 판매자 (line 30)

		buyer.buyApple(seller, 2000);				//	buyer 인스턴스의 buyApple() 메소드 호출											//	(line 34)
													//	seller : 사과를 구매하려면 판매자가 필요하므로 판매자가 인스턴스인 seller를 가져감
													// 2000 :	사과를 구매할 돈
		System.out.println("사과 판매자 현황");
		seller.showSaleResult();																										//	(line 24)

		System.out.println("사과 구매자 현황");		
		buyer.showBuyResult();																											//	(line 39)	
	}
}

/*
문제점
 - 판매자나 구매자 인스턴스를 여럿 생성해도 모두 동일한 값(멤버변수)을 가지고 있음

해결책
 - 인스턴스 별로 멤버 변수의 값을 다르게 지정할 수 있어야 함
*/