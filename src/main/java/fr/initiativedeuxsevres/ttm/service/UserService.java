package fr.initiativedeuxsevres.ttm.service;

import fr.initiativedeuxsevres.ttm.model.User;

public interface UserService {
    User createUser(String firstName, String lastName, String email, String role);
}