package it.nepsther.todo.repositoy;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import it.nepsther.todo.model.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer> {
	
	@Query("SELECT obj FROM Todo obj WHERE obj.finished = false ORDER BY obj.finishDate")
	List<Todo> findAllOpen();
	
	@Query("SELECT obj FROM Todo obj WHERE obj.finished = true ORDER BY obj.finishDate")
	List<Todo> findAllClosed();

}
