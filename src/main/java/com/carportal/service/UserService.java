//package com.carportal.service;
//
//import com.carportal.entity.User;
//import com.carportal.repository.UserRepository;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.RequestBody;
//
//import java.util.Optional;
//
//@Service
//public class UserService {
//
//    private UserRepository userRepository;
//
//    public UserService (UserRepository userRepository){
//        this.userRepository =userRepository;
//    }
//
//    public ResponseEntity<String> createUser(@RequestBody User user) {
//        Optional<User> opEmail = userRepository.findByEmail(user.getEmail());
//
//        if (opEmail.isPresent()) {
//            return new ResponseEntity<>("Email id exists", HttpStatus.INTERNAL
//        }
//
//        Optional<User> opMobile = userRepository.findByMobile(user.getMobile()
//
//        if (opMobile.isPresent()) {
//            return new ResponseEntity<>("Mobile is already exists", HttpStatus
//        }
//
//        Optional<User> opUsername = userRepository.findByUsername(user.getUser
//        if(opUsername.isPresent()){
//            return new ResponseEntity<>("Username is already present ",HttpSta
//        }
//
//
//    }
//
//
//
//}
