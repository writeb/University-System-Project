package trivia;

import java.io.Serializable;

public class Project implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String description;
	
	public Project() {
		
	}
	public Project(String name) {
		this.name = name;
	}
	public Project(String name, String description) {
		this(name);
		this.description = description;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "project name=" + name + " Description=" + description;
	}
	
}
