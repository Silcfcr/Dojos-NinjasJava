package com.silcfcr.repositories;

import java.util.List;


import org.springframework.data.repository.Repository;


import com.silcfcr.models.Ninja;

public interface NinjaRepository extends Repository<Ninja, Long>{
	List<Ninja> findAll(); // SELECT * FROM hobbies
	Ninja save( Ninja ninja );
	
}