package project;

import java.io.Serializable;

import trivia.Project;

public class withResearcher extends ResearcherDecorator implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Project research;
	public withResearcher(UserInterface u) {
		super(u);
	}
	public withResearcher(UserInterface u, Project p) {
		super(u);
		this.research=p;
	}
	public void researching() {
		System.out.println(research.getName() + " researching");
	}
	public void showProject() {
		System.out.println(research.toString());
	}
}
