package com.demo.cine;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the genero database table.
 * 
 */
@Entity
@NamedQuery(name="Genero.findAll", query="SELECT g FROM Genero g")
public class Genero implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_genero")
	private int idGenero;

	private String nombre;

	//bi-directional many-to-one association to GeneroPelicula
	@OneToMany(mappedBy="genero")
	private List<GeneroPelicula> generoPeliculas;

	public Genero() {
	}

	public int getIdGenero() {
		return this.idGenero;
	}

	public void setIdGenero(int idGenero) {
		this.idGenero = idGenero;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<GeneroPelicula> getGeneroPeliculas() {
		return this.generoPeliculas;
	}

	public void setGeneroPeliculas(List<GeneroPelicula> generoPeliculas) {
		this.generoPeliculas = generoPeliculas;
	}

	public GeneroPelicula addGeneroPelicula(GeneroPelicula generoPelicula) {
		getGeneroPeliculas().add(generoPelicula);
		generoPelicula.setGenero(this);

		return generoPelicula;
	}

	public GeneroPelicula removeGeneroPelicula(GeneroPelicula generoPelicula) {
		getGeneroPeliculas().remove(generoPelicula);
		generoPelicula.setGenero(null);

		return generoPelicula;
	}

}