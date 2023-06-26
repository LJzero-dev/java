class Gun {
	int bullet;
	Gun(int num) { bullet = num; }
	public void shot() {
		System.out.println("BBANG!!");	bullet--;
	}
}

class Police extends Gun {		//	Police extends Gun(Police는 Gun을 소유한다는 관계 성립)
	int handcuff;				//	모든  Police가 Gun을 소유해야만 성립되는 관계가 됨
	Police(int num, int hcuff){	//	만약 Gun을 소유하지 않는 Police가 있다면 그 Police의 인스턴스는 생성할 수 없음
		super(num);	handcuff = hcuff;
	}

	public void putHandcuff() {
		System.out.println("SNAP!");
		handcuff--;
	}
}

class  HASInheritance {
	public static void main(String[] args) {
		Police pman = new Police(5, 3);
		pman.shot();
		pman.putHandcuff();
	}
}
