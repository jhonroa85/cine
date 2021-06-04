package com.demo.cine;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the reserva_silla database table.
 * 
 */
@Entity
@Table(name="reserva_silla")
@NamedQuery(name="ReservaSilla.findAll", query="SELECT r FROM ReservaSilla r")
public class ReservaSilla implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_reserva_silla")
	private int idReservaSilla;

	//bi-directional many-to-one association to ReservarPelicula
	@ManyToOne
	@JoinColumn(name="reservar_pelicula_id_reserva_pelicula")
	private ReservarPelicula reservarPelicula;

	//bi-directional many-to-one association to SalaSilla
	@ManyToOne
	@JoinColumn(name="sala_silla_id_sala_silla")
	private SalaSilla salaSilla;

	public ReservaSilla() {
	}

	public int getIdReservaSilla() {
		return this.idReservaSilla;
	}

	public void setIdReservaSilla(int idReservaSilla) {
		this.idReservaSilla = idReservaSilla;
	}

	public ReservarPelicula getReservarPelicula() {
		return this.reservarPelicula;
	}

	public void setReservarPelicula(ReservarPelicula reservarPelicula) {
		this.reservarPelicula = reservarPelicula;
	}

	public SalaSilla getSalaSilla() {
		return this.salaSilla;
	}

	public void setSalaSilla(SalaSilla salaSilla) {
		this.salaSilla = salaSilla;
	}

}