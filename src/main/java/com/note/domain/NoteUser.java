/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.note.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author 984859
 */
@Entity(name="users")
public class NoteUser {
    
    @Id
    @GeneratedValue
    private int id;
    private String username;
    private String password;
    private String userType;
    private String email;
    private String phone;
    private int enabled;

    public NoteUser(String username, String password, String userType, String email, String phone, int enabled) {
        this.username = username;
        this.password = password;
        this.userType = userType;
        this.email = email;
        this.phone = phone;
        this.enabled = enabled;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }
    
    //mappedBy="user1",
    @OneToMany(cascade=CascadeType.ALL)
    List<NoteClass> listNoteClass= new ArrayList<NoteClass>(); 
 
    public List<NoteClass> getNoteClasslist() {
		return listNoteClass;
    }

    public void addNoteClass(NoteClass noteClass) {
		listNoteClass.add(noteClass);
    }
    
    public List<Note> getNotelist() {
		return listNote;
    }
    public void addNote(Note note) {
		listNote.add(note);
    }
    //mappedBy="user",
    @OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
    List<Note> listNote= new ArrayList<Note>(); 
    
    
    public void setListNoteClass(List<NoteClass> listNoteClass) {
        this.listNoteClass = listNoteClass;
    }

    public void setListNote(List<Note> listNote) {
        this.listNote = listNote;
    }

    public List<NoteClass> getListNoteClass() {
        return listNoteClass;
    }

    public List<Note> getListNote() {
        return listNote;
    }
    public NoteUser() {
    }

 

    
}
