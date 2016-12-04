package com.studentshowcase.repository.user;

import com.studentshowcase.model.user.Teacher;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends PagingAndSortingRepository<Teacher, String>{

}
