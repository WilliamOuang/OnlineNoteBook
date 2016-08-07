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
import javax.persistence.OneToMany;

/**
 *
 * @author 984859
 */
@Entity
public class NoteClass {
    @Id
    @GeneratedValue
    private int id;
    private String className;
    private String noteType;
   // mappedBy="noteClass",
    //mappedBy="noteClass",
    @OneToMany(cascade=CascadeType.ALL)
    List<Note> listNote= new ArrayList<Note>();
    
//    @ManyToOne(cascade=CascadeType.ALL)
//    NoteUser user1;
//
//    public NoteUser getUser1() {
//        return user1;
//    }
//
//    public void setUser1(NoteUser user1) {
//        this.user1 = user1;
//    }
     
    public List<Note> getNotelist() {
		return listNote;
    }
    public void addNote(Note note) {
		listNote.add(note);
    }
    public List<Note> getListNote() {
        return listNote;
    }

    public void setListNote(List<Note> listNote) {
        this.listNote = listNote;
    }
    
    public NoteClass(int id, String className, String noteType) {
        this.id = id;
        this.className = className;
        this.noteType = noteType;
    }

    public NoteClass(String className, String noteType) {
        this.className = className;
        this.noteType = noteType;
    }

    public NoteClass() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getNoteType() {
        return noteType;
    }

    public void setNoteType(String noteType) {
        this.noteType = noteType;
    }
    
}
