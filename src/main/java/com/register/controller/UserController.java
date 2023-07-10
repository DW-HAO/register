package com.register.controller;

import com.register.model.po.FamilyMember;
import com.register.model.po.UserInfo;
import com.register.model.pojo.Household;
import com.register.model.pojo.HouseholdChange;
import com.register.model.pojo.LoginUser;
import com.register.model.pojo.User;
import com.register.service.HouseholdChangeService;
import com.register.service.HouseholdService;
import com.register.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/user")
@RequiresRoles("user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private HouseholdService householdService;

    @Autowired
    private HouseholdChangeService householdChangeService;

    @GetMapping("/showInfo")
    public String showInfo(Model model, HttpSession session) {
        LoginUser loginUser = (LoginUser) session.getAttribute("loginUser");
        model.addAttribute("loginUser", loginUser);
        String name = SecurityUtils.getSubject().getPrincipal().toString();
        List<UserInfo> userInfoList = userService.getUserByKey(name);
        UserInfo user = userInfoList.get(0);
        model.addAttribute("user", user);
        return "user_show_info";
    }

    @GetMapping("/goToUpdate")
    public String goToUpdate(Model model, HttpSession session) {
        LoginUser loginUser = (LoginUser) session.getAttribute("loginUser");
        model.addAttribute("loginUser", loginUser);
        String name = SecurityUtils.getSubject().getPrincipal().toString();
        List<UserInfo> userInfoList = userService.getUserByKey(name);
        UserInfo user = userInfoList.get(0);
        model.addAttribute("user", user);
        return "user_update_info";
    }

    @PostMapping("/updateInfo")
    public String updateInfo(User u, @RequestParam("birth_date") String bd,
                             Model model,
                             HttpSession session) throws ParseException {
        LoginUser loginUser = (LoginUser) session.getAttribute("loginUser");
        model.addAttribute("loginUser", loginUser);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date birthDate = sdf.parse(bd);
        u.setBirthDate(birthDate);
        userService.updateUser(u);
        return "index";
    }

    @GetMapping("/showFamilyMembers")
    public String showFamilyMembers(Model model, HttpSession session) {
        LoginUser loginUser = (LoginUser) session.getAttribute("loginUser");
        model.addAttribute("loginUser", loginUser);
        String name = SecurityUtils.getSubject().getPrincipal().toString();
        List<UserInfo> userInfoList = userService.getUserByKey(name);
        Long uId = userInfoList.get(0).getId();
        Household household = householdService.getHouseholdByUserId(uId);
        List<FamilyMember> familyMembers = householdService.getFamilyMembers(household.getAddress().getId());
        model.addAttribute("familyMembers", familyMembers);
        return "user_show_family_members";
    }

    @GetMapping("/showChange")
    public String showChange(Model model, HttpSession session) {
        LoginUser loginUser = (LoginUser) session.getAttribute("loginUser");
        model.addAttribute("loginUser", loginUser);
        String name = SecurityUtils.getSubject().getPrincipal().toString();
        List<UserInfo> userInfoList = userService.getUserByKey(name);
        Long uId = userInfoList.get(0).getId();
        List<HouseholdChange> changeList = householdChangeService.getHouseholdChangeByUserId(uId);
        model.addAttribute("changeList", changeList);
        return "user_show_change";
    }
}
