package com.little_pig_bot.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.little_pig_bot.model.Note;
import com.little_pig_bot.model.User;
import com.little_pig_bot.repository.NoteRepository;
import com.little_pig_bot.repository.UserRepository;
import com.pengrad.telegrambot.model.Update;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.var;

@Slf4j
@Service
@AllArgsConstructor
public class NoteServiceImpl implements NoteService {

    private UserRepository userRepository;

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
    public List<Note> getNotes(Integer userId) {
        return noteRepository.findAllByUserId(userId);
    }

    @Override
    @Transactional
    public void saveNote(Update update) {
        var telegramUser = update.message().from();
        User user = userRepository.findById(telegramUser.id())
            .orElse(User.builder()
                .id(telegramUser.id())
                .firstName(telegramUser.firstName())
                .lastName(telegramUser.lastName())
                .username(telegramUser.username())
                .build());

        String text = update.message().text();

        Note note = Note.builder().text(text).user(user).build();
        user.addNote(note);

        noteRepository.save(note);
        log.info("saving username: {} text: {}", user.getUsername(), text);
    }
}
