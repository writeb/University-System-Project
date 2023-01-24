package trivia;

import java.io.Serializable;

import project.Days;
import project.DurationFormat;
import project.Format;


public class Lesson implements Serializable,Comparable<Lesson>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	Days day;
	private Time time;
	Format format;
	DurationFormat practice;
	private Room room;
	public Lesson() {}
	public Lesson(String name, Days day, Time time) {
		this.name = name;
		this.day = day;
		this.time = time;
	}
	public Lesson(String name, Days day, Time time, Format format)
	{
		this(name, day, time);
		this.format = format;
	}
	public Lesson(String name, Days day, Time time, Format format, DurationFormat practice)
	{
		this(name, day, time,format);
		this.practice = practice;
	}
	public Lesson(String name, Days day, Time time, Format format, DurationFormat practice,Room room)
	{
		this(name, day, time, format,practice);
		if(format==Format.OFFLINE) {
			this.room = room;
		}
		else if(format==Format.ONLINE && (practice==DurationFormat.PRACTICE || practice==DurationFormat.LAB)) {
			this.room=room;
		}
	}
	public String getName() {
		return name;
	}
	public Room getRoom() {
		return this.room;
	}
	public Time getTime() {
		return time;
	}
	public Days getDay() {
		return this.day;
	}
	public void setRoom(Room room) {
		this.room = room;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setTime(Time time) {
		this.time = time;
	}
	public String toString() {
		return "Lesson "+ name+ ", "+day + ", "+format + ", "+time + "," + practice +", " + room;
	}
	@Override
	public int compareTo(Lesson l) {
		if(this.day.ordinal()<l.getDay().ordinal()) {
			return -1;
		}
		else if(this.day.ordinal()<l.getDay().ordinal()) {
			return 1;
		}
		return this.time.compareTo(l.getTime());
	}
	
	
}
