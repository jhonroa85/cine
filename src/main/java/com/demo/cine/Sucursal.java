package com.demo.cine;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the sucursal database table.
 * 
 */
@Entity
@NamedQuery(name="Sucursal.findAll", query="SELECT s FROM Sucursal s")
public class Sucursal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_sucursal")
	private int idSucursal;

	private String direccion;

	private String nombre;

	//bi-directional many-to-one association to PeliculaSucursal
	@OneToMany(mappedBy="sucursal")
	private List<PeliculaSucursal> peliculaSucursals;

	//bi-directional many-to-one association to Sala
	@OneToMany(mappedBy="sucursal")
	private List<Sala> salas;

	//bi-directional many-to-one association to Administrador
	@ManyToOne
	private Administrador administrador;

	//bi-directional many-to-one association to Ciudad
	@ManyToOne
	private Ciudad ciudad;

	public Sucursal() {
	}

	public int getIdSucursal() {
		return this.idSucursal;
	}

	public void setIdSucursal(int idSucursal) {
		this.idSucursal = idSucursal;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<PeliculaSucursal> getPeliculaSucursals() {
		return this.peliculaSucursals;
	}

	public void setPeliculaSucursals(List<PeliculaSucursal> peliculaSucursals) {
		this.peliculaSucursals = peliculaSucursals;
	}

	public PeliculaSucursal addPeliculaSucursal(PeliculaSucursal peliculaSucursal) {
		getPeliculaSucursals().add(peliculaSucursal);
		peliculaSucursal.setSucursal(this);

		return peliculaSucursal;
	}

	public PeliculaSucursal removePeliculaSucursal(PeliculaSucursal peliculaSucursal) {
		getPeliculaSucursals().remove(peliculaSucursal);
		peliculaSucursal.setSucursal(null);

		return peliculaSucursal;
	}

	public List<Sala> getSalas() {
		return this.salas;
	}

	public void setSalas(List<Sala> salas) {
		this.salas = salas;
	}

	public Sala addSala(Sala sala) {
		getSalas().add(sala);
		sala.setSucursal(this);

		return sala;
	}

	public Sala removeSala(Sala sala) {
		getSalas().remove(sala);
		sala.setSucursal(null);

		return sala;
	}

	public Administrador getAdministrador() {
		return this.administrador;
	}

	public void setAdministrador(Administrador administrador) {
		this.administrador = administrador;
	}

	public Ciudad getCiudad() {
		return this.ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}

}