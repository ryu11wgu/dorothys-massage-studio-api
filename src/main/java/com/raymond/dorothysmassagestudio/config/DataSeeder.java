package com.raymond.dorothysmassagestudio.config;

import com.raymond.dorothysmassagestudio.model.BusinessHour;
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
                "Since 1996, she has offered mindful, intuitive touch-customized treatments designed to calm the nervous system, release tension, and revitalize both body and mind.",
                "Sessions are designed to support the body's natural healing process."
        ));

        businessInfo.getBusinessHours().add(createBusinessHour(businessInfo, "Monday", "8:00 am - 10:00 pm", 1));
        businessInfo.getBusinessHours().add(createBusinessHour(businessInfo, "Tuesday", "8:00 am - 10:00 pm", 2));
        businessInfo.getBusinessHours().add(createBusinessHour(businessInfo, "Wednesday", "7:00 pm - 10:00 pm", 3));
        businessInfo.getBusinessHours().add(createBusinessHour(businessInfo, "Thursday", "8:00 am - 10:00 pm", 4));
        businessInfo.getBusinessHours().add(createBusinessHour(businessInfo, "Friday", "8:00 am - 10:00 pm", 5));
        businessInfo.getBusinessHours().add(createBusinessHour(businessInfo, "Saturday", "8:00 am - 10:00 pm", 6));
        businessInfo.getBusinessHours().add(createBusinessHour(businessInfo, "Sunday", "Closed", 7));

        businessInfoRepository.save(businessInfo);
    }

    private BusinessHour createBusinessHour(
            BusinessInfo businessInfo,
            String day,
            String hours,
            Integer displayOrder
    ) {
        BusinessHour businessHour = new BusinessHour();
        businessHour.setBusinessInfo(businessInfo);
        businessHour.setDay(day);
        businessHour.setHours(hours);
        businessHour.setDisplayOrder(displayOrder);
        return businessHour;
    }
}