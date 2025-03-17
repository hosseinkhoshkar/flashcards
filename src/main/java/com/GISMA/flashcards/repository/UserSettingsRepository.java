package com.GISMA.flashcards.repository;

import com.GISMA.flashcards.mongo.UserSettings;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSettingsRepository extends MongoRepository<UserSettings, String> {
    UserSettings findByUserId(String userId);
}
