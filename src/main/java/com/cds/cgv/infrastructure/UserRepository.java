package com.cds.cgv.infrastructure;

import com.cds.cgv.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User getUserByUserNumber(Long userId);
}
