package com.chatgptapi.app.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Question {
    private String prompt;

    private final String model;

    private final Integer max_tokens;

     private final Float temperature;


    @Autowired
    public Question(@Value("${chatgpt.model}") String model, @Value("${chatgpt.max_tokens}") Integer max_tokens,@Value("${chatgpt.temperature}") Float temperature) {
        this.model = model;
        this.max_tokens = max_tokens;
        this.temperature = temperature;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public String getPrompt() {
        return prompt;
    }

    public String getModel() {
        return model;
    }

    public Integer getMax_tokens() {
        return max_tokens;
    }

    public Float getTemperature() {
        return temperature;
    }

    @Override
    public String toString() {
        return "QuestionDTO{" +
                "prompt='" + prompt + '\'' + '}';
    }
}
