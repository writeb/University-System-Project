package modes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

import Study.StudentMarks;
import Study.Teacher;
import project.Course;
import project.DataBase;
import project.Department;
import project.User;

public class DepartmentMode extends Mode{
	private Department dept;
	DepartmentMode(){}
	DepartmentMode(Department dept){
		this.dept = dept;
	}
	public void start() throws NumberFormatException,IOException {
		while(true) {
			System.out.println("0->Exit");
			System.out.println("1->Statistical report");
			System.out.println("2->Manage news");
			System.out.println("3->View Info");
			BufferedReader in = new BufferedReader (new InputStreamReader(System.in));
			int cmd = Integer.parseInt(in.readLine());
			if(cmd==1) {
				dept.statisticalReport();
			}
			else if(cmd==2) {
				System.out.println("Write news: ");
				String news = in.readLine();
				dept.manageNews(news);
			}
			else if(cmd==3) {
				Vector<User> users = DataBase.getInstance().getUsers();
				for(User u:users) {
					System.out.println(u.toString());
				}
			}
			else if(cmd==0) {
				break;
			}else {
				System.out.println("Try again");
			}
		}
	}
}
