package com.demo.cine;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the genero_pelicula database table.
 * 
 */
@Entity
@Table(name="genero_pelicula")
@NamedQuery(name="GeneroPelicula.findAll", query="SELECT g FROM GeneroPelicula g")
public class GeneroPelicula implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_genero_pelicula")
	private int idGeneroPelicula;

	//bi-directional many-to-one association to Genero
	@ManyToOne
	private Genero genero;

	//bi-directional many-to-one association to Pelicula
	@ManyToOne
	private Pelicula pelicula;

	public GeneroPelicula() {
	}

	public int getIdGeneroPelicula() {
		return this.idGeneroPelicula;
	}

	public void setIdGeneroPelicula(int idGeneroPelicula) {
		this.idGeneroPelicula = idGeneroPelicula;
	}

	public Genero getGenero() {
		return this.genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public Pelicula getPelicula() {
		return this.pelicula;
	}

	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}

}