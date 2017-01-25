package com.studentshowcase.service.user;

import com.studentshowcase.model.user.User;
import com.studentshowcase.model.verificationtoken.VerificationToken;
import com.studentshowcase.repository.user.MongoUserRepository;
import com.studentshowcase.repository.vereficationtoken.MongoVerificationTokenRepository;
import com.studentshowcase.service.registration.OnRegistrationCompleteEvent;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.WebRequest;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
	private static final Logger LOGGER = Logger.getLogger(UserServiceImpl.class);

	private MongoUserRepository userRepository;
	private MongoVerificationTokenRepository tokenRepository;
	private ApplicationEventPublisher eventPublisher;

	@Autowired
	public UserServiceImpl(MongoUserRepository repository,
						   MongoVerificationTokenRepository tokenRepository,
						   ApplicationEventPublisher eventPublisher) {
		LOGGER.info("Initializing UserServiceImpl");

		this.userRepository = repository;
		this.tokenRepository = tokenRepository;
		this.eventPublisher = eventPublisher;
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

	@Override
	public User registerUser(User user, WebRequest request) {
		LOGGER.info("Registering new user");

		List<User> students = userRepository.findByEmail(user.getEmail());

		if(students.isEmpty()) {
			User registered = userRepository.save(user);

			try {
				eventPublisher.publishEvent(new OnRegistrationCompleteEvent(registered,
					                                                        request.getLocale(),
					                                                        request.getContextPath()));
			}
			catch (Exception ex) {
				LOGGER.error("Couldn't publish event");
				LOGGER.error(ex.getMessage());
			}
		}
		else {
			LOGGER.info("Error email " + user.getEmail() + " already in use");

		}
		return null;
	}
}
