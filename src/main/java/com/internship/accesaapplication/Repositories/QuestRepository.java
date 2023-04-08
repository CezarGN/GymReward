package com.internship.accesaapplication.Repositories;

import com.internship.accesaapplication.Entities.Quest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestRepository extends JpaRepository<Quest,Long> {
    Quest findQuestById(long id);
    Quest findByName(String name);
}
