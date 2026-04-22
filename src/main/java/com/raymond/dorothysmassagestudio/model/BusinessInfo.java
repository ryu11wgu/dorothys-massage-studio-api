package com.raymond.dorothysmassagestudio.model;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OrderColumn;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "business_info")
public class BusinessInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "phone_display", nullable = false)
    private String phoneDisplay;

    @Column(name = "phone_href", nullable = false)
    private String phoneHref;

    @ElementCollection
    @CollectionTable(
            name = "business_address_lines",
            joinColumns = @JoinColumn(name = "business_info_id")
    )
    @OrderColumn(name = "line_order")
    @Column(name = "address_line", nullable = false)
    private List<String> addressLines = new ArrayList<>();

    @Column(name = "home_intro_title", nullable = false)
    private String homeIntroTitle;

    @ElementCollection
    @CollectionTable(
            name = "business_home_intro_paragraphs",
            joinColumns = @JoinColumn(name = "business_info_id")
    )
    @OrderColumn(name = "paragraph_order")
    @Column(name = "paragraph", columnDefinition = "TEXT", nullable = false)
    private List<String> homeIntroParagraphs = new ArrayList<>();

    @Column(name = "contact_intro", columnDefinition = "TEXT", nullable = false)
    private String contactIntro;
}