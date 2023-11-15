package ru.connectx.demo.service;

import ru.connectx.demo.dto.EventDTO;
import ru.connectx.demo.dto.MatchDTO;
import ru.connectx.demo.dto.TeamDTO;
import ru.connectx.demo.model.Event;

import java.math.BigInteger;
import java.util.List;

public interface EventService {

    List<EventDTO> getAllEvents();
//    Event getEventByNameQuotation(String nameQuotation);
    EventDTO saveEvent(BigInteger matchId, EventDTO eventDTO);
    Event getEventById(BigInteger id);
    void deleteEvent(BigInteger id);
    EventDTO updateEvent(EventDTO eventDTO, BigInteger id);
//    List<EventDTO> getEventsByTeamId(Long teamId);
    List<EventDTO> getEventsByMatchId(BigInteger matchId);
    List<EventDTO> getEventsByTeamId(Long teamId);
    List<EventDTO> getEventsByQuotation(Integer quotationId);
    List<EventDTO> getEventsByMatchAndTeamAndQuotation(BigInteger matchId, Long teamId, Integer quotationId);
    EventDTO getEventByMatchAndTeamAndQuotationAndPeriod(BigInteger matchId, Long teamId, Integer quotationId, Byte periodMatch);
}
