package com.studentshowcase.model.specialization;

public enum Rating {
	ONE("One star"),
	TWO("Two stars"),
	THREE("Three stars"),
	FOUR("Four stars"),
	FIVE("Five stars");

	private final String name;

	private Rating(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
