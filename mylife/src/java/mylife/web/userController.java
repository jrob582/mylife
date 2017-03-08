/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mylife.web;
import java.util.HashMap;
import java.util.List;
import mylife.objects.user;
import mylife.objects.Message;
import mylife.validator.userValidator;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import mylife.objects.client1;
import mylife.respository.userDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author johna
 */
    
@Controller
public class userController{
    @Autowired
    userDAO dao;
    
    //@Autowired
    //private userValidator userValidator;
    
    private static final Logger logger = Logger.getLogger(userController.class.getName());

    @RequestMapping("/user/userform")
    public ModelAndView showform(){
        user user = new user();

        return new ModelAndView("userform","user",user);
    }
    
    @RequestMapping(value = "/user/save", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("user") @Valid user user, BindingResult result, HttpServletRequest request){
        if(result.hasErrors()){
            return new ModelAndView("userform", "user", user);
        }
        
        int r = dao.save(user);
        
        Message msg = null;
        if (r == 1) {
            msg = new Message(Message.Level.INFO, "user has been successfully created");
        }
        else {
            msg = new Message(Message.Level.ERROR, "New user creation failed");
        }
        
        request.getSession().setAttribute("message", msg);
 
        return new ModelAndView("redirect:/user/viewuser");
    }
    
        @RequestMapping("/user/viewuser")
    public ModelAndView viewuser(HttpServletRequest request) {
        return this.viewuser(1, request);
    }
    
        @RequestMapping("/user/viewuser/{pageid}")
    public ModelAndView viewuser(@PathVariable int pageid, HttpServletRequest request) {
        int total = 10;
        int start = 1;

        if (pageid != 1) {
            start = (pageid - 1) * total + 1;
        }

        List<user> list = dao.getuserByPage(start, total);

        HashMap<String, Object> context = new HashMap<>();
        context.put("list", list);

        int count = dao.getuserCount();
        context.put("pages", Math.ceil((float) count / (float) total));

        context.put("page", pageid);

        Message msg = (Message) request.getSession().getAttribute("message");

        if (msg != null) {
            context.put("message", msg);
            request.getSession().removeAttribute("message");
        }

        return new ModelAndView("viewuser", context);
    }
    
        @RequestMapping(value = "/user/edituser/{username}")
    public ModelAndView edit(@PathVariable String username) {
        user user = dao.getUsersbyUsername(username);
        
        return new ModelAndView("usereditform", "user", user);
    }

    @RequestMapping(value = "/user/editsave", method = RequestMethod.POST)
    public ModelAndView editsave(@ModelAttribute("user") @Valid user user, BindingResult result, HttpServletRequest request) {
        if (result.hasErrors()) {
             logger.info(result.getFieldError().toString());
            return new ModelAndView("usereditform", "user", user);
        }

        int r = dao.update(user);

        Message msg = null;
        if (r == 1) {
            msg = new Message(Message.Level.INFO, "user has been successfully saved");
        } else {
            msg = new Message(Message.Level.ERROR, "Edit user failed");
        }

        request.getSession().setAttribute("message", msg);

        return new ModelAndView("redirect:/user/viewuser");
    }
    
        @RequestMapping(value = "/user/deleteuser/{username}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable String username, HttpServletRequest request) {
        int r = dao.delete(username);

        Message msg = null;
        if (r == 1) {
            msg = new Message(Message.Level.INFO, "User has been successfully deleted") {
            };
        } else {
            msg = new Message(Message.Level.ERROR, "Delete user failed");
        }

        request.getSession().setAttribute("message", msg);

        return new ModelAndView("redirect:/user/viewuser");
    }
    

    
    
    
    /*
    @InitBinder("user")
    public void initBinder(WebDataBinder webDataBinder){
        webDataBinder.setValidator(userValidator);
    }
    
    public userValidator getUserValidator() {
        return userValidator;
    }
 
    public void setuserValidator(userValidator userValidator) {
        this.userValidator = userValidator;
    }*/
}

