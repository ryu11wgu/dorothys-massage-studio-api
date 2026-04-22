package com.raymond.dorothysmassagestudio.service;

import com.raymond.dorothysmassagestudio.dto.BusinessInfoResponse;
import com.raymond.dorothysmassagestudio.mapper.BusinessInfoMapper;
import com.raymond.dorothysmassagestudio.model.BusinessInfo;
import com.raymond.dorothysmassagestudio.repository.BusinessInfoRepository;
import org.springframework.stereotype.Service;

@Service
public class BusinessInfoService {

    private final BusinessInfoRepository businessInfoRepository;
    private final BusinessInfoMapper businessInfoMapper;

    public BusinessInfoService(
            BusinessInfoRepository businessInfoRepository,
            BusinessInfoMapper businessInfoMapper
    ) {
        this.businessInfoRepository = businessInfoRepository;
        this.businessInfoMapper = businessInfoMapper;
    }

    public BusinessInfoResponse getBusinessInfo() {
        BusinessInfo businessInfo = businessInfoRepository.findAll()
                .stream()
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Business information has not been configured yet."));

        return businessInfoMapper.toResponse(businessInfo);
    }
}
