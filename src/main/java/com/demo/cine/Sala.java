package com.demo.cine;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the sala database table.
 * 
 */
@Entity
@NamedQuery(name="Sala.findAll", query="SELECT s FROM Sala s")
public class Sala implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_sala")
	private int idSala;

	@Column(name="cantidad_filas")
	private int cantidadFilas;

	@Column(name="cantidad_sillas")
	private int cantidadSillas;

	private String nombre;

	@Column(name="tipo_sala")
	private String tipoSala;

	//bi-directional many-to-one association to AgendarPelicula
	@OneToMany(mappedBy="sala")
	private List<AgendarPelicula> agendarPeliculas;

	//bi-directional many-to-one association to Sucursal
	@ManyToOne
	private Sucursal sucursal;

	//bi-directional many-to-one association to SalaSilla
	@OneToMany(mappedBy="sala")
	private List<SalaSilla> salaSillas;

	public Sala() {
	}

	public int getIdSala() {
		return this.idSala;
	}

	public void setIdSala(int idSala) {
		this.idSala = idSala;
	}

	public int getCantidadFilas() {
		return this.cantidadFilas;
	}

	public void setCantidadFilas(int cantidadFilas) {
		this.cantidadFilas = cantidadFilas;
	}

	public int getCantidadSillas() {
		return this.cantidadSillas;
	}

	public void setCantidadSillas(int cantidadSillas) {
		this.cantidadSillas = cantidadSillas;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipoSala() {
		return this.tipoSala;
	}

	public void setTipoSala(String tipoSala) {
		this.tipoSala = tipoSala;
	}

	public List<AgendarPelicula> getAgendarPeliculas() {
		return this.agendarPeliculas;
	}

	public void setAgendarPeliculas(List<AgendarPelicula> agendarPeliculas) {
		this.agendarPeliculas = agendarPeliculas;
	}

	public AgendarPelicula addAgendarPelicula(AgendarPelicula agendarPelicula) {
		getAgendarPeliculas().add(agendarPelicula);
		agendarPelicula.setSala(this);

		return agendarPelicula;
	}

	public AgendarPelicula removeAgendarPelicula(AgendarPelicula agendarPelicula) {
		getAgendarPeliculas().remove(agendarPelicula);
		agendarPelicula.setSala(null);

		return agendarPelicula;
	}

	public Sucursal getSucursal() {
		return this.sucursal;
	}

	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}

	public List<SalaSilla> getSalaSillas() {
		return this.salaSillas;
	}

	public void setSalaSillas(List<SalaSilla> salaSillas) {
		this.salaSillas = salaSillas;
	}

	public SalaSilla addSalaSilla(SalaSilla salaSilla) {
		getSalaSillas().add(salaSilla);
		salaSilla.setSala(this);

		return salaSilla;
	}

	public SalaSilla removeSalaSilla(SalaSilla salaSilla) {
		getSalaSillas().remove(salaSilla);
		salaSilla.setSala(null);

		return salaSilla;
	}

}