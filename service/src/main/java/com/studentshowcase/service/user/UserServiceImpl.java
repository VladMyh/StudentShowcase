package com.studentshowcase.service.user;

import com.studentshowcase.model.user.User;
import com.studentshowcase.model.verificationtoken.VerificationToken;
import com.studentshowcase.repository.user.MongoUserRepository;
import com.studentshowcase.repository.vereficationtoken.MongoVerificationTokenRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
	private static final Logger LOGGER = Logger.getLogger(UserServiceImpl.class);

	private MongoUserRepository userRepository;
	private MongoVerificationTokenRepository tokenRepository;

	@Autowired
	public UserServiceImpl(MongoUserRepository repository, MongoVerificationTokenRepository tokenRepository) {
		LOGGER.info("Initializing UserServiceImpl");

		this.userRepository = repository;
		this.tokenRepository = tokenRepository;
	}

	@Override
	public User getUserById(String id) {
		LOGGER.info("Getting user with id = " + id);

		return userRepository.findOne(id);
	}

	@Override
	public User getUserByEmail(String email) {
		LOGGER.info("Getting user by email");

		return userRepository.findByEmail(email).get(0);
	}

	@Override
	public void addOrUpdateUser(User user) {
		userRepository.save(user);
	}

	@Override
	public void createVerificationToken(User user, String token) {
		LOGGER.info("Creating new verification token");

		VerificationToken verificationToken = new VerificationToken(token, user);
		tokenRepository.save(verificationToken);
	}

	@Override
	public VerificationToken getVerificationToken(String token) {
		LOGGER.info("Getting verification token by token " + token);

		return tokenRepository.findByToken(token);
	}

	@Override
	public User getUserByVerificationToken(String token) {
		LOGGER.info("Getting user by verification token " + token);

		return tokenRepository.findByToken(token).getUser();
	}
}
