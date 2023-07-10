package com.register.model.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginUser implements Serializable {

    private String loginUser;
    private String password;
    private String salt;
    private Set<Role> role;
}
