package com.raymond.dorothysmassagestudio.dto;

public record BusinessHourResponse(
        Long id,
        String day,
        String hours,
        Integer displayOrder
) {
}