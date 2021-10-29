package com.silcfcr.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.silcfcr.models.Dojo;
import com.silcfcr.repositories.DojoRepository;

@Service
public class DojoService {
	private final DojoRepository dojoRepository;
	
	public DojoService(DojoRepository dojoRepository) {
		this.dojoRepository = dojoRepository;
	}
	
	public List<Dojo>getAllDojos(){
		System.out.println("Hello from service");
		return dojoRepository.findAll();
	}
	
	public Dojo getDojoById( Long id ) {
		Optional<Dojo> optionalDojo = dojoRepository.findById(id);
		if ( optionalDojo.isPresent() ) {
			return optionalDojo.get();
		}
		else {
			return null;
		}
	}
	
	public Dojo createDojo( Dojo dojo ) {
		return dojoRepository.save( dojo );
	}

}
