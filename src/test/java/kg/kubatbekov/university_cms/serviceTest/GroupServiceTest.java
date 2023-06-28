package kg.kubatbekov.university_cms.serviceTest;

import kg.kubatbekov.university_cms.container.PostgresContainer;
import kg.kubatbekov.university_cms.model.Group;
import kg.kubatbekov.university_cms.service.GroupService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GroupServiceTest extends PostgresContainer {
    @Autowired
    private GroupService groupService;

    @Test
    void getAll_testGetAllValues_whenThereIsValues() {
        int actual = groupService.findAll().size();
        Assertions.assertEquals(5, actual);
    }

    @Test
    void groupsSubjectsSize_testGroupsSubjectsSize_whenThereIsValues() {
        int actual = groupService.groupsSubjectsSize();
        Assertions.assertEquals(26, actual);
    }

    @Test
    void findById_testGroupFindById_whenThereIsValues() {
        Group actual = groupService.findById(1).get();
        Group expected = new Group(1, "ce-1", 1);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void update_testGroupUpdate_whenThereIsValues() {
        Group expected = new Group(1, "ce-1000", 1);
        Group actual = groupService.update(expected);
        Assertions.assertEquals(expected, actual);
    }

}
