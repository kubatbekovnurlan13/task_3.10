package kg.kubatbekov.university_cms.controllerTest;

import kg.kubatbekov.university_cms.controller.GroupController;
import kg.kubatbekov.university_cms.service.GroupService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(GroupController.class)
public class GroupControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GroupService groupService;

    @Test
    @WithMockUser(username = "admin", password = "admin", roles = "ADMIN")
    public void list_testGetGroups_whenMethodReturnsValue() throws Exception {
        mockMvc.perform(get("/group/list"))
                .andExpect(model().attributeExists("groups"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    @WithMockUser(username = "admin", password = "admin", roles = "ADMIN")
    public void delete_testDelete_whenMethodReturnsNoValue() throws Exception {
        mockMvc.perform(get("/group/delete"))
                .andDo(print());
    }

    @Test
    @WithMockUser(username = "admin", password = "admin", roles = "ADMIN")
    public void add_testAddGroup_whenMethodReturnsValue() throws Exception {
        this.mockMvc.perform(get("/group/add"))
                .andExpect(model().attributeExists("group"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    @WithMockUser(username = "admin", password = "admin", roles = "ADMIN")
    public void save_testSaveGroup_whenMethodReturnsNoValue() throws Exception {
        this.mockMvc.perform(post("/group/save"))
                .andDo(print());
    }

//    @Test
//    @WithMockUser(username = "admin", password = "admin", roles = "ADMIN")
//    public void save_customer_failed() throws Exception {
//        Group group = new Group(100, "group", 1);
//
//        doReturn(true).when(groupService).save(group);
//
//        mockMvc.perform(post("/group/save")
//                                .content(asJsonString(group))
//                                .contentType(MediaType.ALL_VALUE)
//                                .accept(MediaType.ALL_VALUE))
//                .andExpect(status().isOk())
//                .andDo(print());
//    }

    @Test
    @WithMockUser(username = "admin", password = "admin", roles = "ADMIN")
    public void updateForm_testUpdateGroup_whenMethodReturnsNoValue() throws Exception {
        mockMvc.perform(get("/group/updateForm"))
                .andDo(print());
    }


    @Test
    @WithMockUser(username = "admin", password = "admin", roles = "ADMIN")
    public void update_testUpdateGroup_whenMethodReturnsNoValue() throws Exception {
        this.mockMvc.perform(post("/group/update"))
                .andDo(print());
    }
}
