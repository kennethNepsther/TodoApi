package it.nepsther.todo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TodoApplication implements CommandLineRunner {
//	@Autowired
//	private TodoRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(TodoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
//
//		Todo td = new Todo(null, "Estudar", "Ler mais sobre BD H2", LocalDateTime.parse("22/03/2021 10:20", df), false);
//		
//		repository.saveAll(Arrays.asList(td));
//	
	}

}
