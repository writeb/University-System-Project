package modes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

import project.Admin;
import project.DataBase;
import project.User;
import project.UserFactory;

public class AdminMode extends Mode{//extends Mode{
	private Admin admin;
	
	AdminMode() {}
	AdminMode(Admin admin){
		this.admin = admin;
	}
	
	public void start() throws NumberFormatException, IOException{
		while(true) {
			System.out.println("0->Exit");
			System.out.println("1->Add User");
			System.out.println("2->Remove User");
			System.out.println("3->See User Actions");
			
			BufferedReader in = new BufferedReader(new  InputStreamReader(System.in));
			int cmd = Integer.parseInt(in.readLine());
			
			if (cmd == 1) {
				UserFactory uf = new UserFactory();
				System.out.println("Write name: ");
				String name = in.readLine();
				System.out.println("Write type of user: ");
				String type = in.readLine();
				System.out.println("Write login: ");
				String login = in.readLine();
				System.out.println("Write password: ");
				String password = in.readLine();
				DataBase.getInstance().addUser(uf.register(type, name, login, password));
				System.out.println("Succesfully added...");
			}
			else if (cmd == 2) {
				Vector <User> users = DataBase.getInstance().getUsers();
				for (User u : users) {
					System.out.println(u.toString());
				}
				System.out.print("Enter the position of user ");
				int userPos = Integer.parseInt(in.readLine());
				this.admin.removeUser(users.get(userPos));
			}
			else if (cmd == 3) {
				Vector <User> users = DataBase.getInstance().getUsers();
				for (User u : users) {
					System.out.println(u.toString());
				}
				System.out.print("Enter the position of user ");
				int userPos = Integer.parseInt(in.readLine());
				this.admin.seeUserActions(users.get(userPos));
			}
			else if(cmd==0) {
				break;
			}else {
				System.out.println("Try again");
			}
		}
	}
}
