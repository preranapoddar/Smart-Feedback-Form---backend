package data.feedback.controller;

import data.feedback.entity.User;
import data.feedback.model.LoginRequest;
import data.feedback.model.Token;
import data.feedback.service.UserService;
import data.feedback.util.ValidatorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.registerUser(user));
    }

    @PostMapping("/login")
    public ResponseEntity<Token> loginUser(@RequestBody LoginRequest loginRequest) {
        if(loginRequest.getEmail() == null || loginRequest.getPassword() == null) {
            return ResponseEntity.badRequest().build();
        }
        if(!ValidatorUtil.isValidEmail(loginRequest.getEmail()) ||
        !ValidatorUtil.isValidPassword(loginRequest.getPassword())) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(userService.login(loginRequest));
    }
}
