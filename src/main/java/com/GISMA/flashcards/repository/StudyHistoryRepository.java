package com.GISMA.flashcards.repository;

import com.GISMA.flashcards.model.StudyHistory;
import com.GISMA.flashcards.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudyHistoryRepository extends JpaRepository<StudyHistory, Long> {
    List<StudyHistory> findByUser(User user);
}
