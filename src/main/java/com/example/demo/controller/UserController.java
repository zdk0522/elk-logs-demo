package controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class UserController {

    @GetMapping("/user/{id}")
    public String getUser(@PathVariable String id) {
        return "User-" + id;
    }
}