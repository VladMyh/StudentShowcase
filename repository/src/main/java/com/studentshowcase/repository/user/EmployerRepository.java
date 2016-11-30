package com.studentshowcase.repository.user;

import com.studentshowcase.model.user.Employer;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface EmployerRepository extends PagingAndSortingRepository<Employer, String>{
}
