package com.example.a3_recyclerviewcustomadapterwithheaderandfooterjava.model;

public class Member {
    private String name;
    private String about;
    private boolean avtivity  = false;

    public Member(String newName, String newAbout, boolean newActivity){
        this.name = newName;
        this.about = newAbout;
        this.avtivity = newActivity;
    }

    public Member() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public boolean isAvtivity() {
        return avtivity;
    }

    public void setAvtivity(boolean avtivity) {
        this.avtivity = avtivity;
    }
}
