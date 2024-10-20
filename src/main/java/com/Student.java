package com;

import java.util.HashMap;
import java.util.ArrayList;

public class Student {
    // Instance variables
    private String name;
    private String id;
    private ArrayList<Course> enrolledCourses;  // List of enrolled courses
    private HashMap<Course, Integer> grades;  // Mapping of courses to grades

    // Constructor to initialize student with name and ID
    public Student(String name, String id) {
        this.name = name;
        this.id = id;
        this.enrolledCourses = new ArrayList<>();
        this.grades = new HashMap<>();
    }

    // Getter and setter methods for name and ID
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    // Method to get the list of enrolled courses
    public ArrayList<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    // Method to enroll the student in a course
    public void enrollCourse(Course course) {
        if (course.enrollStudent(this)) {
            enrolledCourses.add(course);
        }
    }

    // Method to assign a grade to the student for a specific course
    public void assignGrade(Course course, int grade) {
        if (enrolledCourses.contains(course)) {
            grades.put(course, grade);
        }
    }

    // Method to get the student's grades
    public HashMap<Course, Integer> getGrades() {
        return grades;
    }
}
