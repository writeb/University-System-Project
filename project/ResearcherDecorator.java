package project;

import java.io.Serializable;

import trivia.News;

public class ResearcherDecorator implements Serializable,UserInterface{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final UserInterface decoratedUser;
	
	public ResearcherDecorator(UserInterface u) {
		this.decoratedUser=u;
	}
	@Override
	public void seeNews() {
		News.seeNews();
	}

	@Override
	public String getActions() {
		return this.getActions();
	}
	public String toString() {
		return this.decoratedUser.toString()+", Researcher";
	}
	@Override
	public String getName() {
		return this.getName();
	}
	@Override
	public void setName(String name) {
		this.decoratedUser.setName(name);
	}
	@Override
	public String getLogin() {
		return this.decoratedUser.getLogin();
	}
	@Override
	public void setLogin(String login) {
		this.decoratedUser.setLogin(login);
	}
	@Override
	public String getPassword() {
		return this.decoratedUser.getPassword();
	}
	@Override
	public void setPassword(String password) {
		this.decoratedUser.setPassword(password);
	}
	@Override
	public void setId(int id) {
		this.decoratedUser.setId(id);
	}
	@Override
	public int getId() {
		return this.decoratedUser.getId();
	}
	public UserInterface getUser() {
		return this.decoratedUser;
	}

}
