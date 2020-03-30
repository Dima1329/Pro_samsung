package com.example.pro_samsung;

public class Question {
    private String question;
    private String variant1;
    private String variant2;
    private String variant3;
    private String answer;

    public String getQuestion() {
        return question;
    }

    public String getVariant1() {
        return variant1;
    }

    public String getVariant2() {
        return variant2;
    }

    public String getVariant3() {
        return variant3;
    }

    public String  getAnswer() {
        return answer;
    }

    public Question(String question, String variant1, String variant2, String variant3, String answer) {
        this.question = question;
        this.variant1 = variant1;
        this.variant2 = variant2;
        this.variant3 = variant3;
        this.answer = answer;
    }
}
