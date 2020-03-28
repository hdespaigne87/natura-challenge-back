package com.natura.challenge.back.algorithms.fibonacci.service;

import com.natura.challenge.back.algorithms.fibonacci.dto.FibonacciResult;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@Validated
public interface FibonacciService {

    FibonacciResult fibonacci(int number, @NotNull FibonacciCalculationMethod method);
}
