package com.raymond.dorothysmassagestudio.config;

import com.raymond.dorothysmassagestudio.model.BusinessInfo;
import com.raymond.dorothysmassagestudio.repository.BusinessInfoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataSeeder implements CommandLineRunner {

    private final BusinessInfoRepository businessInfoRepository;

    public DataSeeder(BusinessInfoRepository businessInfoRepository) {
        this.businessInfoRepository = businessInfoRepository;
    }

    @Override
    public void run(String... args) {
        if (businessInfoRepository.count() > 0) {
            return;
        }

        BusinessInfo businessInfo = new BusinessInfo();
        businessInfo.setName("Dorothy's Massage Studio");
        businessInfo.setPhoneDisplay("(661) 405-4079");
        businessInfo.setPhoneHref("tel:+16614054079");
        businessInfo.setAddressLines(List.of(
                "1034 W Ave L 12",
                "Suite 101 Room #5",
                "Lancaster, CA 93534"
        ));
        businessInfo.setHomeIntroTitle("Therapeutic care with over 25 years of experience");
        businessInfo.setHomeIntroParagraphs(List.of(
                "Book your appointment with Dorothy, a seasoned massage therapist and healing practitioner with over 25 years of experience.",
                "Since 1996, she has offered mindful, intuitive touch-customized treatments designed to calm the nervous system, release tension, and revitalize both body and mind."
        ));

        businessInfoRepository.save(businessInfo);
    }
}