package se.lexicon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.lexicon.dao.CourseDAO;
import se.lexicon.dao.CourseDAOImpl;
import se.lexicon.model.Course;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CourseDAOTest {

    private CourseDAO courseDAO;

    @BeforeEach
    public void setup() {
        courseDAO = new CourseDAOImpl();
    }

    @Test
    public void testSaveAndFindById() {
        Course c = new Course(101, "Java", LocalDate.of(2025, 9, 1), 6);
        courseDAO.save(c);

        Course result = courseDAO.findById(101);
        assertNotNull(result);
        assertEquals("Java", result.getCourseName());
    }

    @Test
    public void testFindByName() {
        courseDAO.save(new Course(102, "Python", LocalDate.now(), 5));
        courseDAO.save(new Course(103, "Python", LocalDate.now(), 4));

        List<Course> results = courseDAO.findByName("Python");
        assertEquals(2, results.size());
    }

    @Test
    public void testFindByDate() {
        LocalDate date = LocalDate.of(2025, 9, 15);
        courseDAO.save(new Course(104, "C#", date, 3));

        List<Course> results = courseDAO.findByDate(date);
        assertEquals(1, results.size());
        assertEquals("C#", results.get(0).getCourseName());
    }

    @Test
    public void testDelete() {
        Course c = new Course(105, "HTML", LocalDate.now(), 2);
        courseDAO.save(c);

        boolean deleted = courseDAO.delete(c);
        assertTrue(deleted);
        assertNull(courseDAO.findById(105));
    }
}
