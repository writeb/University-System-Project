package trivia;

import java.io.Serializable;

public class Room implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int number;
	private int capacity;
	private int floor;
	public Room(){
		
	}
	public Room(int number){
		this();
		this.number = number;
	}
	public Room(int number, int capacity){
		this(number);
		this.capacity = capacity;
	}
	public Room(int number, int capacity, int floor){
		this(number,capacity);
		this.floor = floor;
	}
	public int getNumber() {
		return this.number;
	}
	public int getCapacity() {
		return this.capacity;
	}
	public int getFloor() {
		return this.floor;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public void setFloor(int floor) {
		this.floor = floor;
	}
	public void setRoom(int number, int capacity, int floor){
		this.number = number;
		this.capacity = capacity;
		this.floor = floor;
	}
	public String toString() {
		String s="number: "+number+", " +"capacity: "+capacity+", "+ "floor: "+floor+". ";
		return s;
	}

}
