package com.example.graduationproject.Test.API_Test;

public class Ahadiths_Questions_details {
    private int id;
    private int hadith_id;
    private int level_id ;
    private String question;
    private String choiceA;
    private String choiceB;
    private String choiceC;
    private String correct;
    private String created_at;
    private String updated_at;

    public Ahadiths_Questions_details(String question, String choiceA, String choiceB, String choiceC, String correct) {
        this.question = question;
        this.choiceA = choiceA;
        this.choiceB = choiceB;
        this.choiceC = choiceC;
        this.correct = correct;
    }

    public int getLevel_id() {
        return level_id;
    }
    public void setLevel_id(int level_id) {
        this.level_id = level_id;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHadith_id() {
        return hadith_id;
    }

    public void setHadith_id(int hadith_id) {
        this.hadith_id = hadith_id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getChoiceA() {
        return choiceA;
    }

    public void setChoiceA(String choiceA) {
        choiceA = choiceA;
    }

    public String getChoiceB() {
        return choiceB;
    }

    public void setChoiceB(String choiceB) {
        choiceB = choiceB;
    }

    public String getChoiceC() {
        return choiceC;
    }

    public void setChoiceC(String choiceC) {
        choiceC = choiceC;
    }
    public String getCorrect() {
        return correct;
    }

    public void setCorrect(String correct) {
        this.correct = correct;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }



}
