package com.example.demo.restcontroller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Pays;
import com.example.demo.repository.PaysRepository;
import com.example.demo.service.PaysService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/pays")
public class PaysRestController {
	private final PaysService paysService;
	
	public PaysRestController(PaysService paysService) {
		this.paysService = paysService;
	}

	@GetMapping("/{id}")
	public Pays getById(@PathVariable Long id) {
		return paysService.findbyId(id);
	}
	
	@GetMapping
	public List<Pays> lister(){
		return paysService.lister();
	}
	
	@PostMapping
	public ResponseEntity<?> savePays(@RequestBody Pays pays) {
		Pays savePays = paysService.savePays(pays);
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(savePays);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updatePays(@RequestBody Pays pays, @PathVariable Long id) {
		Pays updatePays = paysService.updatePays(id, pays);
		if(updatePays ==  null){
			return ResponseEntity.badRequest().body("Pays does not exist");
		}
		
		return ResponseEntity.ok(updatePays);
	}
	
	@DeleteMapping("/{id}")
	public void deletePays(@PathVariable Long id) {
		paysService.deleteById(id);
	}

}
