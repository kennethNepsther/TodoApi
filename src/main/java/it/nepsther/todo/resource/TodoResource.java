package it.nepsther.todo.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import it.nepsther.todo.model.Todo;
import it.nepsther.todo.service.TodoService;

@RestController
@RequestMapping(value="api/todo")
public class TodoResource {
	@Autowired
	private TodoService service; 
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Todo>findById(@PathVariable Integer id){
	Todo todo = service.findById(id);
		return ResponseEntity.ok().body(todo);
		
	}
	@GetMapping(value = "/open")
	public ResponseEntity<List<Todo>>listTodoOpen(){
		List<Todo> todoOpen =service.listOpen();
		return ResponseEntity.ok().body(todoOpen);
		
	}
	
	@GetMapping(value = "/closed")
	public ResponseEntity<List<Todo>>listTodoClosed(){
		List<Todo> todoClosed =service.listClosed();
		return ResponseEntity.ok().body(todoClosed);
		
	}
	
	@GetMapping
	public ResponseEntity<List<Todo>>listAllTodo(){
		List<Todo> allTodo =service.findAll();
		return ResponseEntity.ok().body(allTodo);
		
	}
	
	@PostMapping
	public ResponseEntity<Todo>create(@RequestBody Todo todo){
		todo = service.create(todo);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(todo.getId()).toUri();
		return ResponseEntity.created(uri).body(todo);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void>delete(@PathVariable Integer id){
		service.delete(id);
		
		return ResponseEntity.noContent().build();
	}

}
