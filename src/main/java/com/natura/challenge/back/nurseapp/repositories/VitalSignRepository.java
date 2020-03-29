package com.natura.challenge.back.nurseapp.repositories;

import com.natura.challenge.back.nurseapp.model.VitalSign;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface VitalSignRepository extends
        JpaRepository<VitalSign, String>, JpaSpecificationExecutor<VitalSign> {

}
