package com.studentshowcase.service.user;

import com.studentshowcase.model.user.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
	User getUserById(String id);
	User getUserByEmail(String email);
	void addOrUpdateUser(User user);
}
