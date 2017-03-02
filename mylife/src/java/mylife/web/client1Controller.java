package mylife.web;

import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import mylife.objects.client1;
import mylife.objects.Message;
import mylife.respository.client1DAO;
import mylife.validator.client1Validator;
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
public class client1Controller {

    @Autowired
    client1DAO dao;

    @Autowired
    private client1Validator client1Validator;

    private static final Logger logger = Logger.getLogger(client1Controller.class.getName());

    @RequestMapping("/client1/client1form")
    public ModelAndView showform() {
        return new ModelAndView("client1form", "client1", new client1());
    }

    @RequestMapping(value = "/client1/save", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("client1") @Valid client1 client1, BindingResult result, HttpServletRequest request) {
        if (result.hasErrors()) {
            
            logger.info(result.getFieldError().toString());
            return new ModelAndView("client1form", "client1", client1);
        }

        int r = dao.save(client1);

        Message msg = null;
        if (r == 1) {
            msg = new Message(Message.Level.INFO, "Client1 has been successfully created");
        } else {
            msg = new Message(Message.Level.ERROR, "New client1 creation failed");
        }

        request.getSession().setAttribute("message", msg);

        return new ModelAndView("redirect:/client1/viewclient1");
    }

    @RequestMapping("/client1/viewclient1")
    public ModelAndView viewclient1(HttpServletRequest request) {
        return this.viewclient1(1, request);
    }

    @RequestMapping("/client1/viewclient1/{pageid}")
    public ModelAndView viewclient1(@PathVariable int pageid, HttpServletRequest request) {
        int total = 10;
        int start = 1;

        if (pageid != 1) {
            start = (pageid - 1) * total + 1;
        }

        List<client1> list = dao.getclient1ByPage(start, total);

        HashMap<String, Object> context = new HashMap<>();
        context.put("list", list);

        int count = dao.getclient1Count();
        context.put("pages", Math.ceil((float) count / (float) total));

        context.put("page", pageid);

        Message msg = (Message) request.getSession().getAttribute("message");

        if (msg != null) {
            context.put("message", msg);
            request.getSession().removeAttribute("message");
        }

        return new ModelAndView("viewclient1", context);
    }

    /**
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/client1/editclient1/{id}")
    public ModelAndView edit(@PathVariable int id) {
        client1 client1 = dao.getclient1ById(id);
        
        return new ModelAndView("client1editform", "client1", client1);
    }

    @RequestMapping(value = "/client1/editsave", method = RequestMethod.POST)
    public ModelAndView editsave(@ModelAttribute("client1") @Valid client1 client1, BindingResult result, HttpServletRequest request) {
        if (result.hasErrors()) {
             logger.info(result.getFieldError().toString());
            return new ModelAndView("client1editform", "client1", client1);
        }

        int r = dao.update(client1);

        Message msg = null;
        if (r == 1) {
            msg = new Message(Message.Level.INFO, "client1 has been successfully saved");
        } else {
            msg = new Message(Message.Level.ERROR, "Edit client failed");
        }

        request.getSession().setAttribute("message", msg);

        return new ModelAndView("redirect:/client1/viewclient1");
    }

    @RequestMapping(value = "/client1/deleteclient1/{id}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable int id, HttpServletRequest request) {
        int r = dao.delete(id);

        Message msg = null;
        if (r == 1) {
            msg = new Message(Message.Level.INFO, "client1 has been successfully deleted") {
            };
        } else {
            msg = new Message(Message.Level.ERROR, "Delete client1 failed");
        }

        request.getSession().setAttribute("message", msg);

        return new ModelAndView("redirect:/client1/viewclient1");
    }

    @InitBinder("client1")
    public void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.setValidator(client1Validator);
    }

    public client1Validator getclient1Validator() {
        return client1Validator;
    }

    public void setclient1Validator(client1Validator client1Validator) {
        this.client1Validator = client1Validator;
    }
}
