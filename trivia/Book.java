package trivia;

import java.io.Serializable;

public class Book implements Serializable,Cloneable, Comparable<Book> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private int id;
	private String description;
	private String author;
	
	public Book() {
		
	}
	public Book(String name) {
		this.name = name;
	}
	public Book(String name, int id) {
		this(name);
		this.id= id;
	}
	public Book(String name, int id, String description) {
		this(name, id);
		this.description = description;
	}
	public Book(String name,int  id, String description, String author) {
		this(name, id, description);
		this.author = author;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	@Override
	public String toString() {
		return "Name=" + name + "id" + id + "description=" + description + "author=" + author;
	}
	public boolean equals(Object o) {
		if(this == o) return true;
		if(!(o instanceof Book))return false;
		Book b = (Book) o;
		return id == b.getId();
		
	}
	public int compareTo(Book b) {
		return this.getName().compareTo(b.getName());
	}
	public Book clone() throws CloneNotSupportedException{
		Book cloned = (Book) super.clone();	
		cloned.author = this.author;
		cloned.description = this.description;
		cloned.id = this.id;
		cloned.name = this.name;
		return cloned;
	}
}
