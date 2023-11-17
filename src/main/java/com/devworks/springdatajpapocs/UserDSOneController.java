package com.devworks.springdatajpapocs;

import com.devworks.springdatajpapocs.dsone.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/ds-one")
public class UserDSOneController {

    private final UserDSOneRepository userDSOneRepository;

    public UserDSOneController(UserDSOneRepository userDSOneRepository) {
        this.userDSOneRepository = userDSOneRepository;
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {
        List<User> users = userDSOneRepository.findAll();
        return ResponseEntity.ok(users);
    }

}
