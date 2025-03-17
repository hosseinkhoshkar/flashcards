package com.GISMA.flashcards.controller;

import com.GISMA.flashcards.model.StudyHistory;
import com.GISMA.flashcards.model.User;
import com.GISMA.flashcards.service.StudyHistoryService;
import com.GISMA.flashcards.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/history")
public class StudyHistoryController {

    @Autowired
    private StudyHistoryService studyHistoryService;
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<StudyHistory>> getUserStudyHistory(@RequestParam String username) {
        Optional<User> user = userService.findByUsername(username);
        if (user.isPresent()) {
            List<StudyHistory> studyHistory = studyHistoryService.findByUser(user.get());
            return new ResponseEntity<>(studyHistory, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<StudyHistory> addStudyHistory(@RequestBody StudyHistory studyHistory, @RequestParam String username) {
        Optional<User> user = userService.findByUsername(username);
        if (user.isPresent()) {
            studyHistory.setUser(user.get());
            StudyHistory savedStudyHistory = studyHistoryService.save(studyHistory);
            return new ResponseEntity<>(savedStudyHistory, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
