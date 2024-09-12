package com.bitsMind.myFirstProject.Controller;

import com.bitsMind.myFirstProject.Entity.User;
import com.bitsMind.myFirstProject.Service.EmailService;
import com.bitsMind.myFirstProject.Service.UserService;
import com.mongodb.lang.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public")
public class PublicController {
    @Autowired
    private UserService userService;

    @Autowired
    private EmailService emailService;

    @GetMapping("/health-check")
    public ResponseEntity<String> healthCheck(){
        return new ResponseEntity<>("Chal to rha be ",HttpStatus.OK);
    }

    @PostMapping("/create-user")
    public ResponseEntity<User> createUser(@RequestBody @NonNull User user){
        try {
            userService.saveNewUser(user);
            return new ResponseEntity<>(user,HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/send-mail")
    public ResponseEntity<?> sendMail(){
        try{
            emailService.sendEMail("bitsmindutsav@gmail.com","Testing mail api","Hi, how r u bro?");
            return new ResponseEntity<>("mail sent",HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
