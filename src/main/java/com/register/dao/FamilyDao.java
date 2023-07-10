package com.register.dao;

import com.register.model.po.FamilyMember;
import com.register.model.pojo.Family;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FamilyDao {

    List<Family> getAllFamily();

    List<FamilyMember> getFamilyMembers();
}
