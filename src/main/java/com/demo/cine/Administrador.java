package com.demo.cine;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the administrador database table.
 * 
 */
@Entity
@NamedQuery(name="Administrador.findAll", query="SELECT a FROM Administrador a")
public class Administrador implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_administrador")
	private int idAdministrador;

	private String nombre;

	//bi-directional many-to-one association to AgendarPelicula
	@OneToMany(mappedBy="administrador")
	private List<AgendarPelicula> agendarPeliculas;

	//bi-directional many-to-one association to Sucursal
	@OneToMany(mappedBy="administrador")
	private List<Sucursal> sucursals;

	public Administrador() {
	}

	public int getIdAdministrador() {
		return this.idAdministrador;
	}

	public void setIdAdministrador(int idAdministrador) {
		this.idAdministrador = idAdministrador;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<AgendarPelicula> getAgendarPeliculas() {
		return this.agendarPeliculas;
	}

	public void setAgendarPeliculas(List<AgendarPelicula> agendarPeliculas) {
		this.agendarPeliculas = agendarPeliculas;
	}

	public AgendarPelicula addAgendarPelicula(AgendarPelicula agendarPelicula) {
		getAgendarPeliculas().add(agendarPelicula);
		agendarPelicula.setAdministrador(this);

		return agendarPelicula;
	}

	public AgendarPelicula removeAgendarPelicula(AgendarPelicula agendarPelicula) {
		getAgendarPeliculas().remove(agendarPelicula);
		agendarPelicula.setAdministrador(null);

		return agendarPelicula;
	}

	public List<Sucursal> getSucursals() {
		return this.sucursals;
	}

	public void setSucursals(List<Sucursal> sucursals) {
		this.sucursals = sucursals;
	}

	public Sucursal addSucursal(Sucursal sucursal) {
		getSucursals().add(sucursal);
		sucursal.setAdministrador(this);

		return sucursal;
	}

	public Sucursal removeSucursal(Sucursal sucursal) {
		getSucursals().remove(sucursal);
		sucursal.setAdministrador(null);

		return sucursal;
	}

}