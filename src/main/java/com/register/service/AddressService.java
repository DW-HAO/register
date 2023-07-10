package com.register.service;

import com.register.model.pojo.Address;

import java.util.List;

public interface AddressService {

    List<Address> getAllAddress();

    Address getAddressId(Address ad);

    Address getAddressById(Long aId);

    int insertAddress(Address ad);

    int updateAddress(Address ad);
}
