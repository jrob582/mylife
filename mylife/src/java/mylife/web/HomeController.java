/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mylife.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author johna
 */
public class HomeController {
        @RequestMapping("/")
    public ModelAndView viewartist(){
        return new ModelAndView("index");
    }
}
