/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.note.test;

import com.note.domain.Note;
import com.note.domain.NoteClass;
import com.note.domain.NoteUser;
import com.note.service.NoteService;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author 984859
 */
public class AppTest {
      public static void main(String[] args) {
          
        ApplicationContext context = new ClassPathXmlApplicationContext(
                    "springconfig.xml");
       
NoteService accountService = context.getBean("noteService",NoteService.class);
//NoteUser user =accountService.createUser("username", "password", "userType", "email", "phone",1);
//
NoteUser user=accountService.getUserByID(1);
//List<Note>  note11=accountService.getNoteByUserID(user.getId());
//note11.get(0).getNoteClass().getId();
//System.out.println(user.getId());
//List<NoteClass>  noteClass11=accountService.getNoteClassByUserID(user.getId());
//accountService.getNoteClassByUserID(user.getId()).remove(accountService.getNoteClass(8));

//accountService.deleteNoteClassByID(noteClass.getId());
//user.getListNoteClass().remove(noteClass);
//accountService.updateUser(user);
//user.getListNoteClass().remove(noteClass);
        
//
//accountService.deleteNoteClassByID(noteClass.getId());

//NoteClass noteClass =accountService.createNoteClass(user.getId(), "className2", "noteType2");
//NoteClass noteClass=accountService.getNoteClass(2);
//Note note=accountService.createNote(user.getId(), noteClass.getId(), "title11111111111111111111", "content222222222222222", "reminderTime");
//NoteUser user=accountService.getUser(3);
//NoteClass noteClass =accountService.createNoteClass(user.getId(), "className11111111", "noteType1111111111");

//List<NoteClass>  noteClass11=accountService.getNoteClassByUserID(user.getId());
//System.out.println("---------------"+noteClass11.size());
//List<Note>  note11=accountService.getNoteByUserID(user.getId());
//
//System.out.println("----------d-----"+note11.size());
//
//List<Note>  note22=accountService.getNoteByNoteClassIDAndUserID(user.getId(), noteClass.getId());
//System.out.println("----------d-----"+note22.size());
//update NoteClass

//NoteClass noteClass1=accountService.getNoteClass(1);
//noteClass1.setClassName("William");
//accountService.updateNoteClass(noteClass1);

//Note note1=accountService.getNote(1);
//note1.setTitle("Change Title");
//accountService.updateNote(note1);


      }
}
