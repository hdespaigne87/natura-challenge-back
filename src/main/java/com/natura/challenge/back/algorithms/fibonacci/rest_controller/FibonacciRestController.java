package com.natura.challenge.back.algorithms.fibonacci.rest_controller;

import com.natura.challenge.back.algorithms.fibonacci.dto.FibonacciResult;
import com.natura.challenge.back.algorithms.fibonacci.service.FibonacciCalculationMethod;
import com.natura.challenge.back.algorithms.fibonacci.service.FibonacciService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fibonacci")
@RequiredArgsConstructor
public class FibonacciRestController {

    private final FibonacciService fibonacciService;

    @GetMapping
    public ResponseEntity<?> fibonacci(@RequestParam("number") Integer number,
                                       @RequestParam("method") FibonacciCalculationMethod method) {
        FibonacciResult result = fibonacciService.fibonacci(number, method);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
