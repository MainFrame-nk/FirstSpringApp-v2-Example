package ru.connectx.demo.service;

import ru.connectx.demo.dto.LeagueDTO;
import ru.connectx.demo.model.League;

import java.util.List;

public interface LeagueService {

    List<LeagueDTO> getAllLeagues();
    League getLeagueByNameLeague(String league);
    LeagueDTO saveLeague(LeagueDTO leagueDTO);
    League getLeagueById(Long id);
    void deleteLeague(Long id);
    LeagueDTO updateLeague(LeagueDTO leagueDTO, Long id);
}
