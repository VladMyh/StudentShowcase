package com.studentshowcase.service.student;

import com.studentshowcase.model.user.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
	User getStudentById(String id);
	void addOrUpdateStudent(User student);
	long studentCount();
}
