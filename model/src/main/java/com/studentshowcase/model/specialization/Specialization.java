package com.studentshowcase.model.specialization;

import com.studentshowcase.model.user.Teacher;

import java.util.Date;

public class Specialization {
	private String id;
	private String title;
	private Date startDate;
	private Date endDate;
	private Rating rating;
	private String review;
	private Teacher teacher;

	public Specialization() {}

	public Specialization(String id, String title, Date startDate, Date endDate,
						  Rating rating, String review, Teacher teacher) {
		this.id = id;
		this.title = title;
		this.startDate = startDate;
		this.endDate = endDate;
		this.rating = rating;
		this.review = review;
		this.teacher = teacher;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Rating getRating() {
		return rating;
	}

	public void setRating(Rating rating) {
		this.rating = rating;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Specialization that = (Specialization) o;

		if (!id.equals(that.id)) return false;
		if (!title.equals(that.title)) return false;
		if (startDate != null ? !startDate.equals(that.startDate) : that.startDate != null) return false;
		if (endDate != null ? !endDate.equals(that.endDate) : that.endDate != null) return false;
		if (rating != that.rating) return false;
		if (review != null ? !review.equals(that.review) : that.review != null) return false;
		return teacher.equals(that.teacher);

	}

	@Override
	public int hashCode() {
		int result = id.hashCode();
		result = 31 * result + title.hashCode();
		result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
		result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
		result = 31 * result + (rating != null ? rating.hashCode() : 0);
		result = 31 * result + (review != null ? review.hashCode() : 0);
		result = 31 * result + teacher.hashCode();
		return result;
	}
}
