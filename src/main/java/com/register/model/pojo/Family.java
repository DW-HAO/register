package com.register.model.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class Family implements Serializable {

    private Long id;
    private String headName;
    private Integer totalMembers;
    private Address addressId;

    @Override
    public String toString() {
        return "Family{" +
                "id=" + id +
                ", headName='" + headName + '\'' +
                ", totalMembers=" + totalMembers +
                ", addressId=" + addressId.getId() +
                '}';
    }
}
