/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mylife.web;
import mylife.objects.user;
import mylife.objects.Message;
import mylife.validator.userValidator;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import mylife.respository.userDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
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
    
    @Autowired
    private userValidator userValidator;
    
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
 
        return new ModelAndView("redirect:/");
    }
    
    @InitBinder("user")
    public void initBinder(WebDataBinder webDataBinder){
        webDataBinder.setValidator(userValidator);
    }
    
    public userValidator getUserValidator() {
        return userValidator;
    }
 
    public void setuserValidator(userValidator userValidator) {
        this.userValidator = userValidator;
    }
}

