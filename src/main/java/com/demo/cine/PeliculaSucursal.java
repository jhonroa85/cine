package com.demo.cine;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the pelicula_sucursal database table.
 * 
 */
@Entity
@Table(name="pelicula_sucursal")
@NamedQuery(name="PeliculaSucursal.findAll", query="SELECT p FROM PeliculaSucursal p")
public class PeliculaSucursal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_pelicula_sucursal")
	private int idPeliculaSucursal;

	//bi-directional many-to-one association to Pelicula
	@ManyToOne
	private Pelicula pelicula;

	//bi-directional many-to-one association to Sucursal
	@ManyToOne
	private Sucursal sucursal;

	public PeliculaSucursal() {
	}

	public int getIdPeliculaSucursal() {
		return this.idPeliculaSucursal;
	}

	public void setIdPeliculaSucursal(int idPeliculaSucursal) {
		this.idPeliculaSucursal = idPeliculaSucursal;
	}

	public Pelicula getPelicula() {
		return this.pelicula;
	}

	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}

	public Sucursal getSucursal() {
		return this.sucursal;
	}

	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}

}