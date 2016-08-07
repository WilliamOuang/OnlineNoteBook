/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.note.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author 984859
 */
@Entity
public class Note {
    @Id
    @GeneratedValue
    private int id;
    private String title;
    private String content;
    private String reminderTime;
    
//    @ManyToOne(cascade=CascadeType.ALL)
//    NoteUser user = new NoteUser();
//    
//    @ManyToOne(cascade=CascadeType.ALL)
//    NoteClass noteClass = new NoteClass();

//    public NoteClass getNoteClass() {
//        return noteClass;
//    }

//    public void setNoteClass(NoteClass noteClass) {
//        this.noteClass = noteClass;
//    }
    
    @OneToMany(cascade=CascadeType.ALL)
    List<Reminder> reminder= new ArrayList<Reminder>();
//    public NoteUser getUser() {
//        return user;
//    }
//
//    public List<Reminder> getReminder() {
//        return reminder;
//    }

    public void setReminder(List<Reminder> reminder) {
        this.reminder = reminder;
    }

//    public void setUser(NoteUser user) {
//        this.user = user;
//    }
//
//    public NoteClass getNoteClass() {
//        return noteClass;
//    }

//    public void setNoteClass(NoteClass noteClass) {
//        this.noteClass = noteClass;
//    }
    

            
    public Note() {
    }

    public Note(String title, String content, String reminderTime) {
        this.title = title;
        this.content = content;
        this.reminderTime = reminderTime;
    }

    public Note(int id, String title, String content, String reminderTime) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.reminderTime = reminderTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getReminderTime() {
        return reminderTime;
    }

    public void setReminderTime(String reminderTime) {
        this.reminderTime = reminderTime;
    }
    
    
}
