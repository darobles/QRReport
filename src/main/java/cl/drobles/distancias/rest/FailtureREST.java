package cl.drobles.distancias.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.drobles.distancias.model.Failture;
import cl.drobles.distancias.service.FailtureService;

@RestController
@RequestMapping("/failture")
public class FailtureREST {
	@Autowired
	private FailtureService fService;
	
	@GetMapping("")
	public ResponseEntity<List<Failture>> getAll(){
		return ResponseEntity.ok(fService.findAllByOrderByIdAsc());
	}
}