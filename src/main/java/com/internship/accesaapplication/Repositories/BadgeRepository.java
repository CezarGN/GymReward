package com.internship.accesaapplication.Repositories;

import com.internship.accesaapplication.Entities.Badge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BadgeRepository extends JpaRepository<Badge, Long> {
    Badge findByName(String name);
}
