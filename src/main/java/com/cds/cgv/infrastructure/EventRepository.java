package com.cds.cgv.infrastructure;

import com.cds.cgv.domain.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<EventEntity, Integer> {
    List<EventEntity> findTop4ByOrderByStartedAtDesc();
}
