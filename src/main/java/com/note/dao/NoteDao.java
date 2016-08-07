/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.note.dao;

import com.note.domain.Note;
import com.note.domain.NoteClass;
import java.util.List;
import org.hibernate.SessionFactory;

/**
 *
 * @author 984859
 */
public class NoteDao implements INoteDao{
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
	this.sessionFactory = sessionFactory;
    }
    @Override
    public List<Note> getAll() {
       return sessionFactory.getCurrentSession().createQuery("from Note").list();
    }

    @Override
    public int add(Note note) {
         return   (int) sessionFactory.getCurrentSession().save(note);
    }

    @Override
    public Note get(int id) {
        return (Note) sessionFactory.getCurrentSession().get(Note.class, id);
    }

    @Override
    public void update(int id, Note note) {
         sessionFactory.getCurrentSession().update(note);
    }

    @Override
    public void delete(int id) {
        
    }
    
}
