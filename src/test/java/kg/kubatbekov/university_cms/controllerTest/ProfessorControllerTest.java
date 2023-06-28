package kg.kubatbekov.university_cms.controllerTest;

import kg.kubatbekov.university_cms.controller.ProfessorController;
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

@WebMvcTest(ProfessorController.class)
public class ProfessorControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProfessorService professorService;

    @MockBean
    private SubjectService subjectService;

    @Test
    @WithMockUser(username = "admin", password = "admin", roles = "ADMIN")
    public void list_testGetProfessors_whenMethodReturnsValue() throws Exception {
        mockMvc.perform(get("/professor/list"))
                .andExpect(model().attributeExists("professors"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    @WithMockUser(username = "admin", password = "admin", roles = "ADMIN")
    public void delete_testDelete_whenMethodReturnsNoValue() throws Exception {
        mockMvc.perform(get("/professor/delete"))
                .andDo(print());
    }

    @Test
    @WithMockUser(username = "admin", password = "admin", roles = "ADMIN")
    public void add_testAddProfessor_whenMethodReturnsValue() throws Exception {
        this.mockMvc.perform(get("/professor/add"))
                .andExpect(model().attributeExists("professor"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    @WithMockUser(username = "admin", password = "admin", roles = "ADMIN")
    public void save_testSaveProfessor_whenMethodReturnsNoValue() throws Exception {
        this.mockMvc.perform(post("/professor/save"))
                .andDo(print());
    }

    @Test
    @WithMockUser(username = "admin", password = "admin", roles = "ADMIN")
    public void updateForm_testUpdateProfessor_whenMethodReturnsNoValue() throws Exception {
        mockMvc.perform(get("/professor/updateForm"))
                .andDo(print());
    }

    @Test
    @WithMockUser(username = "admin", password = "admin", roles = "ADMIN")
    public void update_testUpdateProfessor_whenMethodReturnsNoValue() throws Exception {
        this.mockMvc.perform(post("/professor/update"))
                .andDo(print());
    }

    @Test
    @WithMockUser(username = "admin", password = "admin", roles = "ADMIN")
    public void assignSubject_testAssignSubject_whenMethodReturnsNoValue() throws Exception {
        this.mockMvc.perform(get("/professor/assignSubject"))
                .andDo(print());
    }

    @Test
    @WithMockUser(username = "admin", password = "admin", roles = "ADMIN")
    public void assignSubjectPost_testAssignSubject_whenMethodReturnsNoValue() throws Exception {
        this.mockMvc.perform(post("/professor/assignSubject"))
                .andDo(print());
    }

    @Test
    @WithMockUser(username = "admin", password = "admin", roles = "ADMIN")
    public void reassignSubject_testReassignSubject_whenMethodReturnsNoValue() throws Exception {
        this.mockMvc.perform(get("/professor/reassignSubject"))
                .andDo(print());
    }

    @Test
    @WithMockUser(username = "admin", password = "admin", roles = "ADMIN")
    public void reassignSubjectPost_testReassignSubject_whenMethodReturnsNoValue() throws Exception {
        this.mockMvc.perform(post("/professor/reassignSubject"))
                .andDo(print());
    }

}
