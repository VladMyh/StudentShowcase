package com.studentshowcase.model.verificationtoken;

import com.studentshowcase.model.user.User;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

@Document(collection = "verificationToken")
public class VerificationToken {

    private static final int EXPIRATION = 60 * 24;

    @Id
    private String id;
    @DBRef
    private User user;
    private Date expirationDate;
    private String token;

    public VerificationToken() {}

    public VerificationToken(String token, User user) {
        super();
        this.token = token;
        this.user = user;
        this.expirationDate = calculateExpiryDate(EXPIRATION);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public static int getEXPIRATION() {
        return EXPIRATION;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    private Date calculateExpiryDate(int expiryTimeInMinutes) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Timestamp(cal.getTime().getTime()));
        cal.add(Calendar.MINUTE, expiryTimeInMinutes);
        return new Date(cal.getTime().getTime());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VerificationToken that = (VerificationToken) o;

        if (!id.equals(that.id)) return false;
        if (!user.equals(that.user)) return false;
        if (!expirationDate.equals(that.expirationDate)) return false;
        return token.equals(that.token);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + user.hashCode();
        result = 31 * result + expirationDate.hashCode();
        result = 31 * result + token.hashCode();
        return result;
    }
}
