package App.Application.Controllers;

import App.Domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import App.Infrastructure.UserRepository;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserRepository userRepository;
    public UserController(@Autowired JdbcTemplate databaseConnection) {
        this.userRepository = new UserRepository(databaseConnection);
    }
    @GetMapping("/")
    public List<User> getUsers() {
        return this.userRepository.get();
    }

    // POST: Create a new user
    @PostMapping("/")
    public void createUser(@RequestBody User user) {
        this.userRepository.create(user);
    }
}