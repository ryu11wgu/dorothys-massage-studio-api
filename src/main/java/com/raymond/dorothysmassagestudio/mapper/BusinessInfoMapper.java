package com.raymond.dorothysmassagestudio.mapper;

import com.raymond.dorothysmassagestudio.dto.BusinessHourResponse;
import com.raymond.dorothysmassagestudio.dto.BusinessInfoResponse;
import com.raymond.dorothysmassagestudio.model.BusinessHour;
import com.raymond.dorothysmassagestudio.model.BusinessInfo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BusinessInfoMapper {

    public BusinessInfoResponse toResponse(BusinessInfo businessInfo) {
        List<BusinessHourResponse> businessHours = businessInfo.getBusinessHours()
                .stream()
                .map(this::toBusinessHourResponse)
                .toList();

        return new BusinessInfoResponse(
                businessInfo.getId(),
                businessInfo.getName(),
                businessInfo.getPhoneDisplay(),
                businessInfo.getPhoneHref(),
                businessInfo.getAddressLines(),
                businessInfo.getHomeIntroTitle(),
                businessInfo.getHomeIntroParagraphs(),
                businessHours
        );
    }

    private BusinessHourResponse toBusinessHourResponse(BusinessHour businessHour) {
        return new BusinessHourResponse(
                businessHour.getId(),
                businessHour.getDay(),
                businessHour.getHours(),
                businessHour.getDisplayOrder()
        );
    }
}