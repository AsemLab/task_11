package com.example.project;

import java.util.HashMap;

public class StudentMarkLog {

	private HashMap<String, Double> marks;

	public StudentMarkLog() {
		marks = new HashMap<>();
	}

	public void addMark(String courseName, Double courseMark) {

		if (courseName == null)
			throw new IllegalArgumentException("Nullable course name");

		if (courseMark == null)
			throw new IllegalArgumentException("Nullable course mark");

		if (courseMark < 0 || courseMark > 100)
			marks.put(courseName, 0.0);
		else
			marks.put(courseName, courseMark);
	}

	public Double getMark(String courseName) {
		if (courseName == null)
			throw new NullPointerException("Nullable course name");
		
		return marks.get(courseName);
	}

	public Double calculateAverage() {
		
		if(marks.isEmpty())
			return 0.0;

		double sum = 0.0;
		for (String s : marks.keySet()) {
			sum += marks.get(s);
		}

		return sum / marks.size();
	}

	public HashMap<String, Double> getAllMarks() {
		return marks;
	}

}
