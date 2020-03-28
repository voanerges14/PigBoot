package com.little_pig_bot.configuration;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

import com.github.kshashov.telegram.config.TelegramBotGlobalProperties.Builder;
import com.github.kshashov.telegram.config.TelegramBotGlobalPropertiesConfiguration;
import com.github.kshashov.telegram.handler.processor.arguments.BotRequestMethodArgumentResolver;
import com.google.common.collect.Lists;
import okhttp3.OkHttpClient;

//@Component
public class BotConfiguration implements TelegramBotGlobalPropertiesConfiguration {

    @Override
    public void configure(Builder builder) {
        builder
            .argumentResolvers(Lists.newArrayList(new BotRequestMethodArgumentResolver()))
            .configureBot("591199063:AAHN3K8g2CNa0jBXt_HV10PuV5Gbh6Rv058",
                botBuilder -> botBuilder.okHttpClient(new OkHttpClient.Builder()
                .connectTimeout(12, TimeUnit.SECONDS)
                .build()));
    }
}
