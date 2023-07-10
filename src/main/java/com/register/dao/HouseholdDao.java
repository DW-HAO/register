package com.register.dao;

import com.register.model.po.FamilyMember;
import com.register.model.pojo.Household;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface HouseholdDao {

    List<Household> getAllHousehold();

    Household getHouseholdByUserId(Long uId);

    List<FamilyMember> getFamilyMembers(Long aId);

    int addHousehold(Map<String, Object> map);

    int updateHouse(Map<String, Object> map);
}
