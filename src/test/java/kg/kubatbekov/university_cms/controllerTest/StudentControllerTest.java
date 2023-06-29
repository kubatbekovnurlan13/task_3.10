package kg.kubatbekov.university_cms.controllerTest;

import kg.kubatbekov.university_cms.controller.StudentController;
import kg.kubatbekov.university_cms.service.GroupService;
import kg.kubatbekov.university_cms.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.nio.file.Path;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(StudentController.class)
public class StudentControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentService studentService;

    @MockBean
    private GroupService groupService;

    @Test
    @WithMockUser(username = "admin", password = "admin", roles = "ADMIN")
    public void list_testGetStudents_whenMethodReturnsValue() throws Exception{
        mockMvc.perform(get("/student/list"))
                .andExpect(model().attributeExists("students"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    @WithMockUser(username = "admin", password = "admin", roles = "ADMIN")
    public void delete_testDelete_whenMethodReturnsNoValue() throws Exception {
        mockMvc.perform(get("/student/delete"))
                .andDo(print());
    }

    @Test
    @WithMockUser(username = "admin", password = "admin", roles = "ADMIN")
    public void add_testAddStudent_whenMethodReturnsValue() throws Exception {
        this.mockMvc.perform(get("/student/add"))
                .andExpect(model().attributeExists("group"))
                .andExpect(model().attributeExists("groups"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    @WithMockUser(username = "admin", password = "admin", roles = "ADMIN")
    public void save_testSaveStudent_whenMethodReturnsNoValue() throws Exception {
        this.mockMvc.perform(post("/student/save"))
                .andDo(print());
    }

    @Test
    @WithMockUser(username = "admin", password = "admin", roles = "ADMIN")
    public void updateForm_testUpdateStudent_whenMethodReturnsNoValue() throws Exception {
        mockMvc.perform(get("/student/updateForm"))
                .andDo(print());
    }

    @Test
    @WithMockUser(username = "admin", password = "admin", roles = "ADMIN")
    public void update_testUpdateStudent_whenMethodReturnsNoValue() throws Exception {
        this.mockMvc.perform(post("/student/update"))
                .andDo(print());
    }
}
