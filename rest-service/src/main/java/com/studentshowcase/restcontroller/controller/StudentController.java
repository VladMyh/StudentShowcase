package com.studentshowcase.restcontroller.controller;

import com.studentshowcase.model.user.User;
import com.studentshowcase.service.student.StudentService;
import com.studentshowcase.service.user.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

@RestController
@RequestMapping("/students")
public class StudentController {

	private static final Logger LOGGER = Logger.getLogger(StudentController.class);

	private StudentService studentService;
	private UserService userService;
	private ApplicationEventPublisher eventPublisher;

	@Autowired
	public StudentController(StudentService studentService,
							 UserService userService,
							 ApplicationEventPublisher eventPublisher) {
		LOGGER.info("Initializing StudentController");

		this.studentService = studentService;
		this.userService = userService;
		this.eventPublisher = eventPublisher;
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public User getStudentById(@PathVariable String id) {
		LOGGER.info("get student by id " + id);

		return studentService.getStudentById(id);
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public void saveOrUpdateStudent(@RequestBody User student) {
		LOGGER.info("Saving student");

		studentService.addOrUpdateStudent(student);
	}

	@RequestMapping(value = "register", method = RequestMethod.POST)
	public void registerStudent(@RequestBody User student, WebRequest request) {
		LOGGER.info("Registering new student");

		userService.registerUser(student, request);
	}

	@RequestMapping(value = "page/{page}/size/{size}", method = RequestMethod.GET)
	public ResponseEntity<?> getPage(@PathVariable(name = "page") Integer page,
									 @PathVariable(name = "size") Integer size) {
		LOGGER.info("Getting page number " + page + " of size " + size + " of students");

		return ResponseEntity.ok(studentService.getPage(page - 1, size));
	}

	@RequestMapping(value = "{id}/tracks", method = RequestMethod.POST)
	public void addTrack(@PathVariable(name = "id") String studentId,
									  @RequestBody String trackId) {
		LOGGER.info("Adding track " + trackId + " to student " + studentId);

		studentService.addTrackToStudent(studentId, trackId);
	}
}
