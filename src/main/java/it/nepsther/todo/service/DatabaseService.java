package it.nepsther.todo.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.nepsther.todo.model.Todo;
import it.nepsther.todo.repositoy.TodoRepository;

@Service
public class DatabaseService {
	
	@Autowired
	private TodoRepository repository;
	
	public void instaceDateBase() {
		
		DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

		Todo td = new Todo(null, "Estudar", "Ler mais sobre BD H2", LocalDateTime.parse("22/03/2021 10:20", df), false);
		Todo td1 = new Todo(null, "Ler", "MicroServiço", LocalDateTime.parse("22/03/2021 10:20", df), false);
		Todo td2 = new Todo(null, "Fazer", "Api pizzaria", LocalDateTime.parse("27/03/2021 10:20", df), false);
		Todo td3 = new Todo(null, "Escrever", "Sobre Teste unitários", LocalDateTime.parse("20/04/2021 10:20", df), false);
		Todo td4 = new Todo(null, "Entrevista", "Entrevista com o Bai", LocalDateTime.parse("10/03/2021 10:20", df), true);
		Todo td5 = new Todo(null, "Consulta Medica", "Consultar o Estomatologista", LocalDateTime.parse("09/01/2021 10:20", df), true);
		repository.saveAll(Arrays.asList(td,td1,td2,td3,td4,td5));
		
	}

}
