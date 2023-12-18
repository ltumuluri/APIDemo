package org.user.controller;


import org.apache.catalina.connector.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.user.beans.Userabc;
import org.user.service.UserService;
import java.util.List;


@CrossOrigin
@RestController
@RequestMapping(value="/")
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RestController.class);

    @Autowired
    UserService userService;


    @GetMapping(value="getAllUsers")
    public ResponseEntity<List<Userabc>> getAll(){
        return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
    }

    @PostMapping(value="getUserByName")
    public ResponseEntity<Userabc> getUser(@RequestBody(required = true) String name){

        Userabc response = userService.getUserByName(name);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @PostMapping(value="/addUser")
    public ResponseEntity<String> addUser(@RequestBody(required = true)  Userabc userabc) {
        String response = userService.saveUser(userabc);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }

    @PostMapping(value="/removeUser")
    public ResponseEntity<String> removeUser(@RequestBody(required = true)  String email) {
        String response = userService.removeUser(email);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    }


