package fr.jd.fitnessDev.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "UTILISATEUR")
public class Utilisateur {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(length = 50, nullable = false)
	private String nom;

	@Column(length = 50, nullable = false)
	private String prenom;

	private Genre genre;
	private int age;
	private int taille;
	private int poids;
	private int apportJournalier;

	@OneToMany(targetEntity=Plat.class, mappedBy = "utilisateur")
	private List<Plat> lstPlat = new ArrayList<>();

	@OneToMany(targetEntity=Seance.class, mappedBy = "utilisateur")
	private List<Seance> lstSeance = new ArrayList<>();


	//Constructor
	public Utilisateur(long id, String nom) {
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


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public Genre getGenre() {
		return genre;
	}


	public void setGenre(Genre genre) {
		this.genre = genre;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public int getTaille() {
		return taille;
	}


	public void setTaille(int taille) {
		this.taille = taille;
	}


	public int getPoids() {
		return poids;
	}


	public void setPoids(int poids) {
		this.poids = poids;
	}


	public int getApportJournalier() {
		return apportJournalier;
	}


	public void setApportJournalier(int apportJournalier) {
		this.apportJournalier = apportJournalier;
	}


	public List<Plat> getLstPlat() {
		return lstPlat;
	}


	public void setLstPlat(List<Plat> lstPlat) {
		this.lstPlat = lstPlat;
	}


	public List<Seance> getLstSeance() {
		return lstSeance;
	}


	public void setLstSeance(List<Seance> lstSeance) {
		this.lstSeance = lstSeance;
	}
	
	
}
