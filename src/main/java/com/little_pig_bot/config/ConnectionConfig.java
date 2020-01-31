package com.little_pig_bot.config;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
//@Configuration
//@ConfigurationProperties("connection")
@AllArgsConstructor
public class ConnectionConfig {

    private String username;

    private String token;

}
