package br.com.cinq.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cinq.DAO.CityRepository;
import br.com.cinq.model.City;

@Service("cityService")
public class CityService {
	
	@Autowired
	private CityRepository repository;

	public List<City> loadCities(String country){
		
		if(country != null && country.length() > 0)
			return this.repository.findByCountryName(country);
		else
			return this.repository.findAll();
	}
}
