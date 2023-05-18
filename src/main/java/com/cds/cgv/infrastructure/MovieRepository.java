package com.cds.cgv.infrastructure;

import com.cds.cgv.domain.Movie;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Override
    Optional<Movie> findById(Long movieNumber);
    @Query("select m from Movie m where m.releasedAt < CURRENT_TIMESTAMP and m.closedAt > CURRENT_TIMESTAMP")
    List<Movie> findMoviesOrderByReservationRate(Pageable pageable);
}
