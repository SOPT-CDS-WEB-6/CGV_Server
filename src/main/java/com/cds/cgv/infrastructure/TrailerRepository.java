package com.cds.cgv.infrastructure;

import com.cds.cgv.domain.Trailer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TrailerRepository extends JpaRepository<Trailer, Long> {
    @Query("select t from Trailer t where t.movie.movieNumber = :movieNumber order by t.trailerReleasedAt")
    List<Trailer> findAllByMovieNumber(Long movieNumber);
}
