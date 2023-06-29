package kg.kubatbekov.university_cms.serviceTest;

import kg.kubatbekov.university_cms.model.Professor;
import kg.kubatbekov.university_cms.model.Student;
import kg.kubatbekov.university_cms.model.Subject;
import kg.kubatbekov.university_cms.service.SubjectService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class SubjectServiceTest {
    @Autowired
    private SubjectService subjectService;

    @Test
    void getAll_testGetAllValues_whenThereIsValues() {
        int actual = subjectService.findAll().size();
        Assertions.assertEquals(6, actual);
    }

    @Test
    void groupsSubjectsSize_testGroupsSubjectsSize_whenThereIsValues() {
        int actual = subjectService.subjectsProfessorsSize();
        Assertions.assertEquals(10, actual);
    }

    @Test
    void findById_testFindById_whenThereIsValues() {
        Optional<Subject> actual = subjectService.findById(1);
        Assertions.assertNotNull(actual);
    }

    @Test
    void update_testUpdate_whenThereIsValues() {
        Subject expected = new Subject(1,"cs1","Computer Science");
        Subject actual = subjectService.update(expected);
        Assertions.assertEquals(expected, actual);
    }

}
