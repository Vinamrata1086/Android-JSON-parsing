package com.example.pw;

public class Profile {

    private String name , image , qualification, subject;

    public Profile(String name , String image , String qualification , String subject){
        this.name = name;
        this.image = image;
        this.qualification = qualification;
        this.subject = subject;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public String getQualification() {
        return qualification;
    }

    public String getSubject() {
        return subject;
    }
}
