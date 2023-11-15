package ru.connectx.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.connectx.demo.model.League;
import ru.connectx.demo.model.Team;

import java.util.List;

@Repository
public interface LeagueRepository extends JpaRepository<League, Long> {
    League findLeagueByNameLeague(String nameLeague);
    League findLeagueById(Long id);
}
