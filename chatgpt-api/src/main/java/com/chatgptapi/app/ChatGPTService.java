package com.chatgptapi.app;

import com.chatgptapi.app.models.Answer;
import com.chatgptapi.app.models.Question;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class ChatGPTService {
    @Value("${openai.apikey}")
    private String APIKEY;
    @Value("${chatgpt.url}")
    private String URL;
    @Autowired
    private Question question;


    public String ask(String prompt) {
        question.setPrompt(prompt);
        try {
            Answer answer = this.sendQuestion(question);
            return answer.getText();
        } catch (IOException | InterruptedException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    public Answer sendQuestion(Question question) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(this.URL))
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer ".concat(this.APIKEY))
                .POST(HttpRequest.BodyPublishers.ofString(new ObjectMapper().writeValueAsString(question)))
                .build();
        HttpResponse<String> httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());
        return ChatGPTUtils.getAnswer(httpResponse);
    }

}
