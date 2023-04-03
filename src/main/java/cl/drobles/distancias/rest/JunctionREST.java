package cl.drobles.distancias.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.drobles.distancias.model.Junction;
import cl.drobles.distancias.model.JunctionParams;
import cl.drobles.distancias.service.JunctionService;

@RestController
@RequestMapping("/junctions")
//@Tag(name = "Junction service", description = "Calcula cruces cercanos")
public class JunctionREST {

	@Autowired
	private JunctionService junctionService;
	
	@GetMapping("")
	public ResponseEntity<List<Junction>> getAllJunctions() {
		return ResponseEntity.ok(junctionService.findAll());
	}
	
	@GetMapping("/communes/{commune_id}")
	public ResponseEntity<List<Junction>> getJunctionByCommuneId(@PathVariable("commune_id") Integer id) {
		List<Junction> cruces = junctionService.getJunctionsByCommuneId(id);
		return ResponseEntity.ok(cruces);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Junction>> getJunctionById(@PathVariable("id") Integer id) {
		return ResponseEntity.ok(junctionService.findById(id));
	}
	
	@PostMapping("/nearby")
	@Transactional
	public ResponseEntity<List<Junction>> getNearbyJunctions(@Valid @RequestBody JunctionParams params) {		
		if (params.getJunction_id() != null) {
			try {
				Optional<Junction> opJunc= junctionService.findById(params.getJunction_id());
				if(opJunc.isPresent()) {
					Junction junction = opJunc.get();
					params.setLatitud(junction.getLatitud());
					params.setLongitud(junction.getLongitud());
				}
				params.setJunction_id(null);
				params.setLatitud(null);
				params.setLongitud(null);
				
			} catch (Exception ex) {
				params.setJunction_id(null);
				params.setLatitud(null);
				params.setLongitud(null);
			}
		}	
		
		if ((params.getLatitud() == null) || (params.getLongitud() == null) || (params.getDistancia() == null)) {
			return ResponseEntity.badRequest().body(new ArrayList<Junction>());
		} 		
		return ResponseEntity.ok(junctionService.getNearby(params.getLatitud(), params.getLongitud(), params.getDistancia()));
	}
	
}
