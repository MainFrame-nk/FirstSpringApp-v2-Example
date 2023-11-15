package ru.connectx.demo.model;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import ru.connectx.demo.dto.CountryDTO;

import javax.persistence.*;

@Entity
@Table(name = "countries")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Country implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "country_seq")
    @SequenceGenerator(name = "country_seq", sequenceName = "SEQ_COUNTRIES")
    private Integer id;

    @Column(name = "name_country")
    private String nameCountry;

    @Column(name = "flag")
    private String flag;

    @Override
    public String getAuthority() {
        return nameCountry;
    }

    public CountryDTO toCountryDto() {
        return CountryDTO.toCountryDto(this);
    }
}
