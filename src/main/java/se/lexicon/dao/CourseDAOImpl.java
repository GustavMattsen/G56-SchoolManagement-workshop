package se.lexicon.dao;

import se.lexicon.model.Course;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CourseDAOImpl implements CourseDAO {
    private List<Course> courses = new ArrayList<>();

    @Override
    public Course save(Course course) {
        courses.add(course);
        return course;
    }

    @Override
    public Course findById(int id) {
        for (Course course : courses) {
            if (course.getId() == id) {
                return course;
            }
        }
        return null;
    }

    @Override
    public List<Course> findByName(String name) {
        return courses.stream()
                .filter(c -> c.getCourseName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }

    @Override
    public List<Course> findByDate(LocalDate date) {
        return courses.stream()
                .filter(c -> c.getStartDate().equals(date))
                .collect(Collectors.toList());
    }

    @Override
    public List<Course> findAll() {
        return new ArrayList<>(courses);
    }

    @Override
    public boolean delete(Course course) {
        return courses.remove(course);
    }
}
