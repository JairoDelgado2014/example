package com.example.demo.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.entity.ClientEntity;
import com.example.demo.repository.ClienteRepository;

@SpringBootTest
public class ClienteServiceTest {

	@Autowired
	ClienteRepository clienteRepositoryMock = Mockito.mock(ClienteRepository.class);;
	
	@Test
	void carga() {
		Date fecha = new Date();
		List<ClientEntity>listacliente=new ArrayList<ClientEntity>();
		List<ClientEntity>listaclienterespuesta=new ArrayList<ClientEntity>();
		ClientEntity clientEntity = new ClientEntity(1,"abc","abc","abc","abc",fecha,1);
		listacliente.add(clientEntity);
		ClientEntity clientEntity2 = new ClientEntity(2,"def","def","def","def",fecha,1);
		listacliente.add(clientEntity2);
		Mockito.when(clienteRepositoryMock.findAll()).thenReturn(listacliente);
		listaclienterespuesta=clienteRepositoryMock.findAll();
		System.out.println(listaclienterespuesta);
		assertEquals(2, listaclienterespuesta.size());	
	}

}
