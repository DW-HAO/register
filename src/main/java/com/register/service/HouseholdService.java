package com.register.service;

import com.register.model.po.FamilyMember;
import com.register.model.pojo.Household;

import java.util.List;
import java.util.Map;

public interface HouseholdService {

    List<Household> getAllHousehold();

    Household getHouseholdByUserId(Long uId);

    List<FamilyMember> getFamilyMembers(Long aId);

    int addHousehold(Map<String, Object> map);

    int updateHouse(Map<String, Object> map);
}
