package com.GISMA.flashcards.controller;

import com.GISMA.flashcards.model.UserSettings;
import com.GISMA.flashcards.service.UserSettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/settings")
public class UserSettingsController {

    @Autowired
    private UserSettingsService userSettingsService;

    @GetMapping("/{userId}")
    public ResponseEntity<UserSettings> getUserSettings(@PathVariable String userId) {
        UserSettings settings = userSettingsService.findByUserId(userId);
        if (settings != null) {
            return new ResponseEntity<>(settings, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<UserSettings> updateUserSettings(@RequestBody UserSettings userSettings) {
        UserSettings updatedSettings = userSettingsService.save(userSettings);
        return new ResponseEntity<>(updatedSettings, HttpStatus.OK);
    }
}

