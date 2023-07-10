package com.register.controller;

import com.register.model.pojo.LoginUser;
import com.register.service.LoginUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Slf4j
@Controller
public class LoginController {

    @Autowired
    private LoginUserService loginUserService;

    @RequestMapping("/index")
    public String index(Model model, HttpSession session) {
        LoginUser loginUser = (LoginUser) session.getAttribute("loginUser");
        model.addAttribute("loginUser", loginUser);
        return "index";
    }

    @GetMapping({"/goToLogin", "/"})
    public String goToLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String login(Model model,
                        HttpSession session,
                        @RequestParam("loginUser") String loginUser,
                        @RequestParam("password") String password) {
        if (!StringUtils.hasText(loginUser) || !StringUtils.hasText(password)) {
            model.addAttribute("msg", "请输入用户名和密码");
            return "login";
        } else {
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(loginUser, password);
            subject.login(token);
            String lu = subject.getPrincipal().toString();
            LoginUser user = loginUserService.getLoginUser(lu);
            session.setAttribute("loginUser", user);
            model.addAttribute("loginUser", user);

            log.info("住户->{}", subject.hasRole("user"));
            log.info("管理员->{}", subject.hasRole("admin"));
            return "forward:/index";
        }
    }

    @GetMapping("/logout")
    public String logout() {
        return "login";
    }
}
