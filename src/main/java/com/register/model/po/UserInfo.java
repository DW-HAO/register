package com.register.model.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class UserInfo implements Serializable {

    /**
     * 编号
     */
    private Long id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 电联
     */
    private String telephone;
    /**
     * 性别
     */
    private String gender;
    /**
     * 身份证
     */
    private String idCardNumber;
    /**
     * 生日
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date birthDate;
    /**
     * 省份
     */
    private String province;
    /**
     * 城市
     */
    private String city;
    /**
     * 县区
     */
    private String district;
    /**
     * 街道
     */
    private String street;
    /**
     * 门牌号
     */
    private String houseNumber;
    /**
     * 户籍类型
     */
    private String householdType;
}
