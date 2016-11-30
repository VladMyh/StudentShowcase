package com.studentshowcase.repository.user;

import com.studentshowcase.model.user.Student;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface StudentRepository extends PagingAndSortingRepository<Student, String>{
}
