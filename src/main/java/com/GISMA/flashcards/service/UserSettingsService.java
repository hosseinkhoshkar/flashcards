package com.GISMA.flashcards.service;

import com.GISMA.flashcards.mongo.UserSettings;
import com.GISMA.flashcards.repository.UserSettingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserSettingsService {

    @Autowired
    private UserSettingsRepository userSettingsRepository;

    public UserSettings findByUserId(String userId) {
        return userSettingsRepository.findByUserId(userId);
    }

    public UserSettings save(UserSettings userSettings) {
        return userSettingsRepository.save(userSettings);
    }
}

