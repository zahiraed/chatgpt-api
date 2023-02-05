package com.chatgptapi.app;

import com.chatgptapi.app.models.Answer;
import com.chatgptapi.app.models.Question;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

public class ChatGPTUtils {

    public static Answer getAnswer(HttpResponse<String> httpResponse) throws IOException {
        Answer answer = new Answer();
        String body = httpResponse.body();
        String choices = new ObjectMapper().readTree(body).get("choices").toString();
        Answer[] answers = new ObjectMapper().readValue(choices, Answer[].class);
        answer.setText(answers[0].getText());
        return answer;
    }

}
