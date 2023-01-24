package test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Vector;

import modes.StartMode;
import project.DataBase;
import project.User;
import project.UserFactory;

public class Test2 {
	public static void main(String[] args) throws ClassNotFoundException, FileNotFoundException, IOException {
		UserFactory uf = new UserFactory();
		StartMode mode = new StartMode();
		mode.start();
		DataBase.loadDB();
	}
}
