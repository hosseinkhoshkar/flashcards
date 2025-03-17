package com.GISMA.flashcards.service;


import com.GISMA.flashcards.model.StudyHistory;
import com.GISMA.flashcards.model.User;
import com.GISMA.flashcards.repository.StudyHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudyHistoryService {

    @Autowired
    private StudyHistoryRepository studyHistoryRepository;

    public List<StudyHistory> findByUser(User user) {
        return studyHistoryRepository.findByUser(user);
    }

    public StudyHistory save(StudyHistory studyHistory) {
        return studyHistoryRepository.save(studyHistory);
    }
}

