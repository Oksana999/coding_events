package org.launchcode.coding_events1.controllers;

import org.launchcode.coding_events1.data.EventData;
import org.launchcode.coding_events1.models.Event;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Oksana
 */
@Controller
@RequestMapping("events")
public class EventController {
//   private static List<Event> events = new ArrayList<>();


   //lives at /events/create
   @GetMapping("create")
   public String renderCreateEvent() {
      return "events/create";
   }

   @PostMapping("create")
   public String createEvent(@ModelAttribute Event newEvent) {
      EventData.add(newEvent);
      return "redirect:";
   }

   @GetMapping
   public String displayAllEVents(Model model) {
      model.addAttribute("events", EventData.getAll());
      return "events/index";
   }

   @GetMapping("delete")
   public String displayDeleteEventForm(Model model) {
      model.addAttribute("title", "Delete Events");
      model.addAttribute("events", EventData.getAll());

      return "events/delete";
   }

   @PostMapping("delete")
   public String processDeleteEventsForm(@RequestParam(required = false) int[] eventIds) {
      if (eventIds != null) {
         for (int id : eventIds) {
            EventData.remove(id);
         }
      }
      return "redirect:";
   }

   @GetMapping("edit/{eventId}")
   public String displayEditForm(Model model, @PathVariable int eventId) {
      Event event = EventData.getById(eventId);
      model.addAttribute("event", event);
      model.addAttribute("title", "Edit Event"+ event.getName());

      return "events/edit";
   }

   @PostMapping("edit")
   public String processEditForm(int eventId, String name, String description) {
      Event event = EventData.getById(eventId);
      event.setName(name);
      event.setDescription(description);

      return "redirect:";
   }
}


