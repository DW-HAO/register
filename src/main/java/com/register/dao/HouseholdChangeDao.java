package com.register.dao;

import com.register.model.pojo.HouseholdChange;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface HouseholdChangeDao {

    List<HouseholdChange> getAllHouseholdChange();

    List<HouseholdChange> getHouseholdChangeByUserId(Long uId);

    int changIn(Map<String, Object> map);

    int changOut(Map<String, Object> map);

    int deleteHouseholdChange(Long hcId);
}
