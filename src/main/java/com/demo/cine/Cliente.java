package com.demo.cine;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cliente database table.
 * 
 */
@Entity
@NamedQuery(name="Cliente.findAll", query="SELECT c FROM Cliente c")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_cliente")
	private int idCliente;

	private String nombre;

	//bi-directional many-to-one association to ReservarPelicula
	@OneToMany(mappedBy="cliente")
	private List<ReservarPelicula> reservarPeliculas;

	public Cliente() {
	}

	public int getIdCliente() {
		return this.idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<ReservarPelicula> getReservarPeliculas() {
		return this.reservarPeliculas;
	}

	public void setReservarPeliculas(List<ReservarPelicula> reservarPeliculas) {
		this.reservarPeliculas = reservarPeliculas;
	}

	public ReservarPelicula addReservarPelicula(ReservarPelicula reservarPelicula) {
		getReservarPeliculas().add(reservarPelicula);
		reservarPelicula.setCliente(this);

		return reservarPelicula;
	}

	public ReservarPelicula removeReservarPelicula(ReservarPelicula reservarPelicula) {
		getReservarPeliculas().remove(reservarPelicula);
		reservarPelicula.setCliente(null);

		return reservarPelicula;
	}

}