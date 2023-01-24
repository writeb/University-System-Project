package trivia;

import java.io.Serializable;

public class Request implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	boolean deanSign;
	public Request() {}
	public Request(boolean deanSign) {
		this.deanSign = deanSign;
	}
	public boolean getDeanSign() {
		return this.deanSign;
	}
}
