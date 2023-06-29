package kg.kubatbekov.university_cms.controllerTest;

import kg.kubatbekov.university_cms.controller.mainContollers.MainController;
import kg.kubatbekov.university_cms.service.TimetableService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MainController.class)
public class MainControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private TimetableService timetableService;

    @Test
    @WithMockUser(username = "admin", password = "admin", roles = "ADMIN")
    public void getIndex_testGetIndex_whenMethodDoNotReturnsValue() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk());
    }
}
