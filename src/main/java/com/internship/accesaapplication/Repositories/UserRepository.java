package com.internship.accesaapplication.Repositories;

import com.internship.accesaapplication.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findById(long id);
    User findByUsername(String username);
}
