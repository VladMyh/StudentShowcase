package com.studentshowcase.model.verificationtoken;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

@Document(collection = "studentVerificationToken")
public class StudentVerificationToken {
    @Id
    private String id;
    private static final int EXPIRATION = 60 * 24;
    private String studentId;
    private Date expirationDate;

    public StudentVerificationToken() {}

    public StudentVerificationToken(String id, String studentId, Date expirationDate) {
        this.id = id;
        this.studentId = studentId;
        this.expirationDate = expirationDate;
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

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
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

        StudentVerificationToken that = (StudentVerificationToken) o;

        if (!id.equals(that.id)) return false;
        if (!studentId.equals(that.studentId)) return false;
        return expirationDate.equals(that.expirationDate);

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + studentId.hashCode();
        result = 31 * result + expirationDate.hashCode();
        return result;
    }
}
