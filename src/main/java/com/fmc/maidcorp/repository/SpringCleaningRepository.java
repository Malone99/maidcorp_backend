package com.fmc.maidcorp.repository;

import com.fmc.maidcorp.domain.maidservices.SpringCleaning;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringCleaningRepository extends JpaRepository<SpringCleaning,Long>{

}
