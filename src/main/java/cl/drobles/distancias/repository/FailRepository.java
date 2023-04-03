package cl.drobles.distancias.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.drobles.distancias.model.Fail;

public interface FailRepository extends JpaRepository<Fail, Integer> {
	
}	
