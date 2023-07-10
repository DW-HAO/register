package com.register.service.impl;

import com.register.dao.AddressDao;
import com.register.model.pojo.Address;
import com.register.service.AddressService;
import com.register.utils.SnowFlakeGenerateIdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressDao addressDao;

    @Override
    public List<Address> getAllAddress() {
        return addressDao.getAllAddress();
    }

    @Override
    public Address getAddressId(Address ad) {
        Address address = addressDao.getAddressId(ad);
        return address;
    }

    @Override
    public Address getAddressById(Long aId) {
        return addressDao.getAddressById(aId);
    }

    @Override
    public int insertAddress(Address ad) {
        return addressDao.insertAddress(ad);
    }

    @Override
    public int updateAddress(Address ad) {
        addressDao.updateAddress(ad);
        return 0;
    }
}
