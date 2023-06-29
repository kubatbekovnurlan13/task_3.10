package kg.kubatbekov.university_cms.controllerTest;

import kg.kubatbekov.university_cms.controller.LessonController;
import kg.kubatbekov.university_cms.service.LessonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(LessonController.class)
public class LessonControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LessonService lessonService;

    @Test
    @WithMockUser(username = "admin", password = "admin", roles = "ADMIN")
    public void list_testGetLessons_whenMethodReturnsValue() throws Exception {
        mockMvc.perform(get("/lesson/list"))
                .andExpect(model().attributeExists("lessons"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    @WithMockUser(username = "admin", password = "admin", roles = "ADMIN")
    public void delete_testDelete_whenMethodReturnsNoValue() throws Exception {
        mockMvc.perform(get("/lesson/delete"))
                .andDo(print());
    }
}
