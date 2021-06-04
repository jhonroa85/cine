package com.demo.cine;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the agendar_pelicula database table.
 * 
 */
@Entity
@Table(name="agendar_pelicula")
@NamedQuery(name="AgendarPelicula.findAll", query="SELECT a FROM AgendarPelicula a")
public class AgendarPelicula implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_agenda")
	private int idAgenda;

	@Temporal(TemporalType.DATE)
	private Date fehca;

	@Temporal(TemporalType.DATE)
	private Date hora;

	//bi-directional many-to-one association to Administrador
	@ManyToOne
	private Administrador administrador;

	//bi-directional many-to-one association to Pelicula
	@ManyToOne
	private Pelicula pelicula;

	//bi-directional many-to-one association to Sala
	@ManyToOne
	private Sala sala;

	//bi-directional many-to-one association to ReservarPelicula
	@OneToMany(mappedBy="agendarPelicula")
	private List<ReservarPelicula> reservarPeliculas;

	public AgendarPelicula() {
	}

	public int getIdAgenda() {
		return this.idAgenda;
	}

	public void setIdAgenda(int idAgenda) {
		this.idAgenda = idAgenda;
	}

	public Date getFehca() {
		return this.fehca;
	}

	public void setFehca(Date fehca) {
		this.fehca = fehca;
	}

	public Date getHora() {
		return this.hora;
	}

	public void setHora(Date hora) {
		this.hora = hora;
	}

	public Administrador getAdministrador() {
		return this.administrador;
	}

	public void setAdministrador(Administrador administrador) {
		this.administrador = administrador;
	}

	public Pelicula getPelicula() {
		return this.pelicula;
	}

	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}

	public Sala getSala() {
		return this.sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public List<ReservarPelicula> getReservarPeliculas() {
		return this.reservarPeliculas;
	}

	public void setReservarPeliculas(List<ReservarPelicula> reservarPeliculas) {
		this.reservarPeliculas = reservarPeliculas;
	}

	public ReservarPelicula addReservarPelicula(ReservarPelicula reservarPelicula) {
		getReservarPeliculas().add(reservarPelicula);
		reservarPelicula.setAgendarPelicula(this);

		return reservarPelicula;
	}

	public ReservarPelicula removeReservarPelicula(ReservarPelicula reservarPelicula) {
		getReservarPeliculas().remove(reservarPelicula);
		reservarPelicula.setAgendarPelicula(null);

		return reservarPelicula;
	}

}