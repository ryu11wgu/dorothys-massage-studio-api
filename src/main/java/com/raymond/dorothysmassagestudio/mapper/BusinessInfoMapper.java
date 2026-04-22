package com.raymond.dorothysmassagestudio.mapper;

import com.raymond.dorothysmassagestudio.dto.BusinessInfoResponse;
import com.raymond.dorothysmassagestudio.model.BusinessInfo;
import org.springframework.stereotype.Component;

@Component
public class BusinessInfoMapper {

    public BusinessInfoResponse toResponse(BusinessInfo businessInfo) {
        return new BusinessInfoResponse(
                businessInfo.getId(),
                businessInfo.getName(),
                businessInfo.getPhoneDisplay(),
                businessInfo.getPhoneHref(),
                businessInfo.getAddressLines(),
                businessInfo.getHomeIntroTitle(),
                businessInfo.getHomeIntroParagraphs(),
                businessInfo.getContactIntro()
        );
    }
}