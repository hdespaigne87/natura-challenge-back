package com.natura.challenge.back.algorithms.highest_repeating_word.service;

import com.natura.challenge.back.algorithms.highest_repeating_word.dto.HighestRepeatingWordResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;

@Service
@RequiredArgsConstructor
public class HighestRepeatingWordServiceImpl implements HighestRepeatingWordService {

    @Override
    public HighestRepeatingWordResult findHighestRepeatingWord(@NotNull MultipartFile file) {
        return HighestRepeatingWordResult.builder()
                .word("dsfdf")
                .timesRepeated(5)
                .build();
    }
}
