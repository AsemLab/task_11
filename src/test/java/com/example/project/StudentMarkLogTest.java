package com.example.project;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StudentMarkLogTest {

	private StudentMarkLog markLog;
	
	@BeforeEach
	void setUp() throws Exception {
		
		markLog = new StudentMarkLog();
	}

	@Test
	@DisplayName("Add (C++, 95) to marks")
	void addMarkTest() {
		markLog.addMark("C++", 95.0);
		
		assertEquals(95.0, markLog.getAllMarks().get("C++"));
	}
	
	@Test
	@DisplayName("Grade < 0")
	void addLessZeroGradeTest() {
				
		markLog.addMark("English", -9.0);
		
		assertEquals( 0.0,markLog.getAllMarks().get("English"));
	}
	
	@Test
	@DisplayName("Grade > 100")
	void addMore100GradeTest() {
				
		markLog.addMark("English", 900.0);
		
		assertEquals( 0.0,markLog.getAllMarks().get("English"));
	}
	
	@Test
	@DisplayName("Add mark without name")
	void addNullMarkNameTest() {
				
		assertThrows(IllegalArgumentException.class, () -> markLog.addMark(null, 95.0));
	}
	
	@Test
	@DisplayName("Add mark without grade")
	void addNullMarkGradeTest() {
				
		assertThrows(IllegalArgumentException.class, () -> markLog.addMark("Java", null));
	}

	@Test
	@DisplayName("Update mark")
	void updateMarkTest() {
		
		markLog.addMark("Web app", 77.0);
		
		double before = markLog.getMark("Web app");
		markLog.addMark("Web app", 59.0);
		
		assertNotEquals(before, markLog.getAllMarks().get("Web app"));
		
	}
	
	@Test
	@DisplayName("Get existing mark")
	void getMarkTest() {
		markLog.addMark("C#", 85.0);
		
		assertEquals( 85.0,markLog.getMark("C#"));
	}
	
	@Test
	@DisplayName("Get not existing mark")
	void getMarkTest2() {
		
		assertEquals( null,markLog.getMark("C++"));
	}
	
	@Test
	@DisplayName("Get null mark")
	void getMarkTest3() {
		
		assertThrows(NullPointerException.class,() -> markLog.getMark(null));
	}
	
	@Test
	@DisplayName("Calculate average")
	void calculateAverageTest() {
		
		markLog.addMark("C++", 77.0);
		markLog.addMark("Web app", 85.0);
		markLog.addMark("Testing", 90.0);
		
		assertEquals(84.0, markLog.calculateAverage());
	}
	
	@Test
	@DisplayName("Calculate empty list")
	void calculateEmptyTest() {
		
		assertEquals(0.0, markLog.calculateAverage());
	}
	
}
