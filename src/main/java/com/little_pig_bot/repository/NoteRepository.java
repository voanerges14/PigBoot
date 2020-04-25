package com.little_pig_bot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.little_pig_bot.model.Note;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

    List<Note> findAllByGroupUserId(Integer userId);

}
