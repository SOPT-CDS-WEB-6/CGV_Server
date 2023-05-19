package com.cds.cgv.infrastructure;

import com.cds.cgv.domain.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    @Query("SELECT r FROM Reservation r WHERE r.user.userNumber = :userId ORDER BY r.startDate DESC")
    List<Reservation> findAllByUserId(Long userId);
}
