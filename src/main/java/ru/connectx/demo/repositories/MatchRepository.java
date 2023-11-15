package ru.connectx.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.connectx.demo.dto.EventDTO;
import ru.connectx.demo.model.Event;
import ru.connectx.demo.model.Match;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface MatchRepository extends JpaRepository<Match, BigInteger> {
//    Match findMatchByNameLeague(String nameLeague);
    Match findMatchById(BigInteger id);

//    @Query("select e from Match e left join fetch e.eventsMatch where e.eventsMatch=:matchId")
//    List<EventDTO> findEventsByMatch(BigInteger matchId);
}
