package com.register;

import com.register.model.po.FamilyMember;
import com.register.model.po.UserInfo;
import com.register.model.pojo.Address;
import com.register.model.pojo.Household;
import com.register.model.pojo.HouseholdChange;
import com.register.model.pojo.LoginUser;
import com.register.model.pojo.User;
import com.register.service.AddressService;
import com.register.service.FamilyService;
import com.register.service.HouseholdChangeService;
import com.register.service.HouseholdService;
import com.register.service.LoginUserService;
import com.register.service.UserService;
import com.register.utils.SaltConstrutor;
import com.register.utils.SnowFlakeGenerateIdWorker;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.security.SecureRandom;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

@Slf4j
@SpringBootTest
class RegisterApplicationTests {

    @Autowired
    UserService userService;

    @Autowired
    AddressService addressService;

    @Autowired
    FamilyService familyService;

    @Autowired
    HouseholdService householdService;

    @Autowired
    HouseholdChangeService householdChangeService;

    @Autowired
    LoginUserService loginUserService;

    @Test
    void contextLoads() {
        Address address = new Address();
        SnowFlakeGenerateIdWorker idWorker = new SnowFlakeGenerateIdWorker(0L, 0L);
        long aId = idWorker.nextId();
        address.setId(aId);
        address.setProvince("广东省");
        address.setCity("广州市");
        address.setDistrict("番禺区");
        address.setStreet("沙湾街");
        address.setHouseNumber("沙湾古镇2号");
        addressService.insertAddress(address);
    }
}
