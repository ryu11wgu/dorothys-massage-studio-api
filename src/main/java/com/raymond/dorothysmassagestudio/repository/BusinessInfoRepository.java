package com.raymond.dorothysmassagestudio.repository;

import com.raymond.dorothysmassagestudio.model.BusinessInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusinessInfoRepository extends JpaRepository<BusinessInfo, Long> {
}