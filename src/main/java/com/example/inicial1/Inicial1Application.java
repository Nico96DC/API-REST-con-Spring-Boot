package com.example.inicial1;

import com.example.inicial1.entities.Localidad;
import com.example.inicial1.entities.Domicilio;
import com.example.inicial1.entities.Persona;
import com.example.inicial1.entities.Libro;
import com.example.inicial1.entities.Autor;

import com.example.inicial1.repositories.PersonaRepository;

import jakarta.transaction.Transactional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class Inicial1Application {
	public static void main(String[] args) {
		SpringApplication.run(Inicial1Application.class, args);
		System.out.println("Programa ejecutándose.");
	}

	@Bean
	@Transactional
	CommandLineRunner init(PersonaRepository personaRepository) {
		return args -> {
			Persona per1 = Persona.builder().
					nombre("Alberto").
					apellido("Cortez").
					dni(13467928).
					build();

			Domicilio dom1 = Domicilio.builder().
					calle("Suipacha").
					numero(239).
					build();

			Localidad loc1 = Localidad.builder().
					denominacion("Mendoza").
					build();

			Libro lib1 = Libro.builder().
					titulo("Título 1").
					fecha(250124).
					genero("Narrativo").
					pag(255).
					build();

			Autor aut1 = Autor.builder().
					nombre("Raúl").
					apellido("Pérez").
					bio("Escritor profesional").
					build();

			dom1.setLocalidad(loc1);
			lib1.setAutores(List.of(aut1));
			per1.setLibros(List.of(lib1));
			per1.setDomicilio(dom1);

			personaRepository.save(per1);

			Persona per2 = Persona.builder().
					nombre("Alicia").
					apellido("Calderon").
					dni(12345678).
					build();

			Domicilio dom2 = Domicilio.builder().
					calle("Lunlunta").
					numero(339).
					build();

			Localidad loc2 = Localidad.builder().
					denominacion("Maipú").
					build();

			Libro lib2 = Libro.builder().
					titulo("Título 2").
					fecha(240124).
					genero("Narrativo").
					pag(255).
					build();

			Autor aut2 = Autor.builder().
					nombre("Lorena").
					apellido("García").
					bio("Escritora").
					build();

			dom2.setLocalidad(loc2);
			lib2.setAutores(List.of(aut2));
			per2.setLibros(List.of(lib2));
			per2.setDomicilio(dom2);

			personaRepository.save(per2);
		};
	}
}
