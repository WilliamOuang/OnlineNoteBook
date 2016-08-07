/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.note.dao;

import com.note.domain.NoteClass;
import com.note.domain.Reminder;
import java.util.List;
import org.hibernate.SessionFactory;

/**
 *
 * @author 984859
 */
public class ReminderDao implements IReminderDao{
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
	this.sessionFactory = sessionFactory;
    }
    @Override
    public List<Reminder> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int add(Reminder reminder) {
         return   (int) sessionFactory.getCurrentSession().save(reminder);
    }

    @Override
    public Reminder get(int id) {
        return (Reminder) sessionFactory.getCurrentSession().get(Reminder.class, id);
    }

    @Override
    public void update(int id, Reminder reminder) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
