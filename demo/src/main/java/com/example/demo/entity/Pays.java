package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Pays {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(columnDefinition = "TEXT")
	private String nom;
	private String continent;
	private Long superficie;
	private Long nombreHabitants;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getContinent() {
		return continent;
	}
	public void setContinent(String continent) {
		this.continent = continent;
	}
	public Long getSuperficie() {
		return superficie;
	}
	public void setSuperficie(Long superficie) {
		this.superficie = superficie;
	}
	public Long getNombreHabitants() {
		return nombreHabitants;
	}
	public void setNombreHabitants(Long nombreHabitants) {
		this.nombreHabitants = nombreHabitants;
	}

	
}
