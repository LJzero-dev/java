package vo;

public class PageInfo {	// 게시판 목록, 상품 목록 등에서 페이징에 필요한 정보들을 저장할 클래스
	private int cpage, pcnt, spage, psize, rcnt, bsize,num;
	// 현재 페이지 번호, 페이지 수, 시작헤이지, 게시글 수, 페이지 크기, 블록 크기, 번호
	private String schtype, keyword, args, schargs, obargs, vargs, pcb, pcs, sch, ob, v;
	
	
	public PageInfo(String schtype, String keyword) {
		this.schtype = schtype;	this.keyword = keyword;
	}

	public PageInfo() {
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getCpage() {
		return cpage;
	}
	public void setCpage(int cpage) {
		this.cpage = cpage;
	}	
	public int getSpage() {
		return spage;
	}
	public void setSpage(int spage) {
		this.spage = spage;
	}
	public int getPsize() {
		return psize;
	}
	public void setPsize(int psize) {
		this.psize = psize;
	}
	public int getBsize() {
		return bsize;
	}
	public void setBsize(int bsize) {
		this.bsize = bsize;
	}
	public int getRcnt() {
		return rcnt;
	}
	public void setRcnt(int rcnt) {
		this.rcnt = rcnt;
	}
	public int getPcnt() {
		return pcnt;
	}
	public void setPcnt(int pcnt) {
		this.pcnt = pcnt;
	}
	public String getSchtype() {
		return schtype;
	}
	public void setSchtype(String schtype) {
		this.schtype = schtype;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getArgs() {
		return args;
	}
	public void setArgs(String args) {
		this.args = args;
	}
	public String getSchargs() {
		return schargs;
	}	
	public String getObargs() {
		return obargs;
	}
	public void setObargs(String obargs) {
		this.obargs = obargs;
	}
	public String getVargs() {
		return vargs;
	}
	public void setVargs(String vargs) {
		this.vargs = vargs;
	}
	public void setSchargs(String schargs) {
		this.schargs = schargs;
	}
	public String getPcb() {
		return pcb;
	}
	public void setPcb(String pcb) {
		this.pcb = pcb;
	}
	public String getPcs() {
		return pcs;
	}
	public void setPcs(String pcs) {
		this.pcs = pcs;
	}
	public String getSch() {
		return sch;
	}
	public void setSch(String sch) {
		this.sch = sch;
	}
	public String getOb() {
		return ob;
	}
	public void setOb(String ob) {
		this.ob = ob;
	}
	public String getV() {
		return v;
	}
	public void setV(String v) {
		this.v = v;
	}	
	
}