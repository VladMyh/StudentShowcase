package com.studentshowcase.repository.user;

import com.studentshowcase.model.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MongoUserRepository extends PagingAndSortingRepository<User, String>{

	/**
	 * Finds users by email.
	 *
	 * @param email user email.
	 * @return      list of users found with given email.
	 */
	List<User> findByEmail(String email);

	/**
	 * Returns count of users with not null studentInfo fiend.
	 *
	 * @return	number of students.
	 */
	Long countByStudentInfoNotNull();

	/**
	 * Returns student by id.
	 *
	 * @param id id of the user.
	 * @return   student entity.
	 */
	User findOneByIdAndStudentInfoNotNull(String id);

	/**
	 * Gets page of students.
	 *
	 * @param pageable page params
	 * @return         returns a page of students
	 */
	Page<User> findAllByStudentInfoNotNull(Pageable pageable);

}
