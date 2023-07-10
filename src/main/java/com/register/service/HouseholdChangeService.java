package com.register.service;

import com.register.model.pojo.HouseholdChange;

import java.util.List;
import java.util.Map;

public interface HouseholdChangeService {

    List<HouseholdChange> getAllHouseholdChange();

    List<HouseholdChange> getHouseholdChangeByUserId(Long uId);

    int changIn(Map<String, Object> map);

    int changOut(Map<String, Object> map);

    int deleteHouseholdChange(Long hcId);
}
