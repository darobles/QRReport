package cl.drobles.distancias.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.drobles.distancias.model.Commune;
import cl.drobles.distancias.service.CommuneService;

@RestController

@RequestMapping("/communes")
public class CommuneREST {
	@Autowired
	private CommuneService cService;
	
	@GetMapping()
	public ResponseEntity<List<Commune>> getAll(){
		return ResponseEntity.ok(cService.findAll());
	}
	
	@GetMapping("/regions/{region_id}")
	public ResponseEntity<List<Commune>> getAllByRegionId(@PathVariable("region_id") Integer region_id){		
		return ResponseEntity.ok(cService.findByIdRegion(region_id));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Commune>> getRegionId(@PathVariable("id") Integer id){
		if( cService.existsById(id) ) {
			return ResponseEntity.ok(cService.findById(id));
		}
		return ResponseEntity.status(400).body(Optional.empty());
	}
}
