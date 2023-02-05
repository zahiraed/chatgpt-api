package com.chatgptapi.app.models;

public class Answer {
    private Integer index;
    private String text;
    private String logprobs;
    private String finish_reason;

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getLogprobs() {
        return logprobs;
    }

    public void setLogprobs(String logprobs) {
        this.logprobs = logprobs;
    }

    public String getFinish_reason() {
        return finish_reason;
    }

    public void setFinish_reason(String finish_reason) {
        this.finish_reason = finish_reason;
    }

    public Answer() {
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
    @Override
    public String toString() {
        return "AnswerDTO{" + "text='" + text + '\'' + '}';
    }
}
