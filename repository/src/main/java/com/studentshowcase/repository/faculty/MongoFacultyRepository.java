package com.studentshowcase.repository.faculty;

import com.studentshowcase.model.faculty.Faculty;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MongoFacultyRepository  extends PagingAndSortingRepository<Faculty, String> {}
