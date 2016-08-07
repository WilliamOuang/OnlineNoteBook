/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.note.service;

import com.note.dao.INoteClassDao;
import com.note.dao.INoteDao;
import com.note.dao.INoteUserDao;
import com.note.dao.IReminderDao;
import com.note.domain.Note;
import com.note.domain.NoteClass;
import com.note.domain.NoteUser;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author 984859
 */
@Transactional
public class NoteService {
    
    INoteClassDao iNoteClassDao;
    INoteDao iNoteDao;
    INoteUserDao iNoteUserDao;
    IReminderDao iReminderDao;
    
    /*
        Create a new user;
    */
  
    public NoteUser createUser(String username, String password, String userType, String email, String phone, int enabled) {
        NoteUser user= new NoteUser(username,password,userType,email,phone,enabled);
        iNoteUserDao.add(user);
        
//        NoteClass noteClass=new NoteClass("eee","eee");
//        user.addNoteClass(noteClass);
//        iNoteUserDao.add(user);
//         iNoteClassDao.add(noteClass);
//      NoteUser user11=  getUser(7);
//        NoteClass noteClass1=new NoteClass("eee1","eee1");
//        user11.addNoteClass(noteClass1);
//        iNoteUserDao.update(user11.getId(), user11);
//        iNoteClassDao.add(noteClass1);
        return user;
    }
    public void deleteNoteClassByID(int noteClassid){
        iNoteClassDao.delete(noteClassid);
    }
    public List<Note> getNoteByNoteClassIDAndUserID(int userid,int noteClassid){
        return iNoteClassDao.getNoteByNoteClassIDAndUserID(userid, noteClassid);
    }
    public List<Note>  getNoteByUserID(int id){
       return iNoteUserDao.getNoteByUserID(id);
    }
   public List<NoteClass>  getNoteClassByUserID(int id){
       return iNoteUserDao.getNoteClassByUserID(id);
    }
    public NoteUser getUser(String username){
        return iNoteUserDao.getByName(username);
    }
    public NoteUser getUser(int id){
        return iNoteUserDao.get(id);
    }
    public NoteUser getUserByID(int id){
        return iNoteUserDao.getUserByID(id);
    }
    
    public NoteUser getUserAndClassNote(int id){
        return iNoteUserDao.get(id);
    }
    public void updateUser(NoteUser user){
         iNoteUserDao.update(user.getId(), user);
    }
    
    public void updateNoteClass(NoteClass noteClass){
         iNoteClassDao.update(noteClass.getId(), noteClass);
    }
    public NoteClass getNoteClass(int id){
        return iNoteClassDao.get(id);
    }
    
    public void updateNote(Note note){
         iNoteDao.update(note.getId(), note);
    }
    public Note getNote(int id){
        return iNoteDao.get(id);
    }
    
    
   public NoteClass createNoteClass(int userId,String className, String noteType){
        NoteUser user=getUser(userId);
        NoteClass noteClass=new NoteClass(className,noteType);
        user.addNoteClass(noteClass);
        iNoteClassDao.add(noteClass);
   
       return noteClass;
   }
   
      public Note createNote(int userId,int classNoteId,String title, String content, String reminderTime){
        NoteUser user=getUser(userId);
        NoteClass noteClass=  getNoteClass(classNoteId);
        Note note= new Note(title,content,reminderTime);
        // user mapping note
        user.addNote(note);
        // noteClass mapping note
        noteClass.addNote(note);
      
        iNoteDao.add(note);
       // iNoteUserDao.update(userId, user);
       // iNoteClassDao.update(userId, noteClass);
        
       return note;
   }
    
    public NoteService() {
    }

    public void setiNoteClassDao(INoteClassDao iNoteClassDao) {
        this.iNoteClassDao = iNoteClassDao;
    }

    public void setiNoteDao(INoteDao iNoteDao) {
        this.iNoteDao = iNoteDao;
    }

    public void setiNoteUserDao(INoteUserDao iNoteUserDao) {
        this.iNoteUserDao = iNoteUserDao;
    }

    public void setiReminderDao(IReminderDao iReminderDao) {
        this.iReminderDao = iReminderDao;
    }
    
    
}
