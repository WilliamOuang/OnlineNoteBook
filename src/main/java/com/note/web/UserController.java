/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.note.web;

import com.note.service.NoteService;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;

/**
 *
 * @author WeiliangOuyang
 */
@Controller
public class UserController {
     @Resource
     NoteService noteService;
}
