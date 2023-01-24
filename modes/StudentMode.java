package modes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

import Study.StudentMarks;
import Study.Teacher;
import project.Course;
import project.DataBase;
import project.Student;

public class StudentMode extends Mode{
	private Student student;
	StudentMode(){}
	StudentMode(Student student){
		this.student = student;
	}
	public void start() throws NumberFormatException, IOException {
		
		while(true) {
			System.out.println("0->Exit");
			System.out.println("1->Register for course");
			System.out.println("2->Pick lesson");
			System.out.println("3->View Transcript");
			System.out.println("4->View News");
			System.out.println("5->View info about Teacher");
			System.out.println("6->View marks for Course");
			BufferedReader in = new BufferedReader (new InputStreamReader(System.in));
			int cmd = Integer.parseInt(in.readLine());
			if(cmd==1) {
				Vector<Course> courses = DataBase.getInstance().getCourse();
				for(Course c: courses) {
					System.out.println(c.toString());
				}
				System.out.print("Enter position of course that you wanna register: ");
				student.registerCourse(courses.get(Integer.parseInt(in.readLine())));
			}
			else if(cmd==2) {
				Vector<Course> courses = student.getCourses();
				for(Course c: courses) {
					System.out.println(c.toString());
				}
				System.out.print("Enter position of course that you wanna pick lesson: ");
				student.pickLesson(courses.get(Integer.parseInt(in.readLine())));
			}
			else if(cmd==3) {
				student.viewTranscript();
			}
			else if(cmd==4) {
				student.seeNews();
			}
			else if(cmd==5) {
				
				Vector<Teacher> teachers = DataBase.getInstance().getTeachers();
				for(Teacher t: teachers) {
					System.out.println(t.toString());
				}
			}
			else if(cmd==6) {
				Vector<Course> courses = student.getCourses();
				for(Course c: courses) {
					System.out.println(c.toString());
				}
				System.out.print("Enter position of course that you wanna view marks: ");
				StudentMarks sm = student.getLog();
				sm.seeLog(courses.get(Integer.parseInt(in.readLine())));
			}
			else if(cmd==0) {
				break;
			}else {
				System.out.println("Try again");
			}
		}
	}
}
