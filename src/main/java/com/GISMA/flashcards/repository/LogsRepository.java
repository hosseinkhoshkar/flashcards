package com.GISMA.flashcards.repository;

import com.GISMA.flashcards.model.Logs;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogsRepository extends MongoRepository<Logs, String> {
}
