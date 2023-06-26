class AccessWay{
	static int num = 0;
	AccessWay(){ incrCnt(); }
	public void incrCnt() { num++; }
}



class  ClassVarAccess {
	public static void main(String[] args){
		AccessWay.num++;					//	인스턴스 존재 여부와 상관 없이 클래스 멤버는 존재하고 있으므로 인스턴스 생성 전에 변화 가능
		AccessWay way = new AccessWay();
		way.num++;							//	인스턴스 통해서 클래스 멤버에 접근 가능
		AccessWay.num++;					//	클래스 통해서 멤버에 접근 가능 클래스 맴버기 떄문에 가능하면 클래스 통해 접근하는 편이 가시성이 좋음
		System.out.println("num : " + way.num);
	}
}
