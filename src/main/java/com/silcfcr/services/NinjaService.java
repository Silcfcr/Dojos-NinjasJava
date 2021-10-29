package com.silcfcr.services;

import java.util.List;

import org.springframework.stereotype.Service;


import com.silcfcr.models.Ninja;

import com.silcfcr.repositories.NinjaRepository;

@Service
public class NinjaService {
	private final NinjaRepository ninjaRepository;
	
	public NinjaService(NinjaRepository ninjaRepository) {
		this.ninjaRepository = ninjaRepository;
	}
	
	public List<Ninja>getAllNinjas(){
		return ninjaRepository.findAll();
	}
	
	public Ninja createNinja( Ninja ninja ) {
		return ninjaRepository.save( ninja );
	}

}
