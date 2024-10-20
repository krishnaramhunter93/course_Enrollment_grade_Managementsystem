package com;

import java.util.ArrayList;

public class Course {
    // Instance variables
    private String courseCode;
    private String courseName;
    private int maxCapacity;
    private ArrayList<Student> enrolledStudents;  // List of enrolled students
    private static int totalEnrolledStudents = 0;  // Static variable to track total enrolled students

    // Constructor to initialize course with code, name, and capacity
    public Course(String courseCode, String courseName, int maxCapacity) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.maxCapacity = maxCapacity;
        this.enrolledStudents = new ArrayList<>();
    }

    // Getter methods for course details
    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public ArrayList<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    // Method to enroll a student in the course
    public boolean enrollStudent(Student student) {
        if (enrolledStudents.size() < maxCapacity) {
            enrolledStudents.add(student);
            totalEnrolledStudents++;
            return true;
        } else {
            System.out.println("Course is full.");
            return false;
        }
    }

    // Static method to get the total number of enrolled students across all courses
    public static int getTotalEnrolledStudents() {
        return totalEnrolledStudents;
    }
}
