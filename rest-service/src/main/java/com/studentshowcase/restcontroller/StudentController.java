package com.studentshowcase.restcontroller;

import com.studentshowcase.model.user.Student;
import com.studentshowcase.service.student.StudentService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
	public Student getStudentById(@PathVariable String id) {
		return studentService.getStudentById(id);
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public void saveOrUpdateStudent(@RequestBody Student student) {
		studentService.addOrUpdateStudent(student);
	}
}
