package com.studentshowcase.model.track;

import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.Set;

public class Track {
	@Id
	private String id;
	private String title;
	private String description;
	private Integer level;
	private Date startDate;
	private Date endDate;
	private String teacherId;
	private Set<String> studentIds;

	public Track() {}

	public Track(String id, String title, String description, Integer level,
				 Date startDate, Date endDate, String teacherId, Set<String> studentIds) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.level = level;
		this.startDate = startDate;
		this.endDate = endDate;
		this.teacherId = teacherId;
		this.studentIds = studentIds;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
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

	public String getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}

	public Set<String> getStudentIds() {
		return studentIds;
	}

	public void setStudentIds(Set<String> studentIds) {
		this.studentIds = studentIds;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Track track = (Track) o;

		if (!id.equals(track.id)) return false;
		if (!title.equals(track.title)) return false;
		if (!description.equals(track.description)) return false;
		if (!level.equals(track.level)) return false;
		if (startDate != null ? !startDate.equals(track.startDate) : track.startDate != null) return false;
		if (endDate != null ? !endDate.equals(track.endDate) : track.endDate != null) return false;
		if (!teacherId.equals(track.teacherId)) return false;
		return studentIds.equals(track.studentIds);
	}

	@Override
	public int hashCode() {
		int result = id.hashCode();
		result = 31 * result + title.hashCode();
		result = 31 * result + description.hashCode();
		result = 31 * result + level.hashCode();
		result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
		result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
		result = 31 * result + teacherId.hashCode();
		result = 31 * result + studentIds.hashCode();
		return result;
	}
}
