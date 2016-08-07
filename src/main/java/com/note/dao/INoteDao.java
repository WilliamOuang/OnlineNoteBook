/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.note.dao;

import com.note.domain.Note;
import java.util.List;

/**
 *
 * @author 984859
 */
public interface INoteDao {
    
        public abstract List<Note> getAll();

	public abstract int add(Note note);

	public abstract Note get(int id);

	public abstract void update(int id, Note note);

	public abstract void delete(int id);
        
}
