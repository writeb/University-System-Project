package modes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import Study.Teacher;
import project.Admin;
import project.Department;
import project.Librarian;
import project.OR;
import project.Student;
import project.User;
import project.UserFactory;

public class StartMode {
	public void start() throws IOException, ClassNotFoundException {
		while(true) {
			UserFactory uf = new UserFactory();
			System.out.println("Login or Register? ");
			BufferedReader in = new BufferedReader (new InputStreamReader(System.in));
			String enter = in.readLine();
			User u ;
			if(enter.equalsIgnoreCase("login")){
				System.out.println("Enter login: ");
				String login = in.readLine();
				System.out.println("Enter password: ");
				String password = in.readLine();
				u = uf.logIn(login, password);
	         
			} else if(enter.equalsIgnoreCase("register")){
				System.out.println("Write name: ");
				String name = in.readLine();
				System.out.println("Write type of user: ");
				String type = in.readLine();
				System.out.println("Write login: ");
				String login = in.readLine();
				System.out.println("Write password: ");
				String password = in.readLine();
				u = uf.register(type, name, login, password);
			}
			else if(enter.equalsIgnoreCase("0")) {
				break;
			}else {
				System.out.println("Try again");
				continue;
			}
			System.out.println(u.toString());
			Mode mode = new Mode();
			if(u instanceof Student) {
				mode = new StudentMode((Student) u);
			}
			else if(u instanceof Librarian) {
				mode = new LibrarianMode((Librarian) u);
			}
			else if(u instanceof Department) {
				mode = new DepartmentMode((Department) u);
			}
			else if(u instanceof Teacher) {
				mode = new TeacherMode((Teacher) u);
			}
			else if(u instanceof Admin) {
				mode = new AdminMode((Admin) u);
			}
			else if(u instanceof OR) {
				mode = new ORMode((OR) u);
			}
			mode.start();
		}
		
		
	}
}
