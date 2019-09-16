/*
 * Copyright (C) IDB Mobile Technology S.L. - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */
package reyes.lopez.rafa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Test {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String enunciado;

	private String pregunta;

	private String tema;
	private String respuestaA;
	private String respuestaB;
	private String respuestaC;
	private String respuestaD;
	private String respuestaCorrecta;
	private String explicacion;
	private String activa = "1";

}