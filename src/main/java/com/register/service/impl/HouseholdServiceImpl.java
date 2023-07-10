package com.register.service.impl;

import com.register.dao.HouseholdDao;
import com.register.model.po.FamilyMember;
import com.register.model.pojo.Household;
import com.register.service.HouseholdService;
import com.register.utils.SnowFlakeGenerateIdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class HouseholdServiceImpl implements HouseholdService {

    @Autowired
    private HouseholdDao householdDao;


    @Override
    public List<Household> getAllHousehold() {
        return householdDao.getAllHousehold();
    }

    @Override
    public Household getHouseholdByUserId(Long uId) {
        return householdDao.getHouseholdByUserId(uId);
    }

    @Override
    public List<FamilyMember> getFamilyMembers(Long aId) {
        return householdDao.getFamilyMembers(aId);
    }

    @Override
    public int addHousehold(Map<String, Object> map) {
        return householdDao.addHousehold(map);
    }

    @Override
    public int updateHouse(Map<String, Object> map) {
        return householdDao.updateHouse(map);
    }
}
