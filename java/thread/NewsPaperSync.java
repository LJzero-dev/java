class NewsPaper {
	String todayNews;
	boolean isTodayNews = false;	//	기사의 유무를 판단할 변수
	public void setTodayNews(String news) {
		todayNews = news;
		isTodayNews = true;
		synchronized(this) {
			notifyAll();	//	wait() 상태의 모든 쓰레드를 깨움
		}
	}

	public String getTodayNews() { 
		if (!isTodayNews) {	//	현재 기사가 없으면
			try {
				synchronized(this) {
					wait();	//	현재 동작중인 쓰레드를 대기상태로 만드는 Object 클래스의 메소드로 notify~로 깨울 때 까지 대기상태로 있음
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return todayNews;
	}
}

class NewsWriter extends Thread {
	NewsPaper paper;
	public NewsWriter(NewsPaper paper) { this.paper = paper; }
	public void run() {
		paper.setTodayNews("주말에만 비 옴");
	}
}

class NewsReader extends Thread {
	NewsPaper paper;
	public NewsReader(NewsPaper paper) { this.paper = paper; }
	public void run() {
		paper.setTodayNews("오늘의 뉴스 : " + paper.getTodayNews());
	}
}

class NewsPaperSync {
	public static void main(String[] args) {
		NewsPaper paper = new NewsPaper();
		NewsWriter writer = new NewsWriter(paper);
		NewsReader reader1 = new NewsReader(paper);
		NewsReader reader2 = new NewsReader(paper);

		

		try {
			reader1.start();	reader2.start();
			Thread.sleep(1000);
			writer.start();	

			reader1.join();	reader2.join();	writer.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
