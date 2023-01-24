package Study;

import java.io.Serializable;
import java.time.Instant;

public class Mark implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int mark;
	private Instant date;
	
	public Mark() {};
	public Mark(int mark) {
		this.mark = mark;
		date = Instant.now();
	}
	public void setMark(int mark) {
		this.mark = mark;
	}
	public int getMark() {
		return mark;
	}
	public void viewMark() {
		System.out.print("Mark - " + mark);
		System.out.println(", Date - " + date);
	}
}
