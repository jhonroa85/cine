package com.demo.cine;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the silla database table.
 * 
 */
@Entity
@NamedQuery(name="Silla.findAll", query="SELECT s FROM Silla s")
public class Silla implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_silla")
	private int idSilla;

	private String nombre;

	//bi-directional many-to-one association to SalaSilla
	@OneToMany(mappedBy="silla")
	private List<SalaSilla> salaSillas;

	public Silla() {
	}

	public int getIdSilla() {
		return this.idSilla;
	}

	public void setIdSilla(int idSilla) {
		this.idSilla = idSilla;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<SalaSilla> getSalaSillas() {
		return this.salaSillas;
	}

	public void setSalaSillas(List<SalaSilla> salaSillas) {
		this.salaSillas = salaSillas;
	}

	public SalaSilla addSalaSilla(SalaSilla salaSilla) {
		getSalaSillas().add(salaSilla);
		salaSilla.setSilla(this);

		return salaSilla;
	}

	public SalaSilla removeSalaSilla(SalaSilla salaSilla) {
		getSalaSillas().remove(salaSilla);
		salaSilla.setSilla(null);

		return salaSilla;
	}

}