package com.little_pig_bot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.little_pig_bot.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
