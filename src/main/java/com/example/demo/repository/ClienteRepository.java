package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.ClientEntity;

@Repository
public interface ClienteRepository extends JpaRepository<ClientEntity, Integer> {

	// List<ClientEntity> findByShareKey(String shareKey);
	Optional<ClientEntity> findByShareKeyContaining(String shareKey);

}
