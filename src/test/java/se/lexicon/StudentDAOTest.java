package se.lexicon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.lexicon.dao.StudentDAO;
import se.lexicon.dao.StudentDAOImpl;
import se.lexicon.model.Student;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class StudentDAOTest {

    private StudentDAO studentDao;

    @BeforeEach
    public void setup() {
        studentDao = new StudentDAOImpl();
    }

    @Test
    public void testSaveAndFindById() {
        Student s = new Student(1, "Torsten", "Torsten@mail.com", "Torstengränd 7");
        studentDao.save(s);

        Student result = studentDao.findById(1);
        assertNotNull(result);
        assertEquals("Torsten", result.getName());
    }

    @Test
    public void testFindByEmail() {
        Student s = new Student(2, "Sven", "Sven@mail.com", "Bogatan 2");
        studentDao.save(s);

        Student result = studentDao.findByEmail("Sven@mail.com");
        assertNotNull(result);
        assertEquals("Sven", result.getName());
    }

    @Test
    public void testFindByName() {
        studentDao.save(new Student(3, "Stig-Helmer", "Stig-Helmer@mail.com", "Stengränd 8"));
        studentDao.save(new Student(4, "Stig-Helmer", "Stig-Helmer2@mail.com", "Träsvängen 3"));

        List<Student> results = studentDao.findByName("Stig-Helmer");
        assertEquals(2, results.size());
    }

    @Test
    public void testDelete() {
        Student s = new Student(5, "Olov", "Olov@mail.com", "Klockstigen 7");
        studentDao.save(s);

        boolean deleted = studentDao.delete(s);
        assertTrue(deleted);
        assertNull(studentDao.findById(5));
    }
}
