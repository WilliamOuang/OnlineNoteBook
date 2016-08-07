/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.note.dao;

import com.note.domain.Note;
import com.note.domain.NoteClass;
import com.note.domain.NoteUser;
import java.util.List;
import org.hibernate.SessionFactory;

/**
 *
 * @author 984859
 */
public class NoteUserDao implements INoteUserDao{
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
	this.sessionFactory = sessionFactory;
    }
       @Override
   public List<NoteClass>  getNoteClassByUserID(int id){
        
      return sessionFactory.getCurrentSession().createQuery("select distinct noteClass from users users1 join users1.listNoteClass noteClass where users1.id=:id").setParameter("id", id).list();
  
   }
      @Override
    public NoteUser getUserByID(int userid){
        
      return  (NoteUser) sessionFactory.getCurrentSession().createQuery("select distinct users1 from users users1  where users1.id=:id").setParameter("id", userid).list().get(0);
  
    }
       @Override
     public List<Note> getNoteByUserID(int id){
        
      return sessionFactory.getCurrentSession().createQuery("select distinct note from users users1 join users1.listNote note  where users1.id=:id").setParameter("id", id).list();
   }
    @Override
    public List<NoteUser> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int add(NoteUser user) {
         return   (int) sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public NoteUser get(int id) {
        return (NoteUser) sessionFactory.getCurrentSession().get(NoteUser.class,id);
    }

    @Override
    public void update(int id, NoteUser user) {
        sessionFactory.getCurrentSession().update(user);
    }

    @Override
    public void delete(int id) {
    }

    @Override
    public NoteUser getByName(String username) {
              return (NoteUser) sessionFactory.getCurrentSession().createQuery("select distinct users1 from users users1  where users1.username=:id").setParameter("id", username).list().get(0);

    }
    
}
