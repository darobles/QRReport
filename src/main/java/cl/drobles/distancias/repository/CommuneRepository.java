package cl.drobles.distancias.repository;

import java.util.List;
import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cl.drobles.distancias.model.Commune;

public interface CommuneRepository extends JpaRepository<Commune, Integer> {

	@Query (value = "SELECT c.id_comuna, c.nombre, c.id_region, r.nombre AS nombre_region, mantenida FROM comuna c INNER JOIN region r ON c.id_region = r.id_region where mantenida=true", nativeQuery = true)
	public List<Commune> findAll();

	@Query (value = "SELECT c.id_comuna, c.nombre, c.id_region, r.nombre AS nombre_region AS nombre_region, mantenida FROM comuna c INNER JOIN region r ON c.id_region = r.id_region WHERE c.id_comuna = ?1  where c.mantenida=true", nativeQuery = true)
	public Optional<Commune> findById(Integer id);

	@Query (value = "SELECT c.id_comuna, c.nombre, c.id_region, r.nombre AS nombre_region, mantenida FROM comuna c INNER JOIN region r ON c.id_region = r.id_region WHERE c.id_region = ?1 and c.mantenida=true", nativeQuery = true)
	public List<Commune> findByIdRegion(Integer id);
	
	@Query(value= "SELECT * FROM COMUNAS WHERE mantenida=true", nativeQuery = true)
	public List<Commune> findAllMaintained();

}
