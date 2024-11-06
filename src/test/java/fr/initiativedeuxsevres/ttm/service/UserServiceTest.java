package fr.initiativedeuxsevres.ttm.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import fr.initiativedeuxsevres.ttm.model.User;
import fr.initiativedeuxsevres.ttm.repository.UserRepository;
import fr.initiativedeuxsevres.ttm.service.UserServiceImpl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userServiceImpl;

    @Test
    public void testCreateUser() {
        User user = new User();
        user.setFirstName("Thibaut");
        user.setLastName("Mesmin");
        user.setEmail("thibault.msn@example.com");
        user.setRole("Admin");

        when(userRepository.save(any(User.class))).thenReturn(user);

        User createdUser = userServiceImpl.createUser("Thibaut", "Mesmin", "thibault.msn@example.com", "Admin");

        assertNotNull(createdUser.getId());
        assertEquals("Thibaut", createdUser.getFirstName());
        assertEquals("Mesmin", createdUser.getLastName());
        assertEquals("thibault.msn@example.com", createdUser.getEmail());
        assertEquals("Admin", createdUser.getRole());
    }

    @Test
    public void testFindUsersByFirstName() {
        User user1 = new User();
        user1.setFirstName("Thibaut");
        user1.setLastName("Mesmin");
        user1.setEmail("thibault.msn@example.com");
        user1.setRole("Admin");

        User user2 = new User();
        user2.setFirstName("Thibault");
        user2.setLastName("Pepito");
        user2.setEmail("Coralie.antoine@example.com");
        user2.setRole("User");

        when(userRepository.findByFirstName("Thibaut")).thenReturn(Arrays.asList(user1, user2));

        List<User> users = userServiceImpl.findUsersByFirstName("Thibaut");

        assertEquals(2, users.size());
        assertEquals("Mesmin", users.get(0).getLastName());
        assertEquals("Pepito", users.get(1).getLastName());
    }
}

