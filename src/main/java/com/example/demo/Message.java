package com.example.demo;

public class Message {

    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setText() {
        setText("no input!");
    }
}