package com.natura.challenge.back.fibonacci;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fibonacci")
public class FibonacciRestController {

    @GetMapping
    public ResponseEntity<?> fibonacci() {
        return new ResponseEntity<>("hfsdjk", HttpStatus.OK);
    }
}
