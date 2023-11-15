package ru.connectx.demo.service;

import ru.connectx.demo.dto.EventDTO;
import ru.connectx.demo.dto.MatchDTO;
import ru.connectx.demo.model.Event;
import ru.connectx.demo.model.Match;

import java.math.BigInteger;
import java.util.List;

public interface MatchService {

    List<MatchDTO> getAllMatches();
//    Match getMatchByNameLeague(String nameLeague);
    MatchDTO saveMatch(MatchDTO matchDTO);
    Match getMatchById(BigInteger id);
    void deleteMatch(BigInteger id);
    MatchDTO updateMatch(MatchDTO matchDTO, BigInteger id);
}
