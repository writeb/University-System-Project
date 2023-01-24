package modes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

import Study.Teacher;
import project.Course;
import project.DataBase;
import project.Faculty;
import project.OR;

public class ORMode extends Mode{
	private OR or;
//	private Teacher teacher;
//	private Course course;
	
	public ORMode() {}
	public ORMode(OR or) {
		this.or = or;
	}
	public void start() throws NumberFormatException, IOException{
		while(true) {
			System.out.println("0->Exit");
			System.out.println("1->Open Register");
			System.out.println("2->Close Register");
			System.out.println("3->Assign course to Teacher");
			System.out.println("4->View Information");
			System.out.println("5->Add course");
			BufferedReader in = new BufferedReader(new  InputStreamReader(System.in));
			int cmd = Integer.parseInt(in.readLine());
			if (cmd == 1) {
				this.or.openRegister();
				System.out.println("It's time for registration");
			}
			else if (cmd == 2) {
				this.or.closeRegister();
				System.out.println("Registration is closed");
			}
			else if (cmd == 3) {
				Vector <Teacher> teachers = DataBase.getInstance().getTeachers();
				for (Teacher t : teachers) {
					System.out.println(t.toString());
				}
				System.out.print("Enter position of teacher to assign course");
				int teacherPos = Integer.parseInt(in.readLine());
				
				Vector <Course> courses = DataBase.getInstance().getCourse();
				for (Course c : courses) {
					System.out.println(c.toString());
				}
				System.out.print("Enter position of course to assign to teacher");
				int coursePos = Integer.parseInt(in.readLine());
				
				this.or.assignCourseToTeacher(teachers.get(teacherPos), courses.get(coursePos));
			}
			else if (cmd == 4) {
				or.viewInfo(or);
			}
			else if(cmd==5) {
				System.out.println("Write name");
				String name = in.readLine();
				DataBase.getInstance().addCourse(new Course(name,Faculty.FIT));
			}
			else if(cmd==0) {
				break;
			}else {
				System.out.println("Try again");
			}
		}
	}
}
