package com.studentshowcase.repository.user;

import com.studentshowcase.model.user.Student;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends PagingAndSortingRepository<Student, String>{
    List<Student> findByEmail(String email);
}
