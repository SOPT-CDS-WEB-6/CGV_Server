package com.cds.cgv.infrastructure;

import com.cds.cgv.domain.StillCutEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StillCutRepository extends JpaRepository<StillCutEntity, Long> {

    @Query(value = "select sc from StillCutEntity as sc where sc.movie.movieNumber = :movieNumber ")
    List<StillCutEntity> findAllByMovieNumber(Long movieNumber, Pageable pageable);
}
