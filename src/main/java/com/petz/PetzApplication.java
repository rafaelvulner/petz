package com.petz;

import com.petz.entity.Cliente;
import com.petz.entity.Pet;
import com.petz.repository.ClienteRepository;
import com.petz.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class PetzApplication implements CommandLineRunner {

	@Autowired
	private PetRepository petRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	public static void main(String[] args) {
		SpringApplication.run(PetzApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		/*Pet pet = new Pet(null, "tobby", "pincher",null);

		this.petRepository.save(pet);

		Cliente cliente = new Cliente(null, "Rafael", "12996449383", "Rua Charles", Arrays.asList(pet));

		this.clienteRepository.save(cliente);*/


	}
}
