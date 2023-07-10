package com.register.dao;

import com.register.model.pojo.Address;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AddressDao {

    List<Address> getAllAddress();

    Address getAddressId(Address ad);

    Address getAddressById(Long aId);

    int insertAddress(Address ad);

    int updateAddress(Address ad);
}
