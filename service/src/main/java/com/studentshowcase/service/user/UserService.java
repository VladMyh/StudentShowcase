package com.studentshowcase.service.user;

import com.studentshowcase.model.user.User;
import com.studentshowcase.model.verificationtoken.VerificationToken;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.WebRequest;

@Service
public interface UserService {
	User getUserById(String id);
	User getUserByEmail(String email);
	void addOrUpdateUser(User user);
    void createVerificationToken(User user, String token);
    VerificationToken getVerificationToken(String token);
    User getUserByVerificationToken(String token);
    User registerUser(User user, WebRequest request);
}
