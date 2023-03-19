package com.example.springboot;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;


@ControllerAdvice
@RequestMapping("/error")
public class ErrorController {

    @ExceptionHandler(Exception.class)
    public String handleException() {
        return "index";
    }
}