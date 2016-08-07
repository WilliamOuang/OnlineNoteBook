package com.note.web;

import com.note.domain.NoteUser;
import com.note.service.NoteService;
import javax.annotation.Resource;
import javax.enterprise.inject.Model;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
    @Resource
     NoteService noteService;
        
        @RequestMapping(value =  "/success*")
	public ModelAndView successPage() {

		ModelAndView model = new ModelAndView();
		
		model.setViewName("success");
		return model;

	}
	@RequestMapping(value =  "/", method = RequestMethod.GET)
	public ModelAndView defaultPage() {

		ModelAndView model = new ModelAndView();
		
		model.setViewName("login");
		return model;

	}
        @RequestMapping(value = "/welcome**" )
	public ModelAndView welcomePage() {

		ModelAndView model = new ModelAndView();
		//model.addObject("title", "Spring Security Login Form - Database Authentication");
		//model.addObject("message", "This is default page!");
               
                 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
		NoteUser user=noteService.getUser(userDetail.getUsername());
			model.addObject("noteClasss", noteService.getNoteClassByUserID(user.getId()));
			
		}
		model.setViewName("main");
		return model;

	}
        
        
        @RequestMapping(value = "/head**")
	public String head() {
            return "head";
        }
        @RequestMapping(value = "/allNote")
	public String allNote(org.springframework.ui.Model model) {
              Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
		NoteUser user=noteService.getUser(userDetail.getUsername());
			model.addAttribute("allNotes", noteService.getNoteByUserID(user.getId()));
			
		}
            return "allNote";
        }
           @RequestMapping(value = "/allNoteByNoteClassId/{classNoteId}")
	public String allNoteByNoteClassId(@PathVariable int classNoteId,org.springframework.ui.Model model) {
              Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
		NoteUser user=noteService.getUser(userDetail.getUsername());
			model.addAttribute("allNotes", noteService.getNoteByNoteClassIDAndUserID(user.getId(), classNoteId));
			
		}
            return "allNote";
        }
        
        @RequestMapping(value = "/menu**")
	public String menu(org.springframework.ui.Model model) {
              Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
		NoteUser user=noteService.getUser(userDetail.getUsername());
			model.addAttribute("noteClasss", noteService.getNoteClassByUserID(user.getId()));
			
		}
            return "menu";
        }
	@RequestMapping(value = "/admin**", method = RequestMethod.GET)
	public ModelAndView adminPage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Login Form - Database Authentication");
		model.addObject("message", "This page is for ROLE_ADMIN only!");
               // model.addObject("message1", "This page is for ROLE_ADMIN only!");
                Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			System.out.println(userDetail);
		
			model.addObject("message1", userDetail.getUsername());
			
		}
                
		model.setViewName("admin");

		return model;

	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {

		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid username and password!");
		}

		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}
		model.setViewName("login");

		return model;

	}
	
	//for 403 access denied page
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public ModelAndView accesssDenied() {

		ModelAndView model = new ModelAndView();
		
		//check if user is login
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			System.out.println(userDetail);
		
			model.addObject("username", userDetail.getUsername());
			
		}
		
		model.setViewName("403");
		return model;

	}

}