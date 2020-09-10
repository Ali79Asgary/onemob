package com.example.myapplication;

public class Exam {
    private String examLink;
    private String examName;

    public Exam(String examLink, String examName) {
        this.examLink = examLink;
        this.examName = examName;
    }

    public String getExamLink() { return examLink; }

    public void setExamLink(String examLink) { this.examLink = examLink; }

    public String getExamName() { return examName; }

    public void setExamName(String examName) { this.examName = examName; }
}
