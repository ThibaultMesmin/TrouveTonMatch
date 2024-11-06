package fr.initiativedeuxsevres.ttm.service.UserServiceImpl;

import fr.initiativedeuxsevres.ttm.model.Role;
import fr.initiativedeuxsevres.ttm.model.User;
import fr.initiativedeuxsevres.ttm.repository.UserRepository;
import fr.initiativedeuxsevres.ttm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(String firstName, String lastName, String email, Role role) {
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setRole(Role.valueOf(role));
        return userRepository.save(user);
    }

    // méthode pour trouver les Users par leur Prénom
    public List<User> findUsersByFirstName(String firstName) { return userRepository.findByFirstName(firstName); }
    public List<User> findUsersByRole(Role role) { return userRepository.findByRole(role); }
}
