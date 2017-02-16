
package mylife.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author johna
 */
public class HomeController {
        @RequestMapping("/")
    public ModelAndView viewclient1(){
        return new ModelAndView("index");
    }
}
