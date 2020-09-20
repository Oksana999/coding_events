package org.launchcode.coding_events1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Oksana
 */
@Controller
@RequestMapping("events")
public class EventController {

   @GetMapping
   public String displayAllEVents(Model model){
      List<String> events = new ArrayList<>();
      events.add("Code with Pride");
      events.add("Strange Loop");
      events.add("Apple Loop");
      model.addAttribute("events", events);
      return "events/index";
   }

   //lives at /events/create
   @GetMapping("create")
   public String renderCreateEvent(){
      return "events/create";
   }
   //

}