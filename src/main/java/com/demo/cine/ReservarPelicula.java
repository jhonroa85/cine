package com.demo.cine;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the reservar_pelicula database table.
 * 
 */
@Entity
@Table(name="reservar_pelicula")
@NamedQuery(name="ReservarPelicula.findAll", query="SELECT r FROM ReservarPelicula r")
public class ReservarPelicula implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_reserva_pelicula")
	private int idReservaPelicula;

	private byte confimar;

	private Timestamp fehca;

	private String pago;

	//bi-directional many-to-one association to ReservaSilla
	@OneToMany(mappedBy="reservarPelicula")
	private List<ReservaSilla> reservaSillas;

	//bi-directional many-to-one association to AgendarPelicula
	@ManyToOne
	@JoinColumn(name="agendar_pelicula_id_agenda")
	private AgendarPelicula agendarPelicula;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	private Cliente cliente;

	public ReservarPelicula() {
	}

	public int getIdReservaPelicula() {
		return this.idReservaPelicula;
	}

	public void setIdReservaPelicula(int idReservaPelicula) {
		this.idReservaPelicula = idReservaPelicula;
	}

	public byte getConfimar() {
		return this.confimar;
	}

	public void setConfimar(byte confimar) {
		this.confimar = confimar;
	}

	public Timestamp getFehca() {
		return this.fehca;
	}

	public void setFehca(Timestamp fehca) {
		this.fehca = fehca;
	}

	public String getPago() {
		return this.pago;
	}

	public void setPago(String pago) {
		this.pago = pago;
	}

	public List<ReservaSilla> getReservaSillas() {
		return this.reservaSillas;
	}

	public void setReservaSillas(List<ReservaSilla> reservaSillas) {
		this.reservaSillas = reservaSillas;
	}

	public ReservaSilla addReservaSilla(ReservaSilla reservaSilla) {
		getReservaSillas().add(reservaSilla);
		reservaSilla.setReservarPelicula(this);

		return reservaSilla;
	}

	public ReservaSilla removeReservaSilla(ReservaSilla reservaSilla) {
		getReservaSillas().remove(reservaSilla);
		reservaSilla.setReservarPelicula(null);

		return reservaSilla;
	}

	public AgendarPelicula getAgendarPelicula() {
		return this.agendarPelicula;
	}

	public void setAgendarPelicula(AgendarPelicula agendarPelicula) {
		this.agendarPelicula = agendarPelicula;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}