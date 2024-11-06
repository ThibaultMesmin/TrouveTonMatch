package fr.initiativedeuxsevres.ttm.service.UserServiceImpl;

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
    public User createUser(String firstName, String lastName, String email, String role) {
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setRole(role);
        return userRepository.save(user);
    }

    // méthode pour trouver les Users par leur Prénom
    public List<User> findUsersByFirstName(String firstName) { return userRepository.findByFirstName(firstName); }
}
