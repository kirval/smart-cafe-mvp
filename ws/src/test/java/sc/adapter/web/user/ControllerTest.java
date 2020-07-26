package sc.adapter.web.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import sc.core.user.application.port.in.RegisterUserUseCase;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@WebMvcTest(UserController.class)
public class ControllerTest {

    @MockBean
    private RegisterUserUseCase registerUserUseCase;

    @Autowired
    private UserWebMapper userWebMapper;

    @Autowired
    MockMvc mockMvc;

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void testRegisterUser() throws Exception {
        UserDTO testUser = new UserDTO("qwerty12345@mail.ru", "+375255555555", "qWer@y12345");

        when(registerUserUseCase.registerUser(
                userWebMapper.toDomainEntity(any(UserDTO.class))))
                .thenReturn(userWebMapper.toDomainEntity(testUser));

        mockMvc.perform(
                MockMvcRequestBuilders.post("user")
                        .content(asJsonString(testUser)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email").value(testUser.getEmail()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.phone").value(testUser.getPhone()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.password").value(testUser.getPassword()));
    }
}

