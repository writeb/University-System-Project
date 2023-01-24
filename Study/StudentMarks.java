package Study;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import project.Course;
public class StudentMarks implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Map<Course, Transcript> log = new HashMap<Course,Transcript>();
	
	public StudentMarks() {};
	
	
	public void viewTranscript() {
		for (Map.Entry<Course,Transcript> entry : log.entrySet()) 
            System.out.println(entry.getKey() + ", overall = " + entry.getValue().calculate());
	}
	public double averagePoints() {
		double res = 0;
		int cnt=0;
		for (Map.Entry<Course,Transcript> entry : log.entrySet()){
			res = res  + entry.getValue().calculate();
			cnt++;
		}
		return res/cnt;
	}
	public String getTranscript() {
		String res = "";
		for (Map.Entry<Course,Transcript> entry : log.entrySet()) 
			res = res + entry.getKey() + ", overall = " + entry.getValue().calculate() + "\n";
		return res;
	}
	public void addMark(Course c, int mark) {
		log.get(c).addMark(mark);
	}
	public void seeLog(Course c) {
		log.get(c).view();
	}
}