package cl.drobles.distancias.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.drobles.distancias.model.Region;
import cl.drobles.distancias.service.RegionService;

@RestController
@RequestMapping("/regions")
public class RegionREST {

	@Autowired
	private RegionService regionService;

	@GetMapping
	public ResponseEntity<List<Region>> getAllRegions() {
		return ResponseEntity.ok(regionService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<Region>> getRegionById(@PathVariable("id") Integer id) {
		return ResponseEntity.ok(regionService.findById(id));
	}

}