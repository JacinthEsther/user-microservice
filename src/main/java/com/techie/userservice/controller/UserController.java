package com.techie.userservice.controller;


import com.techie.userservice.VO.ResponseTemplateVO;
import com.techie.userservice.entity.User;
import com.techie.userservice.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    @PostMapping("/")
    public User saveUser(@RequestBody User user){

        log.info("inside saveUser of userController");
       return userService.save(user);
    }

    @GetMapping("/{id}")
    public ResponseTemplateVO getUserWithDepartment(@PathVariable("id") Long userId){
        log.info("inside getUserWithDepartment of userController");

        return userService.getUserWithDepartment(userId);
    }
}
