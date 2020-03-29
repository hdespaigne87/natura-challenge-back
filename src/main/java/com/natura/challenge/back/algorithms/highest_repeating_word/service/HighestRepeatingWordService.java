package com.natura.challenge.back.algorithms.highest_repeating_word.service;

import com.natura.challenge.back.algorithms.highest_repeating_word.dto.HighestRepeatingWordResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;

@Validated
public interface HighestRepeatingWordService {

    HighestRepeatingWordResult findHighestRepeatingWord(@NotNull MultipartFile file);
}
