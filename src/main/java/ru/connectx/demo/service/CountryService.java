package ru.connectx.demo.service;

import ru.connectx.demo.dto.CountryDTO;
import ru.connectx.demo.model.Country;

import java.util.List;

public interface CountryService {

    List<CountryDTO> getAllCountries();
    Country getCountryByNameCountry(String country);
    CountryDTO saveCountry(CountryDTO countryDTO);
    Country getCountryById(Integer id);
    void deleteCountry(Integer id);
    CountryDTO updateCountry(CountryDTO countryDTO, Integer id);
}
