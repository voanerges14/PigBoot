package com.little_pig_bot.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.little_pig_bot.model.Note;
import com.little_pig_bot.service.NoteService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/notes")
@AllArgsConstructor
public class NoteController {

    private NoteService noteService;

    @GetMapping
    public List<Note> getNotes() {
        return noteService.getNotes();
    }

}
