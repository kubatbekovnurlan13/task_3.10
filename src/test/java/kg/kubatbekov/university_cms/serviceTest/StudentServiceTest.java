package kg.kubatbekov.university_cms.serviceTest;

import kg.kubatbekov.university_cms.model.Student;
import kg.kubatbekov.university_cms.service.StudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class StudentServiceTest {
    @Autowired
    private StudentService studentService;

    @Test
    void getAll_testGetAllValues_whenThereIsValues() {
        int actual = studentService.findAll().size();
        Assertions.assertEquals(25, actual);
    }

    @Test
    void findById_testFindById_whenThereIsValues() {
        Optional<Student> actual = studentService.findById(1);
        Assertions.assertNotNull(actual);
    }

    @Test
    void update_testUpdate_whenThereIsValues() {
        Student expected = new Student(1,"student_1","last_1",20);
        Student actual = studentService.update(expected);
        Assertions.assertEquals(expected, actual);
    }

}
