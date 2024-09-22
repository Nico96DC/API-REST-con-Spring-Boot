package com.example.inicial1;

import com.example.inicial1.entities.Localidad;
import com.example.inicial1.entities.Domicilio;
import com.example.inicial1.entities.Persona;
import com.example.inicial1.entities.Libro;
import com.example.inicial1.entities.Autor;

import com.example.inicial1.repositories.PersonaRepository;
import com.example.inicial1.repositories.LibroRepository;
import com.example.inicial1.repositories.AutorRepository;
import com.example.inicial1.repositories.DomicilioRepository;
import com.example.inicial1.repositories.LocalidadRepository;


import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class Inicial1Application {
	private static final Logger logger = LoggerFactory.getLogger(Inicial1Application.class);

	@Autowired
	private PersonaRepository personaRepository;

	@Autowired
	private DomicilioRepository domicilioRepository;

	@Autowired
	private LocalidadRepository localidadRepository;

	@Autowired
	private LibroRepository libroRepository;

	@Autowired
	private AutorRepository autorRepository;
	public static void main(String[] args) {
		SpringApplication.run(Inicial1Application.class, args);
	}

	@Bean
	@Transactional
	CommandLineRunner init(PersonaRepository personaRepository) {
		return args -> {
			Persona per1 = Persona.builder().
					nombre("Alberto").
					apellido("Cortez").
					build();

			Domicilio dom1 = Domicilio.builder().
					calle("Suipacha").
					numero(239).
					build();

			Localidad loc1 = Localidad.builder().
					denominacion("Maipú").
					build();

			Libro lib1 = Libro.builder().
					titulo("Título 1").
					fecha(250150).
					genero("Narrativo").
					pag(255).
					build();

			Autor aut1 = Autor.builder().
                    nombre("Raúl").
                    apellido("Pérez").
                    bio("Escritor profesional").
                    build();

			per1.setDomicilio(dom1);
			per1.setLibros(List.of(lib1));
			loc1.setDomicilio(dom1);
			dom1.setPersona(per1);
			lib1.setPersona(per1);
			lib1.setAutores(List.of(aut1));
			aut1.setLibros(List.of(lib1));

			personaRepository.save(per1);
			domicilioRepository.save(dom1);
			localidadRepository.save(loc1);
			libroRepository.save(lib1);
			autorRepository.save(aut1);

			Persona per2 = Persona.builder().
					nombre("Alicia").
					apellido("Calderon").
					build();

			Domicilio dom2 = Domicilio.builder().
					calle("Lulunta").
					numero(339).build();

			Localidad loc2 = Localidad.builder().
					denominacion("CABA").
					build();

			Libro lib2 = Libro.builder().
					titulo("Título 2").
					fecha(250150).
					genero("Narrativo").
					pag(255).
					build();

			Autor aut2 = Autor.builder().
					nombre("Lorena").
					apellido("García").
					bio("Escritora").
					build();

			per2.setDomicilio(dom2);
			per2.setLibros(List.of(lib2));
			loc2.setDomicilio(dom2);
			dom2.setPersona(per2);
			lib2.setPersona(per2);
			lib2.setAutores(List.of(aut2));
			aut2.setLibros(List.of(lib2));

			personaRepository.save(per2);
			domicilioRepository.save(dom2);
			localidadRepository.save(loc2);
			libroRepository.save(lib2);
			autorRepository.save(aut2);

			List<Persona> recuperadas = personaRepository.findAll();
			System.out.println(recuperadas);

			logger.info("Detalles de la persona: {}", recuperadas);

			Optional<Persona> recuperada = personaRepository.findById(1L);
			System.out.println(recuperada);

			logger.info("Detalles de la persona: {}", recuperada);

			dom1.setCalle("Rodriguez");

			personaRepository.save(per1);
		};
	}
}
