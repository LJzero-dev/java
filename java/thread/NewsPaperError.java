class NewsPaper {
	String todayNews;
	public void setTodayNews(String news) { todayNews = news; }
	public String getTodayNews() { return todayNews; }
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

class NewsPaperError {
	public static void main(String[] args) {
		NewsPaper paper = new NewsPaper();
		NewsWriter writer = new NewsWriter(paper);
		NewsReader reader = new NewsReader(paper);

		writer.start();	reader.start();

		try {
			writer.join();	reader.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
