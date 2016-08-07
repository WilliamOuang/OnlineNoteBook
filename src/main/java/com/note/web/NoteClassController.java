/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.note.web;

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
 * @author WeiliangOuyang
 */
@Controller
public class NoteClassController {
        @Resource
        NoteService noteService;

 
        
        @RequestMapping(value="/noteClass", method=RequestMethod.GET)
	public String enter( Model model) {
		//model.addAttribute("userId",userId); @PathVariable int userId, {userId}
		return "addClassNote";
	}
        
        @RequestMapping(value="/noteClassUpdate/{classNoteId}", method=RequestMethod.GET)
	public String enterUpdate(@PathVariable int classNoteId,Model model) {
		model.addAttribute("noteClass",noteService.getNoteClass(classNoteId));
		return "updateClassNote";
	}
        
        @RequestMapping(value="/noteClassUpdate2/{classNoteId}")
	public String updateClassNote(NoteClass noteClass,@PathVariable int classNoteId,Model model) {
             
            noteClass.setId(classNoteId);
                noteService.updateNoteClass(noteClass);
		return "redirect:/success";
	}
         @RequestMapping(value="/noteClassDelete/{classNoteId}")
	public String deleteClassNote(@PathVariable int classNoteId,Model model) {
           
                noteService.deleteNoteClassByID(classNoteId);
		return "redirect:/success";
	}
        
        @RequestMapping(value="/noteClass2", method=RequestMethod.POST)
	public String add(NoteClass noteClass) {
      
             Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
		NoteUser user=noteService.getUser(userDetail.getUsername());
				noteService.createNoteClass(user.getId(), noteClass.getClassName(),noteClass.getNoteType());
	
		}
                
		return "redirect:/success";
	}
}
