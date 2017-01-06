package com.studentshowcase.model.user;

import com.studentshowcase.model.user.userinfo.AdminInfo;
import com.studentshowcase.model.user.userinfo.EmployerInfo;
import com.studentshowcase.model.user.userinfo.StudentInfo;
import com.studentshowcase.model.user.userinfo.TeacherInfo;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
public class User {
	@Id
	private String id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String linkedin;

	private boolean isActivated;
	private boolean isEmailVerified;

	private StudentInfo studentInfo;
	private TeacherInfo teacherInfo;
	private EmployerInfo employerInfo;
	private AdminInfo adminInfo;

	public User() {}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLinkedin() {
		return linkedin;
	}

	public void setLinkedin(String linkedin) {
		this.linkedin = linkedin;
	}

	public boolean getIsActivated() {
		return isActivated;
	}

	public void setIsActivated(boolean activated) {
		isActivated = activated;
	}

	public boolean getIsEmailVerified() {
		return isEmailVerified;
	}

	public void setIsEmailVerified(boolean emailVerified) {
		isEmailVerified = emailVerified;
	}

	public StudentInfo getStudentInfo() {
		return studentInfo;
	}

	public void setStudentInfo(StudentInfo studentInfo) {
		this.studentInfo = studentInfo;
	}

	public TeacherInfo getTeacherInfo() {
		return teacherInfo;
	}

	public void setTeacherInfo(TeacherInfo teacherInfo) {
		this.teacherInfo = teacherInfo;
	}

	public EmployerInfo getEmployerInfo() {
		return employerInfo;
	}

	public void setEmployerInfo(EmployerInfo employerInfo) {
		this.employerInfo = employerInfo;
	}

	public AdminInfo getAdminInfo() {
		return adminInfo;
	}

	public void setAdminInfo(AdminInfo adminInfo) {
		this.adminInfo = adminInfo;
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		User user = (User) o;

		if (isActivated != user.isActivated) return false;
		if (isEmailVerified != user.isEmailVerified) return false;
		if (!id.equals(user.id)) return false;
		if (!firstName.equals(user.firstName)) return false;
		if (!lastName.equals(user.lastName)) return false;
		if (!email.equals(user.email)) return false;
		if (!password.equals(user.password)) return false;
		if (linkedin != null ? !linkedin.equals(user.linkedin) : user.linkedin != null) return false;
		if (studentInfo != null ? !studentInfo.equals(user.studentInfo) : user.studentInfo != null) return false;
		if (teacherInfo != null ? !teacherInfo.equals(user.teacherInfo) : user.teacherInfo != null) return false;
		if (employerInfo != null ? !employerInfo.equals(user.employerInfo) : user.employerInfo != null) return false;
		return adminInfo != null ? adminInfo.equals(user.adminInfo) : user.adminInfo == null;

	}

	@Override
	public int hashCode() {
		int result = id.hashCode();
		result = 31 * result + firstName.hashCode();
		result = 31 * result + lastName.hashCode();
		result = 31 * result + email.hashCode();
		result = 31 * result + password.hashCode();
		result = 31 * result + (linkedin != null ? linkedin.hashCode() : 0);
		result = 31 * result + (isActivated ? 1 : 0);
		result = 31 * result + (isEmailVerified ? 1 : 0);
		result = 31 * result + (studentInfo != null ? studentInfo.hashCode() : 0);
		result = 31 * result + (teacherInfo != null ? teacherInfo.hashCode() : 0);
		result = 31 * result + (employerInfo != null ? employerInfo.hashCode() : 0);
		result = 31 * result + (adminInfo != null ? adminInfo.hashCode() : 0);
		return result;
	}
}
