package de.purnama.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;

import de.purnama.demo.repository.HighlightRepository;
import de.purnama.demo.repository.UserRepository;
import de.purnama.demo.service.JdbcExample;

@SpringBootApplication
public class HibernateJpaApplication implements CommandLineRunner {

	@Autowired
	private ObjectMapper jacksonObjectMapper;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private HighlightRepository highlightRepository;
	
	@Autowired
	private JdbcExample jdbcExample;
	
	public static void main(String[] args) {
		SpringApplication.run(HibernateJpaApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {

		//System.out.println(jacksonObjectMapper.writeValueAsString(userRepository.findAll()));
		//System.out.println(jacksonObjectMapper.writeValueAsString(highlightRepository.findAll()));
		System.out.println(jacksonObjectMapper.writeValueAsString(jdbcExample.getUserDataById(1L)));
	}
	
	@Bean
	ObjectMapper objectMapper() {
		return new ObjectMapper();
	}
}
