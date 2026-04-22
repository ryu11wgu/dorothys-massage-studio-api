package com.raymond.dorothysmassagestudio.dto;

import java.util.List;

public record BusinessInfoResponse(
        Long id,
        String name,
        String phoneDisplay,
        String phoneHref,
        List<String> addressLines,
        String homeIntroTitle,
        List<String> homeIntroParagraphs,
        String contactIntro
) {
}