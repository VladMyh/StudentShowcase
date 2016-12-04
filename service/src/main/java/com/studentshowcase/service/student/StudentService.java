package com.studentshowcase.service.student;

import com.studentshowcase.model.user.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
	Student getStudentById(String id);
	List<Student> getAllStudentsPage(Integer size, Integer page);
	void saveOrUpdateStudent(Student student);

}
