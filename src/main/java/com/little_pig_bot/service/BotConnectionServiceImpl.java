package com.little_pig_bot.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class BotConnectionServiceImpl implements BotConnectionService{

    @Value("{$connection.username}")
    private String userName;

    @Value("{$connection.token}")
    private String token;

    @Override
    public String getUserName() {
        return userName;
    }

    @Override
    public String getToken() {
        return token;
    }
}
