package com;

import java.util.ArrayList;
import java.util.HashMap;

public class CourseManagement {
    // Static variables to store courses and student grades
    private static ArrayList<Course> courses = new ArrayList<>();
    private static HashMap<Student, HashMap<Course, Integer>> studentGrades = new HashMap<>();

    // Static method to add a new course
    public static void addCourse(String courseCode, String courseName, int maxCapacity) {
        Course newCourse = new Course(courseCode, courseName, maxCapacity);
        courses.add(newCourse);
    }

    // Static method to enroll a student in a course
    public static void enrollStudent(Student student, Course course) {
        student.enrollCourse(course);
    }

    // Static method to assign a grade to a student for a specific course
    public static void assignGrade(Student student, Course course, int grade) {
        student.assignGrade(course, grade);
        // Check if the student is already in the map
        if (!studentGrades.containsKey(student)) {
            // If not, create a new entry for the student
            studentGrades.put(student, new HashMap<Course, Integer>());
        }
        // Assign the grade to the course for the student
        studentGrades.get(student).put(course, grade);
    }

    // Static method to calculate the overall grade for a student
    public static double calculateOverallGrade(Student student) {
        HashMap<Course, Integer> grades = student.getGrades();
        int totalGrades = 0;
        int numberOfGrades = 0;
        for (int grade : grades.values()) {
            totalGrades += grade;
            numberOfGrades++;
        }
        return numberOfGrades > 0 ? (double) totalGrades / numberOfGrades : 0;
    }

    // Static method to get the list of courses
    public static ArrayList<Course> getCourses() {
        return courses;
    }
}


/*
 * public class CourseManagement { // Static variables to store courses and
 * student grades private static ArrayList<Course> courses = new ArrayList<>();
 * private static HashMap<Student, HashMap<Course, Integer>> studentGrades = new
 * HashMap<>();
 * 
 * // Static method to add a new course public static void addCourse(String
 * courseCode, String courseName, int maxCapacity) { Course newCourse = new
 * Course(courseCode, courseName, maxCapacity); courses.add(newCourse); }
 * 
 * // Static method to enroll a student in a course public static void
 * enrollStudent(Student student, Course course) { student.enrollCourse(course);
 * }
 * 
 * // Static method to assign a grade to a student for a specific course public
 * static void assignGrade(Student student, Course course, int grade) {
 * student.assignGrade(course, grade);
 * 
 * // Initialize the student's course grades if not already present in the map
 * studentGrades.computeIfAbsent(student, k -> new HashMap<>());
 * 
 * // Assign the grade to the course for the student
 * studentGrades.get(student).put(course, grade); }
 * 
 * // Static method to calculate the overall grade for a student public static
 * double calculateOverallGrade(Student student) { HashMap<Course, Integer>
 * grades = student.getGrades(); int totalGrades = 0; for (int grade :
 * grades.values()) { totalGrades += grade; } return grades.size() > 0 ?
 * (double) totalGrades / grades.size() : 0; }
 * 
 * // Static method to get the list of courses public static ArrayList<Course>
 * getCourses() { return courses; } }
 */