package project;

import java.io.Serializable;
import java.util.Vector ;

import trivia.News;
import trivia.Request; 
 
public class Department extends Employee implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	public Department() {}
	public Department(String name, String login, String password, int salary) {
		super(name, login, password, salary);
	}
	public Department(String name, String login, String password) {
		super(name, login, password);
	}
	public void statisticalReport () {
		Vector<Student> students = DataBase.getInstance().getStudents();
		double bestGrade=0;
		String bestGradeHolder="";
		double bestGradeHoldersId=0;
		double lowestGrade=100;
		String lowestGradeHolder="";
		double lowestGradeHoldersId=0;
		float average=0;
		for(int i=0;i<students.size();i++) {
			if(students.get(i).getAveragePoints()>bestGrade) {
				bestGrade=students.get(i).getAveragePoints();
				bestGradeHolder=students.get(i).getName();
				bestGradeHoldersId=students.get(i).getId();
			}
			else if(students.get(i).getAveragePoints()<lowestGrade) {
				lowestGrade=students.get(i).getAveragePoints();
				lowestGradeHolder=students.get(i).getName();
				lowestGradeHoldersId=students.get(i).getId();
			}
			average+=students.get(i).getAveragePoints();
		}
		average=average/students.size();
		System.out.print("Class average is "+average+". ");
		System.out.print("Lowest grade is "+lowestGrade);
		System.out.println(" ("+lowestGradeHolder+","+" id: "+lowestGradeHoldersId+")");
		System.out.print("Best grade is "+bestGrade);
		System.out.println(" ("+bestGradeHolder+","+" id: "+bestGradeHoldersId+")");
	}
	public void manageNews(String news) {
		News.setNews(News.getNews()+"\n"+news);
	}
	
	public static boolean approveRequest(Request request) {
		return request.getDeanSign();
	}
	
	public void viewInfo(User user) {
		User to = DataBase.getInstance().getUser(user);
		System.out.println(to.toString());
	}
	

}