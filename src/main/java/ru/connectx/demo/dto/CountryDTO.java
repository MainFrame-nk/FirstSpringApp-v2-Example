package ru.connectx.demo.dto;

import lombok.*;
import org.springframework.stereotype.Component;
import ru.connectx.demo.model.Country;
import ru.connectx.demo.model.League;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Component
public class CountryDTO {

    private Integer id;
    private String nameCountry;
    private String flag;

    public CountryDTO(Integer id) {
        this.id = id;
    }

    public CountryDTO(String id) {
        this.id = Integer.parseInt(id);
    }

    public static CountryDTO toCountryDto(Country country) {
        return CountryDTO.builder()
                .id(country.getId())
                .nameCountry(country.getNameCountry())
                .flag(country.getFlag())
                .build();
    }
}
