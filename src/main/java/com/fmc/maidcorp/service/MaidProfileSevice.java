package com.fmc.maidcorp.service;

import com.fmc.maidcorp.domain.MaidProfile;

import java.util.List;

public interface MaidProfileSevice extends IService<MaidProfile,Long>{

    List<MaidProfile> findAll();
    MaidProfile update(MaidProfile update);
}
