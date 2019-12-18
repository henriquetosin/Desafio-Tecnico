package br.com.cinq.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.cinq.model.City;

public interface CityRepository extends JpaRepository<City, Integer>{
	
	@Query("Select c from City c where UPPER(c.country.name) LIKE UPPER(concat('%', ?1,'%'))")
	List<City> findByCountryName(String countryName);
}
