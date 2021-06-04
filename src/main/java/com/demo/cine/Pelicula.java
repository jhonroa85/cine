package com.demo.cine;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the pelicula database table.
 * 
 */
@Entity
@NamedQuery(name="Pelicula.findAll", query="SELECT p FROM Pelicula p")
public class Pelicula implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_pelicula")
	private int idPelicula;

	@Temporal(TemporalType.DATE)
	private Date duracion;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_baja")
	private Date fechaBaja;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_estreno")
	private Date fechaEstreno;

	private String formato;

	@Lob
	@Column(name="imagen_portada")
	private byte[] imagenPortada;

	@Column(name="nombre_original")
	private String nombreOriginal;

	@Column(name="nombre_traducido")
	private String nombreTraducido;

	private String sinopsis;

	//bi-directional many-to-one association to AgendarPelicula
	@OneToMany(mappedBy="pelicula")
	private List<AgendarPelicula> agendarPeliculas;

	//bi-directional many-to-one association to GeneroPelicula
	@OneToMany(mappedBy="pelicula")
	private List<GeneroPelicula> generoPeliculas;

	//bi-directional many-to-one association to PeliculaSucursal
	@OneToMany(mappedBy="pelicula")
	private List<PeliculaSucursal> peliculaSucursals;

	public Pelicula() {
	}

	public int getIdPelicula() {
		return this.idPelicula;
	}

	public void setIdPelicula(int idPelicula) {
		this.idPelicula = idPelicula;
	}

	public Date getDuracion() {
		return this.duracion;
	}

	public void setDuracion(Date duracion) {
		this.duracion = duracion;
	}

	public Date getFechaBaja() {
		return this.fechaBaja;
	}

	public void setFechaBaja(Date fechaBaja) {
		this.fechaBaja = fechaBaja;
	}

	public Date getFechaEstreno() {
		return this.fechaEstreno;
	}

	public void setFechaEstreno(Date fechaEstreno) {
		this.fechaEstreno = fechaEstreno;
	}

	public String getFormato() {
		return this.formato;
	}

	public void setFormato(String formato) {
		this.formato = formato;
	}

	public byte[] getImagenPortada() {
		return this.imagenPortada;
	}

	public void setImagenPortada(byte[] imagenPortada) {
		this.imagenPortada = imagenPortada;
	}

	public String getNombreOriginal() {
		return this.nombreOriginal;
	}

	public void setNombreOriginal(String nombreOriginal) {
		this.nombreOriginal = nombreOriginal;
	}

	public String getNombreTraducido() {
		return this.nombreTraducido;
	}

	public void setNombreTraducido(String nombreTraducido) {
		this.nombreTraducido = nombreTraducido;
	}

	public String getSinopsis() {
		return this.sinopsis;
	}

	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}

	public List<AgendarPelicula> getAgendarPeliculas() {
		return this.agendarPeliculas;
	}

	public void setAgendarPeliculas(List<AgendarPelicula> agendarPeliculas) {
		this.agendarPeliculas = agendarPeliculas;
	}

	public AgendarPelicula addAgendarPelicula(AgendarPelicula agendarPelicula) {
		getAgendarPeliculas().add(agendarPelicula);
		agendarPelicula.setPelicula(this);

		return agendarPelicula;
	}

	public AgendarPelicula removeAgendarPelicula(AgendarPelicula agendarPelicula) {
		getAgendarPeliculas().remove(agendarPelicula);
		agendarPelicula.setPelicula(null);

		return agendarPelicula;
	}

	public List<GeneroPelicula> getGeneroPeliculas() {
		return this.generoPeliculas;
	}

	public void setGeneroPeliculas(List<GeneroPelicula> generoPeliculas) {
		this.generoPeliculas = generoPeliculas;
	}

	public GeneroPelicula addGeneroPelicula(GeneroPelicula generoPelicula) {
		getGeneroPeliculas().add(generoPelicula);
		generoPelicula.setPelicula(this);

		return generoPelicula;
	}

	public GeneroPelicula removeGeneroPelicula(GeneroPelicula generoPelicula) {
		getGeneroPeliculas().remove(generoPelicula);
		generoPelicula.setPelicula(null);

		return generoPelicula;
	}

	public List<PeliculaSucursal> getPeliculaSucursals() {
		return this.peliculaSucursals;
	}

	public void setPeliculaSucursals(List<PeliculaSucursal> peliculaSucursals) {
		this.peliculaSucursals = peliculaSucursals;
	}

	public PeliculaSucursal addPeliculaSucursal(PeliculaSucursal peliculaSucursal) {
		getPeliculaSucursals().add(peliculaSucursal);
		peliculaSucursal.setPelicula(this);

		return peliculaSucursal;
	}

	public PeliculaSucursal removePeliculaSucursal(PeliculaSucursal peliculaSucursal) {
		getPeliculaSucursals().remove(peliculaSucursal);
		peliculaSucursal.setPelicula(null);

		return peliculaSucursal;
	}

}