package com.GISMA.flashcards.controller;

import com.GISMA.flashcards.model.Word;
import com.GISMA.flashcards.model.User;
import com.GISMA.flashcards.service.WordService;
import com.GISMA.flashcards.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/words")
public class WordController {

    @Autowired
    private WordService wordService;
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<Word>> getUserWords(@RequestParam String username) {
        Optional<User> user = userService.findByUsername(username);
        if (user.isPresent()) {
            List<Word> words = wordService.findByUser(user.get());
            return new ResponseEntity<>(words, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Word> addWord(@RequestBody Word word, @RequestParam String username) {
        Optional<User> user = userService.findByUsername(username);
        if (user.isPresent()) {
            word.setUser(user.get());
            Word savedWord = wordService.save(word);
            return new ResponseEntity<>(savedWord, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWord(@PathVariable Long id) {
        wordService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

