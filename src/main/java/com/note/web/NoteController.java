/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.note.web;

import com.note.domain.Note;
import com.note.domain.NoteClass;
import com.note.domain.NoteUser;
import com.note.service.NoteService;
import javax.annotation.Resource;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author 984859
 */
@Controller
public class NoteController {
    
        @Resource
     NoteService noteService;
      
        @RequestMapping(value="/note/{classNoteId}", method=RequestMethod.GET)
	public String enter( Model model,@PathVariable int classNoteId) {
                model.addAttribute("noteClassid",classNoteId);
		return "addNote";
	}
        
        @RequestMapping(value="/viewNote/{noteId}", method=RequestMethod.GET)
	public String viewNote( Model model,@PathVariable int noteId) {
                model.addAttribute("noteview",  noteService.getNote(noteId));

		return "viewNote";
	}
        
        @RequestMapping(value="/noteUpdate/{noteId}", method=RequestMethod.GET)
	public String enterUpdate(@PathVariable int noteId,Model model) {
                model.addAttribute("noteview",  noteService.getNote(noteId));
                 //model.addAttribute("noteClassId",  noteClassId);

		return "updateNote";
	}
        
        @RequestMapping(value="/noteUpdate2/{noteId}")
	public String updateClassNote(Note note,@PathVariable int noteId,Model model) {
             
            note.setId(noteId);
            noteService.updateNote(note);
            return "redirect:/success";
	}
        
        @RequestMapping(value="/noteDelete/{classId}")
	public String deleteClassNote(@PathVariable int classNoteId,Model model) {
           
		return "redirect:/success";
	}
        
        @RequestMapping(value="/addnote/{classNoteId}", method=RequestMethod.POST)
	public String add(Note note,@PathVariable int classNoteId) {
      
             Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
                        NoteUser user=noteService.getUser(userDetail.getUsername());
                        noteService.createNote(user.getId(), classNoteId, note.getTitle(), note.getContent(), note.getReminderTime());

		}
                
		return "redirect:/success";
	}
    
}
