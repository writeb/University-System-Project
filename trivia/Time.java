package trivia;

import java.io.Serializable;

public class Time implements Serializable,Comparable<Time>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int hour;
	int duration;
	public Time() {
		
	}
	public Time(int hour, int duration) {
		this.hour = hour;
		setDuration(duration);
	}
	public String toString() {
		return this.hour+":"+"00"+", "+"duration: "+ this.getDuration();
	}
	public boolean equals(Time b) {
		return this.hour==b.hour && this.duration==b.getDuration();
	}
	public int getEndHour() {
		return this.hour+this.duration;
	}
	public int getHour() {
		return this.hour;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public int getDuration() {
		return this.duration ;
	}
	@Override
	public int compareTo(Time o) {
		Time t = (Time) o;
		if(this.hour<t.getHour()) {
			return -1;
		}
		else if(this.hour>t.getHour()) {
			return 1;
		}else {
			if(this.getEndHour()<t.getEndHour()) {
				return -1;
			}
			else if(this.getEndHour()>t.getEndHour()) {
				return 1;
			}
			return 0;
		}
	} 
}
