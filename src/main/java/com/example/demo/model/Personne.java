package com.example.demo.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "role")
public class Personne {
	@Id
	@Column(length = 255)
	private String mat;
	@Column(length = 255)
	private String nom;

	/*
	 * @ManyToOne
	 * private Absence absence;
	 */

	@OneToMany(mappedBy = "personne")
	List<Absence> absence;

	public String getMat() {
		return mat;
	}

	public void setMat(String mat) {
		this.mat = mat;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Personne() {
		super();
	}

	@Override
	public String toString() {
		return "Personne [absence=" + absence + ", mat=" + mat + ", nom=" + nom + "]";
	}

}
