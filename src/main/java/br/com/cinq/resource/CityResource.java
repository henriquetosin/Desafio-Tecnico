package br.com.cinq.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.cinq.model.City;
import br.com.cinq.service.CityService;

@RestController("cityResource")
public class CityResource {

	@Autowired
	private CityService cityService;
	
	@RequestMapping(value = "/cities", method = RequestMethod.GET)
	public ResponseEntity<List<City>> listar(@RequestParam(value = "country", required = false) String country) {
		List<City> listCity = cityService.loadCities(country);
		return new ResponseEntity<List<City>>(new ArrayList<City>(listCity), HttpStatus.OK);
	}
}