package com;

import java.util.Scanner;

public class AdminInterface {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Course Enrollment and Grade Management System");
            System.out.println("1. Add a new course");
            System.out.println("2. Enroll student in a course");
            System.out.println("3. Assign grade to a student");
            System.out.println("4. Calculate overall grade for a student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    addCourse();
                    break;
                case 2:
                    enrollStudent();
                    break;
                case 3:
                    assignGrade();
                    break;
                case 4:
                    calculateOverallGrade();
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Method to add a new course
    private static void addCourse() {
        System.out.print("Enter course code: ");
        String courseCode = scanner.nextLine();
        System.out.print("Enter course name: ");
        String courseName = scanner.nextLine();
        System.out.print("Enter maximum capacity: ");
        int maxCapacity = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        CourseManagement.addCourse(courseCode, courseName, maxCapacity);
        System.out.println("Course added successfully.");
    }

    // Method to enroll a student in a course
    private static void enrollStudent() {
        System.out.print("Enter student name: ");
        String studentName = scanner.nextLine();
        System.out.print("Enter student ID: ");
        String studentId = scanner.nextLine();
        Student student = new Student(studentName, studentId);

        System.out.print("Enter course code to enroll in: ");
        String courseCode = scanner.nextLine();
        Course course = findCourseByCode(courseCode);

        if (course != null) {
            CourseManagement.enrollStudent(student, course);
            System.out.println("Student enrolled successfully.");
        } else {
            System.out.println("Course not found.");
        }
    }

    // Method to assign a grade to a student for a course
    private static void assignGrade() {
        System.out.print("Enter student ID: ");
        String studentId = scanner.nextLine();
        Student student = findStudentById(studentId);

        System.out.print("Enter course code: ");
        String courseCode = scanner.nextLine();
        Course course = findCourseByCode(courseCode);

        if (course != null) {
            System.out.print("Enter grade: ");
            int grade = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            CourseManagement.assignGrade(student, course, grade);
            System.out.println("Grade assigned successfully.");
        } else {
            System.out.println("Course not found.");
        }
    }

    // Method to calculate and display the overall grade for a student
    private static void calculateOverallGrade() {
        System.out.print("Enter student ID: ");
        String studentId = scanner.nextLine();
        Student student = findStudentById(studentId);

        double overallGrade = CourseManagement.calculateOverallGrade(student);
        System.out.println("Overall grade for student " + student.getName() + " is: " + overallGrade);
    }

    // Helper method to find a course by its code
    private static Course findCourseByCode(String courseCode) {
        for (Course course : CourseManagement.getCourses()) {
            if (course.getCourseCode().equalsIgnoreCase(courseCode)) {
                return course;
            }
        }
        return null;
    }

    // Helper method to find a student by their ID
    private static Student findStudentById(String studentId) {
        // In a real system, you would search a database or list of students.
        // Here, we'll just create a new student for simplicity.
        return new Student("Dummy", studentId);
    }
}
