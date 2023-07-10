package com.register.exception;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = IncorrectCredentialsException.class)
    public String handlerIncorrectCredentialsException(Model model) {
        model.addAttribute("msg", "账号或密码错误");
        return "login";
    }

    @ExceptionHandler(value = AuthorizationException.class)
    public String handlerAuthorizationException() {
        return "redirect:/index";
    }

    @ExceptionHandler(UnknownAccountException.class)
    public String handlerUnknownAccountException(Model model) {
        model.addAttribute("msg", "账号或密码错误");
        return "login";
    }
}
