package com.little_pig_bot.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    //TODO: get user id srom tocken/session
    // https://stackoverflow.com/questions/31159075/how-to-find-out-the-currently-logged-in-user-in-spring-boot
    @PostMapping
    public Note addNote(@RequestBody String text) {
        return noteService.saveNote(345598708, text);
    }

    @DeleteMapping("/{id}")
    public void deleteNote(@PathVariable Long id){
        noteService.deleteNote(id);
    }
}
