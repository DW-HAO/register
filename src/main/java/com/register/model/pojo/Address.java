package com.register.model.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address implements Serializable {

    private Long id;
    private String province;
    private String city;
    private String district;
    private String street;
    private String houseNumber;

    public Address(String province, String city, String district, String street, String houseNumber) {
        this.province = province;
        this.city = city;
        this.district = district;
        this.street = street;
        this.houseNumber = houseNumber;
    }
}
