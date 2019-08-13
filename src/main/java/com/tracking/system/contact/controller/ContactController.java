package com.tracking.system.contact.controller;


import com.tracking.response.Response;
import com.tracking.system.contact.service.UserContactServiceImpl;
import com.tracking.system.contact.service.model.UserContact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class ContactController {

    @Autowired
    UserContactServiceImpl contactService;


    @PostMapping("/contact/save")
    @ResponseBody
    public Response saveContact(UserContact contact) {
        UserContact newContact = contactService.save(contact);
        if(newContact != null)
            return new Response("success","UserContact sent successfully!");
        return new Response("fail","UserContact sent failed!");
    }


}
