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

    @Test
    public void FindUserByRoleTest() {
        // given
        User user1 = new User();
        user1.setFirstName("Arthur");
        user1.setLastName("Mesmin");
        user1.setEmail("Arthur.Mesmin@example.com");
        user1.setRole("Parrain");

        User user2 = new User();
        user2.setFirstName("Mathis");
        user2.setLastName("Desbois");
        user2.setEmail("Mathis.Desbois@example.com");
        user2.setRole("Porteur");

        User user3 = new User();
        user3.setFirstName("Thibault");
        user3.setLastName("Mesmin");
        user3.setEmail("Thibault.Mesmin@example.com");
        user3.setRole("Admin");

        // when
        when(userRepository.findByRole("Parrain")).thenReturn(List.of(user1));
        when(userRepository.findByRole("Porteur")).thenReturn(List.of(user2));
        when(userRepository.findByRole("Admin")).thenReturn(List.of(user3));

        //then
        List<User> admins = userServiceImpl.findUsersByRole("Admin");
        List<User> parrains = userServiceImpl.findUsersByRole("Parrain");
        List<User> porteurs = userServiceImpl.findUsersByRole("Porteur");

        assertEquals(1, admins.size());
        assertEquals("Admin", admins.get(0).getRole());

        assertEquals(1, parrains.size());
        assertEquals("Parrain", parrains.get(0).getRole());

        assertEquals(1, porteurs.size());
        assertEquals("Porteur", porteurs.get(0).getRole());
    }
}

