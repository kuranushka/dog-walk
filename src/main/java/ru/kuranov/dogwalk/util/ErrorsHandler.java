package ru.kuranov.dogwalk.util;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.Set;

@Service
public interface ErrorsHandler {
    Set<String> getErrors(BindingResult bindingResult);
}
