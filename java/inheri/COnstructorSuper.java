class Car{
	int gasolineGauge;
	Car(int g) { gasolineGauge = g; }
}
class HybridCar extends Car{
	int electricGauge;
	HybridCar(int g, int e){ 
	super(g);
	electricGauge = e;
	}
}

class HybridWaterCar extends HybridCar{
	int waterGauge;
	HybridWaterCar(int g, int e, int w){
		super(g, e);
		waterGauge = w;
	}
	public void showCurrentGauge(){
		System.out.println("잔여 가솔린 : " + gasolineGauge);
		System.out.println("잔여 전기량 : " + electricGauge);
		System.out.println("잔여 워터량 : " + waterGauge);
	}
}

class ConstructorSuper{
	public static void main(String[] args) {
		HybridWaterCar hwc = new HybridWaterCar(5, 7, 3);
		hwc.showCurrentGauge();
	}
}
