package ru.connectx.demo.dto;

import lombok.*;
import org.springframework.stereotype.Component;
import ru.connectx.demo.model.Country;
import ru.connectx.demo.model.League;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Component
public class LeagueDTO {

    private Long id;
    private String nameLeague;
    private CountryDTO countryLeague = new CountryDTO();

    public LeagueDTO(Long id) {
        this.id = id;
    }

    public LeagueDTO(String id) {
        this.id = Long.parseLong(id);
    }

    public static LeagueDTO toLeagueDto(League league) {
        return LeagueDTO.builder()
                .id(league.getId())
                .nameLeague(league.getNameLeague())
                .countryLeague(league.getCountryLeague().toCountryDto())
                .build();
    }
}
