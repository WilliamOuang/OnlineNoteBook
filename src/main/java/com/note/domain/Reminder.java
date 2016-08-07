/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.note.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author 984859
 */
@Entity
public class Reminder {
    @Id
    @GeneratedValue
    private int id;
    private String reminderType;
    private String reminderContent;
    private String reminderTime;

    public Reminder(int id, String reminderType, String reminderContent, String reminderTime) {
        this.id = id;
        this.reminderType = reminderType;
        this.reminderContent = reminderContent;
        this.reminderTime = reminderTime;
    }

    public Reminder(String reminderType, String reminderContent, String reminderTime) {
        this.reminderType = reminderType;
        this.reminderContent = reminderContent;
        this.reminderTime = reminderTime;
    }

    public Reminder() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReminderType() {
        return reminderType;
    }

    public void setReminderType(String reminderType) {
        this.reminderType = reminderType;
    }

    public String getReminderContent() {
        return reminderContent;
    }

    public void setReminderContent(String reminderContent) {
        this.reminderContent = reminderContent;
    }

    public String getReminderTime() {
        return reminderTime;
    }

    public void setReminderTime(String reminderTime) {
        this.reminderTime = reminderTime;
    }


}
