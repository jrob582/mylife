/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mylife.web;

import java.util.List;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import mylife.respository.interactionsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import java.util.HashMap;
import java.util.Map;
import mylife.objects.Message;
import mylife.respository.client1DAO;
import mylife.objects.client1;
import mylife.objects.interactions;
//import mylife.validator.interactionsValidator;
//import org.springframework.validation.Validator;
//import org.springframework.web.bind.WebDataBinder;
//import org.springframework.web.bind.annotation.InitBinder;

/**
 *
 * @author johna
 */
@Controller
public class interactionsController {

    @Autowired
    interactionsDAO dao;

    @Autowired
    client1DAO adao = new client1DAO();

    private static final Logger logger = Logger.getLogger(interactionsController.class.getName());
//    private interactionsValidator interactionsValidator;

    @RequestMapping("/interactions/interactionsform")
    public ModelAndView showform() {
        interactions interactions = new interactions();
        interactions.setclient1(dao.getclient1Map());

        return new ModelAndView("interactionsform", "interactions", interactions);
    }

    @RequestMapping("/interactions/interactionsform/{id}")
    public ModelAndView showformWithclient1(@PathVariable int id) {
        
         client1 client1 = adao.getclient1ById(id);
        
        interactions interactions = new interactions();
        interactions.setClients_id(id);

       
        interactions.setclient1(dao.getclient1Map());

        return new ModelAndView("interactionsform", "interactions", interactions);
    }

    @RequestMapping(value = "/interactions/save", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("interactions") interactions interactions, HttpServletRequest request) {
        int r = dao.save(interactions);
   

        Message msg = null;
        if (r == 1) {
            msg = new Message(Message.Level.INFO, "Interactions has been successfully created");
        } else {
            msg = new Message(Message.Level.ERROR, "New interactions creation failed");
        }

        request.getSession().setAttribute("message", msg);

        return new ModelAndView("redirect:/interactions/viewinteractions");
    }

        @RequestMapping("/interactions/viewinteractions")
    public ModelAndView viewinteractions(HttpServletRequest request) {
        return this.viewinteractions(1, request);
    }
    
    
    @RequestMapping("/interactions/viewinteractions/{pageid}")
    public ModelAndView viewinteractions(@PathVariable int pageid, HttpServletRequest request) {
        int total = 25;
        int start = 1;

        if (pageid != 1) {
            start = (pageid - 1) * total + 1;
        }

        List<interactions> list = dao.getinteractionsByPage(start, total);

        HashMap<String, Object> context = new HashMap<String, Object>();
        context.put("list", list);

        int count = dao.getinteractionsCount();
        context.put("pages", Math.ceil((float) count / (float) total));

        context.put("page", pageid);

        Message msg = (Message) request.getSession().getAttribute("message");

        if (msg != null) {
            context.put("message", msg);
            request.getSession().removeAttribute("message");
        }

        return new ModelAndView("viewinteractions", context);
    }

    @RequestMapping(value = "/interactions/editinteractions/{id}")
    public ModelAndView edit(@PathVariable int id) {
        interactions interactions = dao.getinteractionsById(id);

        interactions.setclient1(dao.getclient1Map());

        return new ModelAndView("interactionseditform", "interactions", interactions);
    }

    @RequestMapping(value = "//editsave", method = RequestMethod.POST)
    public ModelAndView editsave(@ModelAttribute("interaction") interactions interactions, HttpServletRequest request) {
        int r = dao.update(interactions);

        Message msg = null;
        if (r == 1) {
            msg = new Message(Message.Level.INFO, "Interactions has been successfully saved");
        } else {
            msg = new Message(Message.Level.ERROR, "Edit interactions failed");
        }

        request.getSession().setAttribute("message", msg);

        return new ModelAndView("redirect:/interactions/viewinteractions");
    }

    @RequestMapping(value = "/interactions/deleteinteractions/{id}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable int id, HttpServletRequest request) {
        int r = dao.delete(id);

        Message msg = null;
        if (r == 1) {
            msg = new Message(Message.Level.INFO, "Interactions has been successfully deleted");
        } else {
            msg = new Message(Message.Level.ERROR, "Delete interactions failed");
        }

        request.getSession().setAttribute("message", msg);

        return new ModelAndView("redirect:/interactions/view");
    }
//        @InitBinder("interactions")
//    public void initBinder(WebDataBinder webDataBinder, Validator interactionsValidator){
//        webDataBinder.setValidator(interactionsValidator);
//    }
//    
//    public interactionsValidator getinteractionsValidator(interactionsValidator interactionsValidator) {
//        return interactionsValidator;
//    }
// 
//    public void setinteractionsValidator(interactionsValidator interactionsValidator) {
//        this.interactionsValidator = interactionsValidator;
//    }
}
