package fr.initiativedeuxsevres.ttm.service;

import fr.initiativedeuxsevres.ttm.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

public class UserServiceTest {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userServiceImpl;

    @Test
    // given
    public void testCreateUser() {
        User user = new User(null, "Thibaut Mesmin", "thibault.msn@example.com");

    //when
        when(userRepository.save(any(User.class))).thenReturn(user);
    //then
        User createdUser = userService.createUser("Thibaut Mesmin", "thibault.msn@example.com");

        // vérifie que la méthode getName() renvoie bien une string égal à "Thibault"
        assertEquals("Thibault", createdUser.getName());
        assertEquals("thibault.msn@example.com", createdUser.getEmail());
    }
}
