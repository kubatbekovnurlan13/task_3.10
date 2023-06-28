package kg.kubatbekov.university_cms.controllerTest;

import kg.kubatbekov.university_cms.controller.SubjectController;
import kg.kubatbekov.university_cms.service.GroupService;
import kg.kubatbekov.university_cms.service.ProfessorService;
import kg.kubatbekov.university_cms.service.SubjectService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(SubjectController.class)
public class SubjectControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SubjectService subjectService;
    @MockBean
    private ProfessorService professorService;
    @MockBean
    private GroupService groupService;

    @Test
    @WithMockUser(username = "admin", password = "admin", roles = "ADMIN")
    public void getSubjects_testGetSubjects_whenMethodReturnsValue() throws Exception {
        mockMvc.perform(get("/subject/list"))
                .andExpect(model().attributeExists("subjects"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    @WithMockUser(username = "admin", password = "admin", roles = "ADMIN")
    public void delete_testDelete_whenMethodReturnsNoValue() throws Exception {
        mockMvc.perform(get("/subject/delete"))
                .andDo(print());
    }

    @Test
    @WithMockUser(username = "admin", password = "admin", roles = "ADMIN")
    public void add_testAddSubject_whenMethodReturnsValue() throws Exception {
        this.mockMvc.perform(get("/subject/add"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    @WithMockUser(username = "admin", password = "admin", roles = "ADMIN")
    public void save_testSaveSubject_whenMethodReturnsNoValue() throws Exception {
        this.mockMvc.perform(post("/subject/save"))
                .andDo(print());
    }

    @Test
    @WithMockUser(username = "admin", password = "admin", roles = "ADMIN")
    public void updateForm_testUpdateSubject_whenMethodReturnsNoValue() throws Exception {
        mockMvc.perform(get("/subject/updateForm"))
                .andDo(print());
    }

    @Test
    @WithMockUser(username = "admin", password = "admin", roles = "ADMIN")
    public void update_testUpdateSubject_whenMethodReturnsNoValue() throws Exception {
        this.mockMvc.perform(post("/subject/update"))
                .andDo(print());
    }

    @Test
    @WithMockUser(username = "admin", password = "admin", roles = "ADMIN")
    public void assignTeacher_testAssignTeacher_whenMethodReturnsNoValue() throws Exception {
        this.mockMvc.perform(get("/professor/assignTeacher"))
                .andDo(print());
    }

    @Test
    @WithMockUser(username = "admin", password = "admin", roles = "ADMIN")
    public void assignTeacherPost_testAssignTeacher_whenMethodReturnsNoValue() throws Exception {
        this.mockMvc.perform(post("/professor/assignTeacher"))
                .andDo(print());
    }

    @Test
    @WithMockUser(username = "admin", password = "admin", roles = "ADMIN")
    public void assignGroup_testAssignGroup_whenMethodReturnsNoValue() throws Exception {
        this.mockMvc.perform(get("/professor/assignGroup"))
                .andDo(print());
    }

    @Test
    @WithMockUser(username = "admin", password = "admin", roles = "ADMIN")
    public void assignGroupPost_testAssignGroup_whenMethodReturnsNoValue() throws Exception {
        this.mockMvc.perform(post("/professor/assignGroup"))
                .andDo(print());
    }

    @Test
    @WithMockUser(username = "admin", password = "admin", roles = "ADMIN")
    public void reassignTeacher_testReassignTeacher_whenMethodReturnsNoValue() throws Exception {
        this.mockMvc.perform(get("/professor/reassignTeacher"))
                .andDo(print());
    }

    @Test
    @WithMockUser(username = "admin", password = "admin", roles = "ADMIN")
    public void reassignTeacherPost_testReassignTeacher_whenMethodReturnsNoValue() throws Exception {
        this.mockMvc.perform(post("/professor/reassignTeacher"))
                .andDo(print());
    }
}
