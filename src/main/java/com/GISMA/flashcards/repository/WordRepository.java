package com.GISMA.flashcards.repository;

import com.GISMA.flashcards.model.Word;
import com.GISMA.flashcards.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WordRepository extends JpaRepository<Word, Long> {
    List<Word> findByUser(User user);
}
