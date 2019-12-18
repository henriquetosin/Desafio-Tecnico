package br.com.cinq.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cinq.model.Country;

public interface CountryRepository extends JpaRepository<Country, Integer>{
}
