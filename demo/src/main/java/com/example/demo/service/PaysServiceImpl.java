package com.example.demo.service;

import java.lang.StackWalker.Option;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Pays;
import com.example.demo.repository.PaysRepository;

import lombok.RequiredArgsConstructor;
import net.bytebuddy.asm.Advice.Return;

@Service
public class PaysServiceImpl implements PaysService {
	private final PaysRepository paysRepository;
	
	
	public PaysServiceImpl(PaysRepository paysRepository) {
		this.paysRepository = paysRepository;
	}

	@Override
	public Pays findbyId(Long id) {
		// TODO Auto-generated method stub
		return paysRepository.findById(id).orElse(null);
	}

	@Override
	public List<Pays> lister() {
		// TODO Auto-generated method stub
		return paysRepository.findAll();
	}

	@Override
	public Pays savePays(Pays pays) {
		// TODO Auto-generated method stub
		return paysRepository.save(pays);
	}

	@Override
	public Pays updatePays(Long id, Pays pays) {
		// TODO Auto-generated method stub
		
//		paysRepository.findById(id).ifPresent(pAMod -> {
		Optional<Pays>optionalPays =  paysRepository.findById(id);
		if(optionalPays.isPresent()) {
			Pays pAMod = optionalPays.get();
			pAMod.setContinent(pays.getContinent());
			pAMod.setNom(pays.getNom());
			pAMod.setNombreHabitants(pays.getNombreHabitants());
			pAMod.setSuperficie(pays.getSuperficie());
			paysRepository.save(pAMod);
			return pAMod;
		}
		return null;		
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		paysRepository.deleteById(id);
	}

}
