package com.littlePigBot.littlePigBot.controllers;

import com.littlePigBot.littlePigBot.model.EchoModel;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import java.lang.String;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class EchoController {

    public final EchoModel echoModel;

    @ApiOperation(value="return echo", notes="returning text")
    @GetMapping("/echo")
    public String echoGet(@RequestParam(required = false, defaultValue = "NOTHING") String value){
        return echoModel.getEchoText();
    }

    @PostMapping("/echo")
    public String echoPost(@RequestParam(required = false, defaultValue = "NOTHING") String value){
        echoModel.setEchoText(value);
        return "";
    }
}
