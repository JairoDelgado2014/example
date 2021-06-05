package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.ClientEntity;
import com.example.demo.services.ClienteService;

@CrossOrigin("*")
@RestController
@RequestMapping("client")
public class ClienteController {

	@Autowired
	private ClienteService clientService;

	@GetMapping("/listar")
	public List<ClientEntity> listar() {
		return clientService.listar();
	}

	@PostMapping("/guardar")
	public void saveClient(@RequestBody ClientEntity clientEntity) {
		clientService.save(clientEntity);
	}

	@GetMapping("/buscarShareKey/{shareKey}")
	public ClientEntity findShareKey(@PathVariable("shareKey") String shareKey) {
		return clientService.findShareKey(shareKey);
	}

}
