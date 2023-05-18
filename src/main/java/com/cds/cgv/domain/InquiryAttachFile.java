package com.cds.cgv.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;

@Entity
@Table(name = "inquiry_attach_file")
@DynamicInsert
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InquiryAttachFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INT UNSIGNED")
    private Long inquiryAttachFileNumber;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inquiryNumber")
    private Inquiry inquiry;
    @Column(columnDefinition = "TEXT")
    private String fileLink;
}
