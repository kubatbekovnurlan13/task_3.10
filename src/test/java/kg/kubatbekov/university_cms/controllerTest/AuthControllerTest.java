package kg.kubatbekov.university_cms.controllerTest;

import kg.kubatbekov.university_cms.controller.mainContollers.AuthController;
import kg.kubatbekov.university_cms.model.UserEntity;
import kg.kubatbekov.university_cms.service.UserService;
import kg.kubatbekov.university_cms.util.UserValidator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AuthController.class)
public class AuthControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserValidator userValidator;

    @MockBean
    private UserService userService;

    @Test
    @WithMockUser(username = "admin", password = "admin", roles = "ADMIN")
    public void getUsers_testUsers_whenMethodReturnsValue() throws Exception {
        mockMvc.perform(get("/auth/get-users"))
                .andExpect(model().attributeExists("users"))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "admin", password = "admin", roles = "ADMIN")
    public void login_testLogin_whenMethodDoNotReturnsValue() throws Exception {
        mockMvc.perform(get("/auth/login"))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "admin", password = "admin", roles = "ADMIN")
    public void loginError_testLoginError_whenMethodReturnsValue() throws Exception {
        mockMvc.perform(get("/auth/login-error"))
                .andExpect(model().attributeExists("loginError"))
                .andExpect(status().isOk());
    }
}
