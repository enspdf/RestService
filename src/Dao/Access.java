package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Dto.Course;

public class Access {

	public ArrayList<Course> getCourses(Connection con) throws SQLException {
		ArrayList<Course> courseList = new ArrayList<Course>();
		PreparedStatement stmt = con.prepareStatement("SELECT * FROM Course");
		ResultSet rs = stmt.executeQuery();
		try {
			while (rs.next()) {
				Course courseObj = new Course();
				courseObj.setId(rs.getInt("id"));
				courseObj.setName(rs.getString("name"));
				courseObj.setDuration(rs.getString("duration"));
				courseObj.setFee(rs.getDouble("fee"));
				courseList.add(courseObj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return courseList;
	}

	public ArrayList<Course> getCourseById(Connection con, int id) throws SQLException {
		ArrayList<Course> courseList = new ArrayList<>();
		PreparedStatement stmt = con.prepareStatement("SELECT * FROM Course WHERE id = " + id);
		ResultSet rs = stmt.executeQuery();
		try {
			while (rs.next()) {
				Course courseObj = new Course();
				courseObj.setId(rs.getInt("id"));
				courseObj.setName(rs.getString("name"));
				courseObj.setDuration(rs.getString("duration"));
				courseObj.setFee(rs.getDouble("fee"));
				courseList.add(courseObj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return courseList;
	}

	public Course insertCourse(Connection con, int id, String name, String duration, Double fee) throws SQLException {
		Course course = new Course();
		PreparedStatement stmt = con.prepareStatement("INSERT INTO Course (id, name, duration, fee) VALUES (" + id
				+ ", '" + name + "', '" + duration + "'," + fee + ")");
		try {
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return course;
	}
	
	public Course deleteCourse(Connection con, int id) throws SQLException {
		Course course = new Course();
		PreparedStatement stmt = con.prepareStatement("DELETE FROM Course WHERE id = " + id);
		try {
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return course;
	}

}
