package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.ClientEntity;
import com.example.demo.repository.ClienteRepository;

@Service
public class ClienteService {

	static Logger logger = Logger.getLogger(ClienteService.class);

	@Autowired
	private ClienteRepository clienteRepository;

	public List<ClientEntity> listar() {
		return clienteRepository.findAll();
	}

	public void save(ClientEntity clientEntity) {
		clienteRepository.save(clientEntity);
	}

	public ClientEntity findShareKey(String shareKey) {
		Optional<ClientEntity> cliente = clienteRepository.findByShareKeyContaining(shareKey);
		if (cliente.isPresent()) {
			logger.info("llamado desde la busqueda por key");
			return cliente.get();
		}
		return null;
	}

	public void deleteById(Integer id) {
		clienteRepository.deleteById(id);
		logger.warn("Registro con: " + id + "eliminado");
	}

	public ClientEntity update(ClientEntity entity) {
		Optional<ClientEntity> cliente = clienteRepository.findById(entity.getId());
		if (cliente.isPresent()) {
			logger.warn("Registro con: " + entity.getId() + "actualizado con éxito");
			return clienteRepository.save(entity);
		}
		logger.warn("Registro con: " + entity.getId() + "fallo al actualizar");
		return null;
	}
}
