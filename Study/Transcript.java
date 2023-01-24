package Study;

import java.io.Serializable;
import java.util.Vector;

public class Transcript implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Vector <Mark> marks;
	
	public Transcript() {};
	
	public void view() {
		for (Mark m : marks) {
			m.viewMark();
		}
	}
	public void addMark(int mark) {
		marks.add(new Mark(mark));
	}
	public int calculate() {
		int res = 0;
		for(Mark m: marks) {
			res+=m.getMark();
		}
		return res;
	}
}
