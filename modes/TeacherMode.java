package modes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

import Study.Lector;
import Study.Teacher;
import project.Course;
import project.DataBase;
import project.Student;

public class TeacherMode extends Mode{
	private Teacher teacher;
	private Lector lector;
	//private Course course;
	
	public TeacherMode() {}
	public TeacherMode(Teacher teacher) {
		this.teacher = teacher;
	}
	
	public void start() throws NumberFormatException, IOException{
		while(true) {
			System.out.println("0->Exit");
			System.out.println("1->View Course");
			System.out.println("2->Add course");
			System.out.println("3->Get rating");
			System.out.println("4->View Information");
			System.out.println("5->Put Mark to Student");
			
			BufferedReader in = new BufferedReader(new  InputStreamReader(System.in));
			int cmd = Integer.parseInt(in.readLine());
			
			if (cmd == 1) {
				teacher.viewCourse();
			}
			else if (cmd == 2) {
				teacher.viewCourse();
				Vector <Course> courses = DataBase.getInstance().getCourse();
				for (Course c : courses) {
					System.out.println(c.toString());
				}
				System.out.print("Enter position of course ");
				int coursePos = Integer.parseInt(in.readLine());
				teacher.addCourse(courses.get(coursePos));
			}
			else if (cmd == 3) {
				System.out.print("Average rating of Teacher = ");
				teacher.getRating();
			}
			else if (cmd == 4) {
				teacher.viewInfo(teacher);
			}
			else if (cmd == 5) {
				Vector <Student> students = DataBase.getInstance().getStudents();
				for (Student s : students) {
					System.out.println(s.toString());
				}
				System.out.print("Enter position of student ");
				int studentPos = Integer.parseInt(in.readLine());
				
				Vector <Course> courses = DataBase.getInstance().getCourse();
				for (Course c : courses) {
					System.out.println(c.toString());
				}
				System.out.print("Enter position of course ");
				int coursePos = Integer.parseInt(in.readLine());
				
				System.out.print("Enter the mark for student ");
				int mark = Integer.parseInt(in.readLine());
				
				this.lector.putMarks(students.get(studentPos), courses.get(coursePos), mark);
			}
			else if(cmd==0) {
				break;
			}else {
				System.out.println("Try again");
			}
		}
	}
}
