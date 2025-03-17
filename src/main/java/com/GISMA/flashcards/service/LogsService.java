package com.GISMA.flashcards.service;

import com.GISMA.flashcards.mongo.Logs;
import com.GISMA.flashcards.repository.LogsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogsService {

    @Autowired
    private LogsRepository logsRepository;

    public Logs save(Logs log) {
        return logsRepository.save(log);
    }
}

