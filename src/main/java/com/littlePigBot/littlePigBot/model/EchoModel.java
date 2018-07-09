package com.littlePigBot.littlePigBot.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Service
public class EchoModel {
    @Getter
    @Setter
    private String echoText;
}
