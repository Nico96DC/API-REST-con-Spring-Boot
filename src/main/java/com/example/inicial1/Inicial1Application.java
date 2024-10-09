package com.example.inicial1;

import com.example.inicial1.entities.Localidad;
import com.example.inicial1.entities.Domicilio;
import com.example.inicial1.entities.Persona;
import com.example.inicial1.entities.Libro;
import com.example.inicial1.entities.Autor;

import com.example.inicial1.repositories.AutorRepository;
import com.example.inicial1.repositories.LocalidadRepository;
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
	CommandLineRunner init(PersonaRepository personaRepository,
                           LocalidadRepository localidadRepository, AutorRepository autorRepository) {
		return args -> {
			Autor aut1 = Autor.builder().
					nombre("Raúl").
					apellido("Pérez").
					bio("Escritor profesional").
					build();

			Libro lib1 = Libro.builder().
					titulo("Título 1").
					fecha(250124).
					genero("Narrativo").
					pag(255).
                    autores(List.of(aut1)).
					build();

            autorRepository.save(aut1);

			Localidad loc1 = Localidad.builder().
					denominacion("Mendoza").
					build();

            localidadRepository.save(loc1);

			Domicilio dom1 = Domicilio.builder().
					calle("Suipacha").
					numero(252).
					localidad(loc1).
					build();

			Persona per1 = Persona.builder().
					nombre("Alberto").
					apellido("Cortez").
					dni(13467928).
                    libros(List.of(lib1)).
                    domicilio(dom1).
					build();

			personaRepository.save(per1);

			Autor aut2 = Autor.builder().
					nombre("Lorena").
					apellido("García").
					bio("Escritora").
					build();

			Libro lib2 = Libro.builder().
					titulo("Título 2").
					fecha(240124).
					genero("Narrativo").
					pag(255).
                    autores(List.of(aut2)).
					build();

            autorRepository.save(aut2);

			Localidad loc2 = Localidad.builder().
					denominacion("Maipú").
					build();

            localidadRepository.save(loc2);

			Domicilio dom2 = Domicilio.builder().
					calle("Lunlunta").
					numero(339).
                    localidad(loc2).
					build();

			Persona per2 = Persona.builder().
					nombre("Alicia").
					apellido("Calderon").
					dni(12345678).
                    libros(List.of(lib2)).
                    domicilio(dom2).
					build();

			personaRepository.save(per2);
		};
	}
}
