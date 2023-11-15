package ru.connectx.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.connectx.demo.model.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {
    Country findCountryByNameCountry(String nameCountry);
    Country findCountryById(Integer id);
}
