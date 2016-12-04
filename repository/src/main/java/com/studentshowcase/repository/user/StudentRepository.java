package com.studentshowcase.repository.user;

import com.studentshowcase.model.user.Student;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends PagingAndSortingRepository<Student, String>{
}
