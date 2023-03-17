package fr.jd.fitnessDev.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "SEANCE")
public class Seance {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(length = 50, nullable = false)
	private String nom;

	private byte[] image;
	private boolean active = false;

	@OneToMany(targetEntity=Exercice.class, mappedBy = "seance")
	private List<Exercice> lstExercice = new ArrayList<>();;
	
	@ManyToOne @JoinColumn(name="idUtilisateur")
	private Utilisateur utilisateur;

	
	//Constructor
	public Seance(long id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}


	//Getters & Setters
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public byte[] getImage() {
		return image;
	}


	public void setImage(byte[] image) {
		this.image = image;
	}


	public boolean isActive() {
		return active;
	}


	public void setActive(boolean active) {
		this.active = active;
	}


	public List<Exercice> getLstExercice() {
		return lstExercice;
	}


	public void setLstExercice(List<Exercice> lstExercice) {
		this.lstExercice = lstExercice;
	}


	public Utilisateur getUtilisateur() {
		return utilisateur;
	}


	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	

}
