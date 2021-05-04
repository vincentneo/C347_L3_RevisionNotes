package com.myapplicationdev.android.p04_revisionnotes;

public class Note {
    
    private int id, stars;
    private String noteContent;

    public Note(int id, String noteContent, int stars) {
        this.id = id;
        this.stars = stars;
        this.noteContent = noteContent;
    }

    public int getId() {
        return id;
    }

    public String getNoteContent() {
        return noteContent;
    }

    public int getStars() {
        return stars;
    }

}
