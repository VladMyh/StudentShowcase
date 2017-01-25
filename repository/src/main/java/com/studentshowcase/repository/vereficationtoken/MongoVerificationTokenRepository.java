package com.studentshowcase.repository.vereficationtoken;

import com.studentshowcase.model.user.User;
import com.studentshowcase.model.verificationtoken.VerificationToken;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MongoVerificationTokenRepository extends MongoRepository<VerificationToken, String> {

    /**
     * This method is used to find verification token by user.
     *
     * @param user User to find token by.
     * @return     Verification token instance.
     */
    VerificationToken findByUser(User user);

    /**
     * This method is used to find verification token by token.
     *
     * @param token Token to find verification token by.
     * @return      Verification token instance.
     */
    VerificationToken findByToken(String token);
}
