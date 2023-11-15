package ru.connectx.demo.service;

import ru.connectx.demo.dto.TeamDTO;
import ru.connectx.demo.dto.UserDTO;
import ru.connectx.demo.model.Team;
import ru.connectx.demo.model.League;

import java.util.List;

public interface TeamService {

    List<TeamDTO> getAllTeams();
//    List<League> getLeaguesByTeamId(Long teamId);
    Team getTeamByName(String team);
    TeamDTO saveTeam(TeamDTO teamDTO);
    Team getTeamById(Long id);
    void deleteTeam(Long id);
    TeamDTO updateTeam(TeamDTO teamDTO, Long id);
}
