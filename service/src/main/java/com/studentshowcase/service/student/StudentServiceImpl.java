package com.studentshowcase.service.student;

import com.studentshowcase.model.user.Student;
import com.studentshowcase.repository.user.StudentRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

	private static final Logger LOGGER = Logger.getLogger(StudentServiceImpl.class);
	private StudentRepository repository;

	@Autowired
	public StudentServiceImpl(StudentRepository repository) {
		LOGGER.info("Initializing StudentServiceImpl");
		this.repository = repository;
	}

	public Student getStudentById(String id) {
		LOGGER.info("Getting student with id = " + id);
		return repository.findOne(id);
	}

	public List<Student> getAllStudentsPage(Integer page, Integer size) {
		LOGGER.info("Getting " + page + " page of all students, with size " + size);
		Pageable pageable = new PageRequest(page, size);

		return repository.findAll(pageable).getContent();
	}

	public void addOrUpdateStudent(Student student) {
		LOGGER.info("Saving student");

		List<Student> students = repository.findByEmail(student.getEmail());

		if(students.isEmpty()) {
			repository.save(student);
		}
		else {
			LOGGER.info("Error email " + student.getEmail() + " already in use");
		}
	}

	public long studentCount() {
		LOGGER.info("Getting student count");
		return repository.count();
	}
}
