package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Pays;
import com.example.demo.repository.PaysRepository;

import lombok.RequiredArgsConstructor;


public interface PaysService {
	Pays findbyId(Long id);
	List<Pays> lister();
	Pays savePays(Pays pays);
	Pays updatePays(Long id, Pays pays);
	void deleteById(Long id);
}
