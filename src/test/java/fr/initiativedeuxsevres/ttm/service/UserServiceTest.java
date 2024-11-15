package fr.initiativedeuxsevres.ttm.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import fr.initiativedeuxsevres.ttm.model.Role;
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
        user.setId(1L);
        user.setFirstName("Thibaut");
        user.setLastName("Mesmin");
        user.setEmail("thibault.msn@example.com");
        user.setRole(Role.ADMIN);

        when(userRepository.save(any(User.class))).thenReturn(user);

        User createdUser = userServiceImpl.createUser("Thibaut", "Mesmin", "thibault.msn@example.com", Role.ADMIN);

        assertNotNull(createdUser.getId());
        assertEquals("Thibaut", createdUser.getFirstName());
        assertEquals("Mesmin", createdUser.getLastName());
        assertEquals("thibault.msn@example.com", createdUser.getEmail());
        assertEquals(Role.ADMIN, createdUser.getRole());
    }

    @Test
    public void testFindUsersByFirstName() {
        User user1 = new User();
        user1.setFirstName("Thibaut");
        user1.setLastName("Mesmin");
        user1.setEmail("thibault.msn@example.com");
        user1.setRole(Role.ADMIN);

        User user2 = new User();
        user2.setFirstName("Thibault");
        user2.setLastName("Pepito");
        user2.setEmail("Coralie.antoine@example.com");
        user2.setRole(Role.PORTEUR);

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
        user1.setRole(Role.PARRAIN);

        User user2 = new User();
        user2.setFirstName("Mathis");
        user2.setLastName("Desbois");
        user2.setEmail("Mathis.Desbois@example.com");
        user2.setRole(Role.PORTEUR);

        User user3 = new User();
        user3.setFirstName("Thibault");
        user3.setLastName("Mesmin");
        user3.setEmail("Thibault.Mesmin@example.com");
        user3.setRole(Role.ADMIN);

        // when
        when(userRepository.findByRole(Role.PARRAIN)).thenReturn(List.of(user1));
        when(userRepository.findByRole(Role.PORTEUR)).thenReturn(List.of(user2));
        when(userRepository.findByRole(Role.ADMIN)).thenReturn(List.of(user3));

        //then
        List<User> admins = userServiceImpl.findUsersByRole(Role.ADMIN);
        List<User> parrains = userServiceImpl.findUsersByRole(Role.PARRAIN);
        List<User> porteurs = userServiceImpl.findUsersByRole(Role.PORTEUR);

        assertEquals(1, admins.size());
        assertEquals(Role.ADMIN, admins.get(0).getRole());

        assertEquals(1, parrains.size());
        assertEquals(Role.PARRAIN, parrains.get(0).getRole());

        assertEquals(1, porteurs.size());
        assertEquals(Role.PORTEUR, porteurs.get(0).getRole());
    }
}

