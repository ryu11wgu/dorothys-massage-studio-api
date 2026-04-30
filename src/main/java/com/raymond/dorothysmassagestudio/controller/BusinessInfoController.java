package com.raymond.dorothysmassagestudio.controller;

import com.raymond.dorothysmassagestudio.dto.BusinessInfoResponse;
import com.raymond.dorothysmassagestudio.service.BusinessInfoService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class BusinessInfoController {

    private final BusinessInfoService businessInfoService;

    public BusinessInfoController(BusinessInfoService businessInfoService) {
        this.businessInfoService = businessInfoService;
    }

    @GetMapping("/api/business-info")
    public BusinessInfoResponse getBusinessInfo() {
        return businessInfoService.getBusinessInfo();
    }
}