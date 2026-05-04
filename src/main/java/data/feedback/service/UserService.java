package data.feedback.service;

import data.feedback.entity.User;
import data.feedback.model.LoginRequest;
import data.feedback.model.Token;
import data.feedback.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Token login(LoginRequest loginRequest) {
        if (loginRequest == null || loginRequest.getEmail() == null || loginRequest.getPassword() == null) {
            throw new RuntimeException("Invalid email or password");
        }

        User dbUser = userRepository.findByEmailAndPassword(loginRequest.getEmail(), loginRequest.getPassword()).orElseThrow(
                () -> new RuntimeException("Invalid email or password"));

        Token token = new Token();
        token.setToken(UUID.randomUUID().toString());

        dbUser.setToken(token.getToken());
        updateUser(dbUser);
        return token;
    }

    public Boolean validateToken(String token) {
        if (token == null) return false;

        return userRepository.existsByToken(token);
    }

    public User registerUser(User user) {
        if (user == null) return null;

        if (userRepository.existsByEmail(user.getEmail()))
            throw new RuntimeException("Email already exists");

        user.setToken(null);

        return userRepository.save(user);
    }

    public User updateUser(User user) {
        if (user == null) return null;

        User dbUser = userRepository.findById(user.getId()).orElse(null);
        if (dbUser == null) return null;

        if (user.getEmail() != null) dbUser.setEmail(user.getEmail());
        if (user.getPassword() != null) dbUser.setPassword(user.getPassword());
        if (user.getRole() != null) dbUser.setRole(user.getRole());
        if (user.getToken() != null) dbUser.setToken(user.getToken());

        return userRepository.save(dbUser);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

}
