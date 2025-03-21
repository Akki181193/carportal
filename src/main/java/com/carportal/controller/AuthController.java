package com.carportal.controller;
import com.carportal.entity.User;
import com.carportal.payload.LoginDto;
import com.carportal.repository.UserRepository;
import com.carportal.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/auth")

public class AuthController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuthService authService;


    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody User user) {
        Optional<User> opEmail = userRepository.findByEmail(user.getEmail());
        if (opEmail.isPresent()) {
            return new ResponseEntity<>("Email id exists", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        Optional<User> opMobile = userRepository.findByMobile(user.getMobile());
        if (opMobile.isPresent()) {
            return new ResponseEntity<>("Mobile is already exists", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        Optional<User> opUsername = userRepository.findByUsername(user.getUsername());
        if(opUsername.isPresent()){
            return new ResponseEntity<>("Username is already present ",HttpStatus.INTERNAL_SERVER_ERROR);
        }

        String hashpw = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(10));
        user.setPassword(hashpw);
        userRepository.save(user);
         return new ResponseEntity<>("User Created",HttpStatus.OK);
    }



    @PostMapping("/login")
    public ResponseEntity<String>verfifyLogin(@RequestBody LoginDto dto){

       String jwtToken = authService.authenticate(dto);

       if(jwtToken!=null){
           return new ResponseEntity<>(jwtToken, HttpStatus.OK);
       }else {
           return new ResponseEntity<>("Invalid", HttpStatus.OK);
       }

    }
}