package com.silcfcr.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.Repository;

import com.silcfcr.models.Dojo;

public interface DojoRepository extends Repository<Dojo, Long>{
	List<Dojo> findAll(); // SELECT * FROM hobbies
	 // SELECT * FROM hobbies WHERE identifier=id
	Dojo save( Dojo dojo );
	Optional<Dojo> findById(Long id);
	//Long deleteByIdentifier( int id ); // DELETE FROM hobbies WHERE identifier = id
}