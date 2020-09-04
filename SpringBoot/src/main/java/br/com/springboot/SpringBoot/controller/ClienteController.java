package br.com.springboot.SpringBoot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.springboot.SpringBoot.model.Cliente;
import br.com.springboot.SpringBoot.service.ClienteService;

@Controller
@RequestMapping("/paciente")
public class ClienteController {
	
	@Autowired
	private ClienteService service;
	
	
	@PostMapping
	public ResponseEntity<Cliente> salvarCliente(@RequestBody Cliente cliente) {
		service.salvarCliente(cliente);
		return new ResponseEntity<Cliente>(HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Cliente>> buscarCliente() {
		return new ResponseEntity<List<Cliente>>(service.listarClientes(), HttpStatus.OK);
	}

}
