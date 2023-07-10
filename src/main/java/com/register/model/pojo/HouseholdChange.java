package com.register.model.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HouseholdChange {

    private Long id;
    private Household household;
    private User user;
    private Address address;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date changeDate;
    private String changeType;
}
