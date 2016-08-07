/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.note.dao;

import com.note.domain.Note;
import com.note.domain.NoteClass;
import java.util.List;

/**
 *
 * @author 984859
 */
public interface INoteClassDao {
        
        public abstract List<NoteClass> getAll();

	public abstract int add(NoteClass noteclass);

	public abstract NoteClass get(int id);

	public abstract void update(int id, NoteClass noteclass);

	public abstract void delete(int id);
        
        public abstract List<Note> getNoteByNoteClassIDAndUserID(int userId,int noteclassId);
}
