package it.nepsther.todo.resource.exception;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StandardError implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Long timestamp;
	private Integer status;
	private String message;

}
