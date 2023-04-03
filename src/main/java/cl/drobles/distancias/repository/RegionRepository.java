package cl.drobles.distancias.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cl.drobles.distancias.model.Region;


public interface RegionRepository extends JpaRepository<Region, Integer> {
	
	@Query(value= "select distinct r.id_region, r.nombre  from region r, comuna c where r.id_region = c.id_region and c.mantenida = true",nativeQuery = true)
	public List<Region> findAll();

}