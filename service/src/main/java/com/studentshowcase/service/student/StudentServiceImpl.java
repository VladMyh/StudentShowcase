package com.studentshowcase.service.student;

import com.studentshowcase.model.user.Student;
import com.studentshowcase.repository.user.StudentRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class StudentServiceImpl implements StudentService {

	private static Logger logger = Logger.getLogger(StudentServiceImpl.class);
	private StudentRepository repository;

	@Autowired
	public StudentServiceImpl(StudentRepository repository) {
		logger.info("Initializing StudentServiceImpl");
		this.repository = repository;
	}

	public Student getStudentById(String id) {
		logger.info("Getting student with id = " + id);
		return repository.findOne(id);
	}

	public List<Student> getAllStudentsPage(Integer page, Integer size) {
		logger.info("Getting " + page + " page of all students, with size " + size);
		Pageable pageable = new PageRequest(page, size);

		return repository.findAll(pageable).getContent();
	}
}
