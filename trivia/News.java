package trivia;

import java.io.Serializable;
import java.time.Instant;


public class News implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static News instance = null;
	private static String news;
	private News() {}
	{
		
	}
	public static News getInstance() {
		if(instance==null) {
			instance = new News();
		}
		return instance;
	}
	public static void setNews(String NewNews) {
		NewNews+=" "+Instant.now().toString();
		news=NewNews+"\n"+news;
	}
	public static String getNews() {
		return news;
	}
	public static void seeNews() {
		System.out.println(news);
	}
}
