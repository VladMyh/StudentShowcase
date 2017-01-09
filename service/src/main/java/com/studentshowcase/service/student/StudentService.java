package com.studentshowcase.service.student;

import com.studentshowcase.model.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public interface StudentService {
	User getStudentById(String id);
	void addOrUpdateStudent(User student);
	long studentCount();
	Page<User> getPage(Integer page, Integer size, Sort.Direction direction);
}
