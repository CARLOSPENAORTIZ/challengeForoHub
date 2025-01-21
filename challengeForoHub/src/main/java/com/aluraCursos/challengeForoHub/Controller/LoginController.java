package com.aluraCursos.challengeForoHub.Controller;

import com.aluraCursos.challengeForoHub.dto.LoginRequest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/login")
//public class LoginController {

//    private final AuthenticationManager authenticationManager;

//    public LoginController(AuthenticationManager authenticationManager) {
//        this.authenticationManager = authenticationManager;
//    }

//    @PostMapping
//    public String login(@RequestBody LoginRequest loginRequest) {
//        Authentication authentication = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(
//                        loginRequest.getUsername(),
//                        loginRequest.getPassword()
//                )
//        );
//
//        // Si la autenticación es exitosa, retorna un mensaje o token
//        if (authentication.isAuthenticated()) {
//            return "Autenticación exitosa";
//        } else {
//            return "Error en la autenticación";
//        }
//    }
//}
//
//
