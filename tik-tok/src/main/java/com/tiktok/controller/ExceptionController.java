package com.tiktok.controller;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @auther DyingZhang
 * @Create 2022-08-26 16:41
 * @Discriptioon
 */
//异常处理器
@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(NullPointerException.class)
    public String HandlerArithmeticException(NullPointerException arithmeticException, Model model){
        model.addAttribute("arithmeticException",arithmeticException);
        return "errorPage/loginError";
    }

    @ExceptionHandler(DuplicateKeyException.class)
    public String DuplicateKeyException(DuplicateKeyException duplicateKeyException, Model model){
        model.addAttribute("duplicateKeyException",duplicateKeyException);
        return "errorPage/registerError";
    }
}
