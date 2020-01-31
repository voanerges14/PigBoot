package com.little_pig_bot.service;


import java.util.List;

import com.little_pig_bot.model.Note;
import com.pengrad.telegrambot.model.Update;

public interface NoteService {

    void saveNote(Note note);

    List<Note> getNotes();

    void saveNote(Update update);

}
