package com.cds.cgv.domain;

import java.time.LocalDateTime;

public interface ReviewResponseWrapper {
    Long getReviewNumber();
    String getReviewerId();
    String getReviewContent();
    Integer getLikes();
    LocalDateTime getCreatedAt();
}

