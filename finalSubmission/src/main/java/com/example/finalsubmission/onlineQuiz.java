package com.example.finalsubmission;

import java.io.Serializable;

public class onlineQuiz implements Serializable {
    private String name;
    private String id;
    private String subject;
    private  String marks;

    public onlineQuiz(String name, String id, String subject, String marks) {
        this.name = name;
        this.id = id;
        this.subject = subject;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMarks() {
        return marks;
    }

    public void setMarks(String marks) {
        this.marks = marks;
    }
}
