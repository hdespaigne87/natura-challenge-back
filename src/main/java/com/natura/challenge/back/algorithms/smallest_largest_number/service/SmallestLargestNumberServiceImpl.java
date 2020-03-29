package com.natura.challenge.back.algorithms.smallest_largest_number.service;

import com.natura.challenge.back.algorithms.smallest_largest_number.dto.SmallestLargestNumberResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SmallestLargestNumberServiceImpl implements SmallestLargestNumberService {

    @Override
    public SmallestLargestNumberResult smallestLargestNumber(@NotEmpty List<Integer> numbers) {
        return SmallestLargestNumberResult.builder()
                .largest(23)
                .smallest(25)
                .build();
    }
}
