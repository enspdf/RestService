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
	
	public ArrayList<Course> getCourseById(int id) throws Exception {
		ArrayList<Course> courseList = new ArrayList<Course>();
		Database db = new Database();
		Connection con = db.getConnection();
		Access access = new Access();
		courseList = access.getCourseById(con, id);
		return courseList;
	}
	
	public Course insertCourse(int id, String name, String duration, Double fee) throws Exception {
		Course course = new Course();
		Database db = new Database();
		Connection con = db.getConnection();
		Access access = new Access();
		course = access.insertCourse(con, id, name, duration, fee);
		return course;
	}
	
	public Course deleteCourse(int id) throws Exception {
		Course course = new Course();
		Database db = new Database();
		Connection con = db.getConnection();
		Access access = new Access();
		course = access.deleteCourse(con, id);
		return course;
	}
	
	public Course updateCourse(int id, String name) throws Exception {
		Course course = new Course();
		Database db = new Database();
		Connection con = db.getConnection();
		Access access = new Access();
		course = access.updateCourse(con, id, name);
		return course;
	}
	
}
