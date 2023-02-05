package com.chatgptapi.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatGPTController {
    @Autowired
    private ChatGPTService chatGPTService;

    @PostMapping("/")
    public String ask(@RequestBody String prompt) {
        return this.chatGPTService.ask(prompt);
    }

}
