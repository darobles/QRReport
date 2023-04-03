package cl.drobles.distancias.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.drobles.distancias.model.Failture;

public interface FailtureRepository extends JpaRepository<Failture, Integer> {

	public List<Failture> findAllByOrderByIdAsc();
}
