package com.studentshowcase.service.student;

import com.studentshowcase.model.user.Student;

import java.util.List;

public interface StudentService {
	Student getStudentById(String id);
	List<Student> getAllStudentsPage(Integer size, Integer page);

}
