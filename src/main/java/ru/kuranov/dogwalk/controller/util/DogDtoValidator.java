package ru.kuranov.dogwalk.controller.util;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;

@Service
@RequiredArgsConstructor
public class DogDtoValidator {

    public boolean validDate(String walkDate) {
        if (walkDate.isEmpty()) {
            return false;
        }
        LocalDate date = LocalDate.parse(walkDate);
        return date.isAfter(ChronoLocalDate.from(LocalDate.now()));
    }
}