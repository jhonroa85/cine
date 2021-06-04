package com.demo.cine;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the sala_silla database table.
 * 
 */
@Entity
@Table(name="sala_silla")
@NamedQuery(name="SalaSilla.findAll", query="SELECT s FROM SalaSilla s")
public class SalaSilla implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_sala_silla")
	private int idSalaSilla;

	//bi-directional many-to-one association to ReservaSilla
	@OneToMany(mappedBy="salaSilla")
	private List<ReservaSilla> reservaSillas;

	//bi-directional many-to-one association to Sala
	@ManyToOne
	private Sala sala;

	//bi-directional many-to-one association to Silla
	@ManyToOne
	private Silla silla;

	public SalaSilla() {
	}

	public int getIdSalaSilla() {
		return this.idSalaSilla;
	}

	public void setIdSalaSilla(int idSalaSilla) {
		this.idSalaSilla = idSalaSilla;
	}

	public List<ReservaSilla> getReservaSillas() {
		return this.reservaSillas;
	}

	public void setReservaSillas(List<ReservaSilla> reservaSillas) {
		this.reservaSillas = reservaSillas;
	}

	public ReservaSilla addReservaSilla(ReservaSilla reservaSilla) {
		getReservaSillas().add(reservaSilla);
		reservaSilla.setSalaSilla(this);

		return reservaSilla;
	}

	public ReservaSilla removeReservaSilla(ReservaSilla reservaSilla) {
		getReservaSillas().remove(reservaSilla);
		reservaSilla.setSalaSilla(null);

		return reservaSilla;
	}

	public Sala getSala() {
		return this.sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public Silla getSilla() {
		return this.silla;
	}

	public void setSilla(Silla silla) {
		this.silla = silla;
	}

}