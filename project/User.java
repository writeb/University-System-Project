package project;

import java.io.Serializable;

import trivia.News;

public abstract class User implements Serializable,UserInterface{
	
	private static final long serialVersionUID = 1L;
	private String name;
	private String login;
	private String password;
	private String actions;
	private int id;
	private static int nextId=1;
	{
		id = nextId++;
	}
	public User() {}
	public User(String name , String login, String password) {
		this.name = name;
		this.login = login;
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.notifyAdmin("setting name, ");
		this.name = name;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.notifyAdmin("setting login, ");
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.notifyAdmin("setting password, ");
		this.password = password;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	@Override
	public String toString() {
		this.notifyAdmin("toString, ");
		return "Name:" + name + ", login:" + login + ", password:" + password+", id:"+id;
	}
	public void seeNews() {
		this.notifyAdmin("See news, ");
		News.seeNews();
	}
	public void notifyAdmin(String action) {
		this.actions+=" "+action;
	}
	public String getActions() {
		 return this.actions;
	}
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof User)) return false;
		User oth = (User)o;
		return oth.getId()==this.getId();
	}
}