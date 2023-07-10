package com.register.controller;

import com.register.model.po.UserInfo;
import com.register.model.pojo.Address;
import com.register.model.pojo.Household;
import com.register.model.pojo.HouseholdChange;
import com.register.model.pojo.LoginUser;
import com.register.model.pojo.User;
import com.register.service.AddressService;
import com.register.service.HouseholdChangeService;
import com.register.service.HouseholdService;
import com.register.service.UserService;
import com.register.utils.SnowFlakeGenerateIdWorker;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/admin")
@RequiresRoles("admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private AddressService addressService;

    @Autowired
    private HouseholdService householdService;

    @Autowired
    private HouseholdChangeService householdChangeService;

    @GetMapping("/goToAddUser")
    public String goToAddUser(HttpSession session, Model model) {
        LoginUser loginUser = (LoginUser) session.getAttribute("loginUser");
        model.addAttribute("loginUser", loginUser);
        return "admin_add_user";
    }

    @PostMapping("/addUser")
    public String addUser(User u,
                          @RequestParam("bd") String bd,
                          HttpSession session,
                          Model model) throws ParseException {
        LoginUser loginUser = (LoginUser) session.getAttribute("loginUser");
        model.addAttribute("loginUser", loginUser);
        SnowFlakeGenerateIdWorker idWorker = new SnowFlakeGenerateIdWorker(0L, 0L);
        long uId = idWorker.nextId();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date birthDate = sdf.parse(bd);
        u.setId(uId);
        u.setBirthDate(birthDate);
        session.setAttribute("u", u);
        return "admin_add_address";
    }

    @PostMapping("/addAddress")
    public String addAddress(Address ad, HttpSession session, Model model) {
        LoginUser loginUser = (LoginUser) session.getAttribute("loginUser");
        model.addAttribute("loginUser", loginUser);
        User u = (User) session.getAttribute("u");
        userService.insertUser(u);
        SnowFlakeGenerateIdWorker idWorker = new SnowFlakeGenerateIdWorker(0L, 0L);
        Address sel_ad = addressService.getAddressId(ad);
        Long aId;
        if (sel_ad == null) {
            aId = idWorker.nextId();
            ad.setId(aId);
            addressService.insertAddress(ad);
        } else {
            aId = sel_ad.getId();
        }
        long hcId = idWorker.nextId();
        long hId = idWorker.nextId();
        Map<String, Object> map = new HashMap<>();
        map.put("householdType", "本地户籍");
        map.put("in_id", hcId);
        map.put("hId", hId);
        map.put("uId", u.getId());
        map.put("aId", aId);
        map.put("in_aId", aId);
        householdService.addHousehold(map);
        householdChangeService.changIn(map);

        session.removeAttribute("u");
        return "index";
    }

    @GetMapping("/showUserInfo")
    public String showUserInfo(Model model, HttpSession session) {
        List<UserInfo> userInfoList = userService.getAllUser();
        LoginUser loginUser = (LoginUser) session.getAttribute("loginUser");
        model.addAttribute("loginUser", loginUser);
        model.addAttribute("userInfoList", userInfoList);
        return "admin_show_user_info";
    }

    @GetMapping("/showUserInfoByKey")
    public String showUserInfoByKey(String key, Model model, HttpSession session) {
        LoginUser loginUser = (LoginUser) session.getAttribute("loginUser");
        model.addAttribute("loginUser", loginUser);
        List<UserInfo> userInfoList = userService.getUserByKey(key);
        model.addAttribute("userInfoList", userInfoList);
        return "admin_show_user_info";
    }

    @GetMapping("/showAddress")
    public String showAddress(Model model, HttpSession session) {
        LoginUser loginUser = (LoginUser) session.getAttribute("loginUser");
        model.addAttribute("loginUser", loginUser);
        List<Address> addressList = addressService.getAllAddress();
        model.addAttribute("addressList", addressList);
        return "admin_show_address";
    }

    @GetMapping("/goToUpdate/{aId}")
    public String goToUpdate(Model model, @PathVariable Long aId, HttpSession session) {
        LoginUser loginUser = (LoginUser) session.getAttribute("loginUser");
        model.addAttribute("loginUser", loginUser);
        Address address = addressService.getAddressById(aId);
        model.addAttribute("address", address);
        return "admin_update_address";
    }

    @PostMapping("updateAddress")
    public String updateAddress(Address ad, Model model, HttpSession session) {
        LoginUser loginUser = (LoginUser) session.getAttribute("loginUser");
        model.addAttribute("loginUser", loginUser);
        addressService.updateAddress(ad);
        return "index";
    }

    @GetMapping("/showChange")
    public String showChange(Model model, HttpSession session) {
        LoginUser loginUser = (LoginUser) session.getAttribute("loginUser");
        model.addAttribute("loginUser", loginUser);
        List<HouseholdChange> changeList = householdChangeService.getAllHouseholdChange();
        model.addAttribute("changeList", changeList);
        return "admin_show_change";
    }

    @GetMapping("/deleteChange/{hcId}")
    public String deleteChange(@PathVariable Long hcId, HttpSession session, Model model) {
        LoginUser loginUser = (LoginUser) session.getAttribute("loginUser");
        model.addAttribute("loginUser", loginUser);
        householdChangeService.deleteHouseholdChange(hcId);
        return "index";
    }

    @GetMapping("/goToChange/{uId}")
    public String goToChange(HttpSession session, @PathVariable Long uId, Model model) {
        LoginUser loginUser = (LoginUser) session.getAttribute("loginUser");
        model.addAttribute("loginUser", loginUser);
        session.setAttribute("uId", uId);
        return "admin_update_change";
    }

    @PostMapping("/updateChange")
    public String updateChange(HttpSession session, Address ad, Model model) {
        LoginUser loginUser = (LoginUser) session.getAttribute("loginUser");
        model.addAttribute("loginUser", loginUser);
        Map<String, Object> map = new HashMap<>();
        SnowFlakeGenerateIdWorker idWorker = new SnowFlakeGenerateIdWorker(0L, 0L);
        long out_hcId = idWorker.nextId();
        long in_hcId = idWorker.nextId();
        long aId = idWorker.nextId();

        Long uId = (Long) session.getAttribute("uId");
        Household household = householdService.getHouseholdByUserId(uId);
        Long hId = household.getId();

        map.put("in_id", in_hcId);
        map.put("out_id", out_hcId);
        map.put("in_aId", aId);
        map.put("out_aId", null);
        map.put("uId", uId);
        map.put("hId", hId);

        difAd(ad, aId, map);
        return "index";
    }

    private void difAd(Address ad, Long aId, Map<String, Object> map) {
        Address address = addressService.getAddressId(ad);
        if (address == null) {
            ad.setId(aId);
            addressService.insertAddress(ad);
            doChange(map);
        } else {
            Long in_aId = address.getId();
            map.put("in_aId", in_aId);
            doChange(map);
        }
    }

    private void doChange(Map<String, Object> map) {
        Household household = householdService.getHouseholdByUserId((Long) map.get("uId"));
        Long out_aId = household.getAddress().getId();
        map.put("out_aId", out_aId);
        householdChangeService.changOut(map);
        householdChangeService.changIn(map);
        householdService.updateHouse(map);
    }
}
