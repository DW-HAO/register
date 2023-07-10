package com.register.service.impl;

import com.register.dao.FamilyDao;
import com.register.model.pojo.Family;
import com.register.service.FamilyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FamilyServiceImpl implements FamilyService {

    @Autowired
    private FamilyDao familyDao;

    @Override
    public List<Family> getAllFamily() {
        return familyDao.getAllFamily();
    }
}
