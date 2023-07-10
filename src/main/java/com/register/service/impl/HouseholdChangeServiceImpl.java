package com.register.service.impl;

import com.register.dao.HouseholdChangeDao;
import com.register.model.pojo.HouseholdChange;
import com.register.service.HouseholdChangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class HouseholdChangeServiceImpl implements HouseholdChangeService {

    @Autowired
    private HouseholdChangeDao householdChangeDao;

    @Override
    public List<HouseholdChange> getAllHouseholdChange() {
        return householdChangeDao.getAllHouseholdChange();
    }

    @Override
    public List<HouseholdChange> getHouseholdChangeByUserId(Long uId) {
        return householdChangeDao.getHouseholdChangeByUserId(uId);
    }

    @Override
    public int changIn(Map<String, Object> map) {
        return householdChangeDao.changIn(map);
    }

    @Override
    public int changOut(Map<String, Object> map) {
        return householdChangeDao.changOut(map);
    }

    @Override
    public int deleteHouseholdChange(Long hcId) {
        return householdChangeDao.deleteHouseholdChange(hcId);
    }
}
