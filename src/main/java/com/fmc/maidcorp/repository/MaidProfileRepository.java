package com.fmc.maidcorp.repository;

import com.fmc.maidcorp.domain.MaidProfile;
import com.fmc.maidcorp.dto.MaidProfileDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaidProfileRepository extends JpaRepository<MaidProfile,Long> {
    @Query("""
select new com.fmc.maidcorp.dto.MaidProfileDto(md.id, md.firstName, md.middleName, md.lastName, md.dob, md.address) from MaidProfile md 
""")
    List<MaidProfileDto> getAllDto();

    List<MaidProfile> findMaidProfileByLastNameContainsIgnoreCase(String surname);


}