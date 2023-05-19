package com.cds.cgv.infrastructure;

import com.cds.cgv.domain.ReviewEntity;
import com.cds.cgv.domain.ReviewResponseWrapper;
import com.cds.cgv.domain.ReviewVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<ReviewEntity, Long> {
    @Query(value = "select r.reviewNumber as reviewNumber, " +
            "r.reviewer.userId as reviewerId, " +
            "r.reviewContent as reviewContent, " +
            "r.likes as likes, "+
            "r.createdAt as createdAt "+
            "from ReviewEntity r where r.movie.movieNumber = :movieId")
    Page<ReviewResponseWrapper> findByMovieId(Long movieId, Pageable pageable);
}
