package com.example.pro_samsung;

class Question {
    private String question;
    private String variant1;
    private String variant2;
    private String variant3;
    private String variant4;

    private int answer;

    String getQuestion() {
        return question;
    }

    String getVariant1() {
        return variant1;
    }

    String getVariant2() {
        return variant2;
    }

    String getVariant3() {
        return variant3;
    }

    public String getVariant4() {
        return variant4;
    }

    int getAnswer() {
        return answer;
    }



    Question(String question, String variant1, String variant2, String variant3, String variant4, int answer) {
        this.question = question;
        this.variant1 = variant1;
        this.variant2 = variant2;
        this.variant3 = variant3;
        this.variant4=variant4;
        this.answer = answer;
    }
}
