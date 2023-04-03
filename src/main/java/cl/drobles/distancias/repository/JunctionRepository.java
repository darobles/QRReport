package cl.drobles.distancias.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cl.drobles.distancias.model.Junction;

public interface JunctionRepository extends JpaRepository<Junction, Integer> {

	@Query (value = "SELECT *, 0.0 AS distancia FROM cruce where id_comuna not in (9999)", nativeQuery = true)
	public List<Junction> findAll();

	@Query (value = "SELECT *, 0.0 AS distancia FROM cruce WHERE id_cruce = ?1", nativeQuery = true)
	public Optional<Junction> findById(Integer id);
	
	@Query (value = "SELECT * FROM fn_cercanos(?1, ?2, ?3)", nativeQuery = true)
	public List<Junction> findNearby(double latitude, double longitude, double distance);
	
	@Query(value = "SELECT * FROM cruce WHERE id_comuna = ?1 and id_comuna not in (9999)",nativeQuery = true)
	public List<Junction> getJunctionsByCommuneId(Integer commune_id);
}
