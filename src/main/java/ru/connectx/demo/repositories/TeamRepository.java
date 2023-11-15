package ru.connectx.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.connectx.demo.dto.TeamDTO;
import ru.connectx.demo.model.League;
import ru.connectx.demo.model.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
    Team findTeamByName(String nameTeam);
    Team findTeamById(Long id);

}
