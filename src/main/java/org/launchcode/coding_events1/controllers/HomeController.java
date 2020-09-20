package org.launchcode.coding_events1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Oksana
 */
@Controller
public class HomeController {

   @GetMapping
   public String index(){
      return "index";
   }

}
