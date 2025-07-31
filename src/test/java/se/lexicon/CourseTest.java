package se.lexicon;

import org.junit.jupiter.api.Test;
import se.lexicon.model.Course;
import se.lexicon.model.Student;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CourseTest {

    @Test
    public void testRegisterStudent() {
        Course course = new Course(1, "Math", LocalDate.now(), 5);
        Student student = new Student(1, "Torsten", "torsten@gmail.com", "Torstengränd 1");

        course.register(student);

        assertTrue(course.getStudents().contains(student));
    }

    @Test
    public void testUnregisterStudent() {
        Course course = new Course(1, "Math", LocalDate.now(), 5);
        Student student = new Student(1, "Torsten", "torsten@gmail.com", "Torstengränd 1");

        course.register(student);
        course.unregister(student);

        assertFalse(course.getStudents().contains(student));
    }
}
