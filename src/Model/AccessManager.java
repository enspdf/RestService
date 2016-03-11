package Model;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
 
import Dao.Access;
import Dao.Database;
import Dto.Course;

public class AccessManager {

	public ArrayList<Course> getCourses() throws Exception {
		ArrayList<Course> courseList = new ArrayList<Course>();
		Database db = new Database();
		Connection con = db.getConnection();
		Access access = new Access();
		courseList = access.getCourses(con);
		return courseList;
	}
	
}
