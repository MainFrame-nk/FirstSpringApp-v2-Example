package ru.connectx.demo.dto;

import lombok.*;
import org.springframework.stereotype.Component;
import ru.connectx.demo.model.Event;
import ru.connectx.demo.model.Match;
import ru.connectx.demo.model.Role;
import ru.connectx.demo.model.Team;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Component
public class MatchDTO {

    private BigInteger id;
    private LocalDateTime dateTimeMatch;
    private LeagueDTO leagueMatch = new LeagueDTO();
    private TeamDTO homeTeam = new TeamDTO();
    private TeamDTO guestTeam = new TeamDTO();
//    private Set<EventDTO> eventsMatch = new HashSet<>();

    public MatchDTO(BigInteger id) {
        this.id = id;
    }

    public MatchDTO(String id) {
        this.id = BigInteger.valueOf(Integer.parseInt(id));
    }

    public static MatchDTO toMatchDto(Match match) {
        return MatchDTO.builder()
                .id(match.getId())
                .dateTimeMatch(match.getDateTimeMatch())
                .leagueMatch(match.getLeagueMatch().toLeagueDto())
                .homeTeam(match.getHomeTeam().toTeamDto())
                .guestTeam(match.getGuestTeam().toTeamDto())
//                .eventsMatch(match.getEventsMatch().stream().map(Event::toEventDto).collect(Collectors.toSet()))
                .build();
    }
}
