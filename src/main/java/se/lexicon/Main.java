package se.lexicon;

import se.lexicon.dao.*;
import se.lexicon.model.*;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create DAO instances
        StudentDAO studentDao = new StudentDAOImpl();
        CourseDAO courseDao = new CourseDAOImpl();

        // Create multiple students
        Student s1 = new Student(1, "Barbro", "Barbro@mail.com", "Trägränd 2");
        Student s2 = new Student(2, "Bo", "Bo@mail.com", "Stengatan 6");
        Student s3 = new Student(3, "Måns", "Måns@mail.com", "Metallsvängen 4");

        // Save students using DAO
        studentDao.save(s1);
        studentDao.save(s2);
        studentDao.save(s3);

        // Create courses
        Course c1 = new Course(101, "Java Programming", LocalDate.of(2025, 9, 1), 6);
        Course c2 = new Course(102, "Python Basics", LocalDate.of(2025, 10, 1), 4);
        Course c3 = new Course(103, "Livets Hårda Skola", LocalDate.of(2025, 11, 5), 3808);

        // Save courses using my beautiful DAO
        courseDao.save(c1);
        courseDao.save(c2);
        courseDao.save(c3);

        // Register students to courses
        c1.register(s1);
        c1.register(s2);
        c2.register(s2);
        c2.register(s3);
        c3.register(s1);
        c3.register(s2);
        c3.register(s3);

        // Print all courses with students
        System.out.println("Courses and Enrolled Students:");
        for (Course course : courseDao.findAll()) {
            System.out.println("Course: " + course.getCourseName());
            List<Student> students = course.getStudents();
            if (students.isEmpty()) {
                System.out.println("  No students enrolled.");
            } else {
                for (Student student : students) {
                    System.out.println("  - " + student.getName() + " (" + student.getEmail() + ")");
                }
            }
        }

        // Example: Find and print a student by email
        System.out.println("\nSearch by email:");
        Student found = studentDao.findByEmail("Barbro@mail.com");
        if (found != null) {
            System.out.println("Found: " + found.getName() + ", " + found.getAddress());
        } else {
            System.out.println("No student found with that email.");
        }

        // Example: Delete a course and print an updated list
        courseDao.delete(c1);
        System.out.println("\nCourses after deleting 'Java Programming':");
        for (Course course : courseDao.findAll()) {
            System.out.println("  " + course.getCourseName());
        }
    }
}