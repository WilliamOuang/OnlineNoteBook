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
public class NoteClassDao implements INoteClassDao{
    
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
	this.sessionFactory = sessionFactory;
    }

    @Override
    public List<NoteClass> getAll() {
       return sessionFactory.getCurrentSession().createQuery("from NoteClass ").list();
    }

    @Override
    public int add(NoteClass noteclass) {
         return   (int) sessionFactory.getCurrentSession().save(noteclass);
        }

    @Override
    public NoteClass get(int id) {
        return (NoteClass) sessionFactory.getCurrentSession().get(NoteClass.class, id);
    }

    @Override
    public void update(int id, NoteClass noteclass) {
        sessionFactory.getCurrentSession().update(noteclass);
    }

    @Override
    public void delete(int id) {
    sessionFactory.getCurrentSession().delete(get(id));
    }

    @Override
    public List<Note> getNoteByNoteClassIDAndUserID(int userId, int noteclassId) {
        return sessionFactory.getCurrentSession().createQuery(""
            + "select distinct note from users users1 join users1.listNoteClass noteClass join noteClass.listNote note "
            + "where users1.id=:userId and noteClass.id=:noteclassId"
            + "").setParameter("userId", userId).setParameter("noteclassId", noteclassId).list();
    }
}
