package com.studentshowcase.restcontroller.controller;

import com.studentshowcase.model.user.User;
import com.studentshowcase.model.user.userinfo.StudentInfo;
import com.studentshowcase.service.student.StudentService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {

	private static final Logger LOGGER = Logger.getLogger(StudentController.class);

	private StudentService studentService;

	@Autowired
	public StudentController(StudentService studentService) {
		LOGGER.info("Initializing StudentController");
		this.studentService = studentService;
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public User getStudentById(@PathVariable String id) {
		LOGGER.info("get student by id " + id);
		return studentService.getStudentById(id);
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public void saveOrUpdateStudent(@RequestBody User student) {
		LOGGER.info("saving student");

		student.setStudentInfo(new StudentInfo());
		studentService.addOrUpdateStudent(student);
	}

	@RequestMapping(value = "/pages{page}/{size}/{sort}", method = RequestMethod.GET)
	public ResponseEntity<?> getPage(@PathVariable(name = "page") Integer page,
									 @PathVariable(name = "size") Integer size,
									 @PathVariable(name = "sort") String sort) {
		LOGGER.info("Getting page of students");

		ResponseEntity<?> result;

		switch (sort) {
			case "desc":
				result = ResponseEntity.ok(studentService.getPage(page - 1, size, Sort.Direction.DESC));
				break;
			case "asc":
				result = ResponseEntity.ok(studentService.getPage(page - 1, size, Sort.Direction.ASC));
				break;
			default:
				LOGGER.info("Unknown value for sorting " + sort);
				result = ResponseEntity.badRequest().body("Unknown value for sorting " + sort);
		}

		return result;
	}
}
