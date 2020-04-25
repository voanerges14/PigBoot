package com.little_pig_bot.service;


import java.util.List;

import com.little_pig_bot.model.Note;
import com.pengrad.telegrambot.model.Update;

public interface NoteService {
    void saveNote(Update update);

    void saveNote(Note note);

    Note saveNote(Integer userId, String text);

    List<Note> getNotes();

    List<Note> getNotes(Integer userId);

    void deleteNote(Long id);

}
