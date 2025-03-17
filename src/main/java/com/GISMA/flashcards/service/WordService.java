package com.GISMA.flashcards.service;

import com.GISMA.flashcards.model.Word;
import com.GISMA.flashcards.model.User;
import com.GISMA.flashcards.repository.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WordService {

    @Autowired
    private WordRepository wordRepository;

    public List<Word> findByUser(User user) {
        return wordRepository.findByUser(user);
    }

    public Word save(Word word) {
        return wordRepository.save(word);
    }

    public void delete(Long wordId) {
        wordRepository.deleteById(wordId);
    }
}

