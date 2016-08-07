/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.note.dao;

import com.note.domain.Reminder;
import java.util.List;

/**
 *
 * @author 984859
 */
public interface IReminderDao {
        
        public abstract List<Reminder> getAll();

	public abstract int add(Reminder reminder);

	public abstract Reminder get(int id);

	public abstract void update(int id, Reminder reminder);

	public abstract void delete(int id);
}
