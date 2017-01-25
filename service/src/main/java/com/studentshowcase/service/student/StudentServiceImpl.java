package com.studentshowcase.service.student;

import com.studentshowcase.model.user.User;
import com.studentshowcase.repository.user.MongoUserRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class StudentServiceImpl implements StudentService {

	private static final Logger LOGGER = Logger.getLogger(StudentServiceImpl.class);
	private MongoUserRepository repository;

	@Autowired
	public void setRepository(MongoUserRepository repository) {
		this.repository = repository;
	}

	public User getStudentById(String id) {
		LOGGER.info("Getting student with id = " + id);
		User user = repository.findOneByIdAndStudentInfoNotNull(id);
		user.setPassword(null);
		return user;
	}

	public void addOrUpdateStudent(User student) {
		LOGGER.info("Saving student");
		repository.save(student);
	}

	public long studentCount() {
		LOGGER.info("Getting student count");
		return repository.countByStudentInfoNotNull();
	}

	public Page<User> getPage(Integer page, Integer size) {
		LOGGER.info("Getting page of students");
		Page<User> result = repository.findAllByStudentInfoNotNull(new PageRequest(page, size));
		result.forEach(u -> u.setPassword(null));

		return result;
	}

	@Override
	public void addTrackToStudent(String studentId, String trackId) {
		LOGGER.info("Adding track " + trackId + " to student " + studentId);
		User user = repository.findOneByIdAndStudentInfoNotNull(studentId);

		if(user != null) {
			if(user.getStudentInfo().getTracks() == null) {
				HashSet<String> tracks = new HashSet<>();
				tracks.add(trackId);
				user.getStudentInfo().setTracks(tracks);
			}
			else {
				user.getStudentInfo().getTracks().add(trackId);
			}

			repository.save(user);
		}
		else {
			LOGGER.info("No student with id " + studentId);
		}

	}
}
