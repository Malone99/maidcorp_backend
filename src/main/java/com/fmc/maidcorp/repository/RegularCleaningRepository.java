package com.fmc.maidcorp.repository;

import com.fmc.maidcorp.domain.maidservices.RegularCleaning;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegularCleaningRepository extends JpaRepository<RegularCleaning,Long> {
}
