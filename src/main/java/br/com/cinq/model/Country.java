package br.com.cinq.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Country implements Serializable {

	private static final long serialVersionUID = 5743318926606023223L;
	
	@Id
	@GeneratedValue
	@JsonProperty("id")
	private Integer countryId;	
	
	@JsonProperty("name")
	private String name;
	
	public Country() {
		super();
	}

	public Integer getCountryId() {
		return countryId;
	}
	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
