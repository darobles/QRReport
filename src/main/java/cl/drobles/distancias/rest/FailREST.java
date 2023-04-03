package cl.drobles.distancias.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.drobles.distancias.model.Fail;
import cl.drobles.distancias.service.FailService;

@RestController
@RequestMapping("/fails")
public class FailREST {
	
	@Autowired
	private FailService fService;
	
	@GetMapping
	public ResponseEntity<List<Fail>> getAllFails() {
		return ResponseEntity.ok(fService.findAll(Sort.by(Sort.Direction.ASC,"id")));
	}

}
