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

/**
 *
 * @author 984859
 */
public interface INoteUserDao {
    
        public abstract List<NoteUser> getAll();

	public abstract int add(NoteUser user);

	public abstract NoteUser get(int id);
        public abstract NoteUser getByName(String username);

	public abstract void update(int id, NoteUser user);

	public abstract void delete(int id);
        
        public abstract List<NoteClass>  getNoteClassByUserID(int id);
        public abstract List<Note> getNoteByUserID(int id);
        public abstract NoteUser getUserByID(int userid);
}
