package com.SpringSecurity.LoginRegist.JWT.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/logreg/v1/demo")
@RestController
public class demo {

    @GetMapping
    public ResponseEntity<String> getDemo() {
        return ResponseEntity.ok("Hello World");
    }

}
