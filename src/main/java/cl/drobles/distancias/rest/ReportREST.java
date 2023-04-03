package cl.drobles.distancias.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.drobles.distancias.model.Report;
import cl.drobles.distancias.service.ReporteService;

@RestController
@RequestMapping("reports")
public class ReportREST {
	
	@Autowired
	private ReporteService rService;
	
	@GetMapping("")
	public ResponseEntity<List<Report>> getAll(){
		return ResponseEntity.ok(rService.findAll());
	}
}
