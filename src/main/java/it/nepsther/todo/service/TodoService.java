package it.nepsther.todo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.nepsther.todo.model.Todo;
import it.nepsther.todo.repositoy.TodoRepository;
import it.nepsther.todo.service.exception.ObjectNotfoundException;

@Service
public class TodoService {

	@Autowired
	private TodoRepository repository;

	public Todo findById(Integer id) {
		Optional<Todo> todo = repository.findById(id);
		return todo.orElseThrow(
				() -> new ObjectNotfoundException("Tarefa não encontrada id: "+ id +" Tipo: " + Todo.class.getName()));
	}

	public List<Todo> listOpen() {
		List<Todo> listOpen = repository.findAllOpen();
		return listOpen;
	}

	public List<Todo> listClosed() {
		List<Todo> listClosed = repository.findAllClosed();
		return listClosed;
	}

	public List<Todo> findAll() {
		List<Todo> listAll = repository.findAll();
		return listAll;
	}

	public Todo create(Todo todo) {
		todo.setId(null);
		todo = repository.save(todo);
		return todo;
	}

	public void delete(Integer id) {
		// findById(id);
		repository.deleteById(id);

	}

}
