package com.register.model.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Household implements Serializable {

    private Long id;
    private String householdType;
    private User user;
    private Address address;
}
