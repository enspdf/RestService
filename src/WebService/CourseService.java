package WebService;

import java.util.ArrayList;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.google.gson.Gson;

import Model.AccessManager;

import Dto.Course;

@Path("/courseService")
public class CourseService {

	@GET
	@Path("/courses")
	@Produces("application/json")
	public String courses() {
		String courses = null;
		ArrayList<Course> courseList = new ArrayList<Course>();
		try {
			courseList = new AccessManager().getCourses();
			Gson gson = new Gson();
			courses = gson.toJson(courseList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return courses;
	}

	@GET
	@Path("/courseById/{id}")
	@Produces("application/json")
	public String courseById(@PathParam("id") int id) {
		String course = null;
		ArrayList<Course> courseById = new ArrayList<Course>();
		try {
			courseById = new AccessManager().getCourseById(id);
			Gson gson = new Gson();
			course = gson.toJson(courseById);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return course;
	}

	@POST
	@Path("/insertCourse")
	@Produces("application/json")
	public String insertCourse(@HeaderParam("id") int id, @HeaderParam("name") String name,
			@HeaderParam("duration") String duration, @HeaderParam("fee") double fee) {
		String course = null;
		Course icourse = new Course();
		try {
			icourse = new AccessManager().insertCourse(id, name, duration, fee);
			Gson gson = new Gson();
			course = gson.toJson(icourse);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return course;
	}
	
	@POST
	@Path("/deleteCourse")
	@Produces("application/json")
	public String deleteCourse(@HeaderParam("id") int id) {
		String course = null;
		Course icourse = new Course();
		try {
			icourse = new AccessManager().deleteCourse(id);
			Gson gson = new Gson();
			course = gson.toJson(icourse);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return course;
	}

}
