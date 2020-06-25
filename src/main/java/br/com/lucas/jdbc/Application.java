package br.com.lucas.jdbc;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.lucas.jdbc.model.Funcionario;
import br.com.lucas.jdbc.repository.FuncionarioJDBCRepository;

@SpringBootApplication
public class Application implements CommandLineRunner {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	 
    @Autowired
    private FuncionarioJDBCRepository funcionarioRepository;
 
    @Override
    public void run(String... args) throws Exception {

        logger.info("Inserting -> {}", funcionarioRepository.insert(new Funcionario(10011L, "Lucas", "Diniz", "diniz@gmail.com")));
        logger.info("Inserting -> {}", funcionarioRepository.insert(new Funcionario(10012L, "Bia", "Lopes", "lopes@gmail.com")));
        logger.info("Inserting -> {}", funcionarioRepository.insert(new Funcionario(10013L, "tony", "stark", "stark@gmail.com")));
  
        logger.info("Employee id 10011 -> {}", funcionarioRepository.findById(10011L));

        logger.info("Update 10003 -> {}", funcionarioRepository.update(new Funcionario(10011L, "Lucas", "Stark", "industriastark@gmail.com")));

        funcionarioRepository.deleteById(10013L);

        logger.info("All users -> {}", funcionarioRepository.findAll());
    }
 
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
	
	


