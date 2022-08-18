package com.ongame.user.controller;


import com.ongame.user.VO.ResponseTemplateVO;
import com.ongame.user.entity.Userr;
import com.ongame.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public Userr saveUser(@RequestBody Userr user){
        log.info("Inside saveUser method of UserController");
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public ResponseTemplateVO getUserWithDepartment(@PathVariable("id") Long userId){
        log.info("Inside getUserWithDepartment methode of UserController");
        return userService.getUserWithDepartment(userId);
    }
}
