package reyes.lopez.rafa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Pregunta {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String enunciado;

	private String textoPregunta;

	private String solucion;

}