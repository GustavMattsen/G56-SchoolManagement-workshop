package se.lexicon.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Course {
//Fields
    private int id;
    private String courseName;
    private LocalDate startDate;
    private int weekDuration;
    private List<Student> students = new ArrayList<>();
//Constructor
    public Course(int id, String courseName, LocalDate startDate, int weekDuration) {
        this.id = id;
        this.courseName = courseName;
        this.startDate = startDate;
        this.weekDuration = weekDuration;
    }
//Methods that manage students
    public void register(Student student) {
        if (student == null) throw new IllegalArgumentException("Student cannot be null");
        if (!students.contains(student)) {
            students.add(student);
        }
    }

    public void unregister(Student student) {
        if (student == null) throw new IllegalArgumentException("Student cannot be null");
        students.remove(student);
    }
//Getters
    public List<Student> getStudents() {
        return students;
    }

    public int getId() { return id; }
    public String getCourseName() { return courseName; }
    public LocalDate getStartDate() { return startDate; }
    public int getWeekDuration() { return weekDuration; }
}
