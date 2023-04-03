package cl.drobles.distancias.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.drobles.distancias.model.Imagen;
import cl.drobles.distancias.service.ImagenService;

@RestController
@RequestMapping("/images")
public class ImagenREST {
	@Autowired
	private ImagenService iService;
	
	@GetMapping("")
	public ResponseEntity<List<Imagen>> getAll(){
		return ResponseEntity.ok(iService.findAll());
	}
}
