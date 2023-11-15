package ru.connectx.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.connectx.demo.dto.EventDTO;
import ru.connectx.demo.model.Event;
import ru.connectx.demo.model.Match;
import ru.connectx.demo.repositories.EventRepository;
import ru.connectx.demo.repositories.MatchRepository;
import ru.connectx.demo.service.EventService;
import ru.connectx.demo.service.MatchService;

import java.math.BigInteger;
import java.util.Optional;

@Controller
public class UserController {

    private MatchService matchService;

    @GetMapping("/")
    public String mainPage() {
        return "index";
    }

    @GetMapping("/teams")
    public String teamsPage() {
        return "teams";
    }

//    @GetMapping("/match/{id}/events")
//    public String matchInfoPage(@PathVariable BigInteger id, Model model) {
//        Iterable<EventDTO> events = matchService.getEventsByMatchId(id);
//        model.addAttribute("events", events);
//        return "match-info";
//    }
}
