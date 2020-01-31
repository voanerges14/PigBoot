package com.little_pig_bot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.little_pig_bot.model.Note;
import com.little_pig_bot.repository.NoteRepository;
import com.pengrad.telegrambot.model.Update;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@AllArgsConstructor
public class NoteServiceImpl implements NoteService{

    private NoteRepository noteRepository;

    @Override
    public void saveNote(Note note) {
        noteRepository.save(note);
    }

    @Override
    public List<Note> getNotes() {
        return noteRepository.findAll();
    }

    @Override
    public void saveNote(Update update) {
        String text = update.message().text();
        String username = update.message().from().username();

        noteRepository.save(Note.builder().text(text).username(username).build());
        log.info("saving text: {}", text);
    }
}
