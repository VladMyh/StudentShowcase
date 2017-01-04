package com.studentshowcase.service.student;

import com.studentshowcase.model.user.User;
import com.studentshowcase.repository.user.MongoUserRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

	private static final Logger LOGGER = Logger.getLogger(StudentServiceImpl.class);
	private MongoUserRepository repository;

	@Autowired
	public StudentServiceImpl(MongoUserRepository repository) {
		LOGGER.info("Initializing StudentServiceImpl");
		this.repository = repository;
	}

	public User getStudentById(String id) {
		LOGGER.info("Getting student with id = " + id);
		return repository.findOneByIdAndStudentInfoNotNull(id);
	}

	public void addOrUpdateStudent(User student) {
		LOGGER.info("Saving student");

		List<User> students = repository.findByEmail(student.getEmail());

		if(students.isEmpty()) {
			repository.save(student);
		}
		else {
			LOGGER.info("Error email " + student.getEmail() + " already in use");
		}
	}

	public long studentCount() {
		LOGGER.info("Getting student count");
		return repository.countByStudentInfoNotNull();
	}
}
