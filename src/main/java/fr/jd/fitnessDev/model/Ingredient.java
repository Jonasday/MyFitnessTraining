package fr.jd.fitnessDev.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "INGREDIENT")
public class Ingredient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(length = 50, nullable = false)
	private String nom;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Categorie categorie;
	
	@ManyToOne @JoinColumn(name="idPlat")
	private Plat plat;

	private float kcal;
	private float glucide;
	private float sucre;
	private float lipide;
	private float acideGras;
	private float fibre;
	private float proteine;
	private float sel;
	
	//Constructor
	public Ingredient(long id, String nom) {
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

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public Plat getPlat() {
		return plat;
	}

	public void setPlat(Plat plat) {
		this.plat = plat;
	}

	public float getKcal() {
		return kcal;
	}

	public void setKcal(float kcal) {
		this.kcal = kcal;
	}

	public float getGlucide() {
		return glucide;
	}

	public void setGlucide(float glucide) {
		this.glucide = glucide;
	}

	public float getSucre() {
		return sucre;
	}

	public void setSucre(float sucre) {
		this.sucre = sucre;
	}

	public float getLipide() {
		return lipide;
	}

	public void setLipide(float lipide) {
		this.lipide = lipide;
	}

	public float getAcideGras() {
		return acideGras;
	}

	public void setAcideGras(float acideGras) {
		this.acideGras = acideGras;
	}

	public float getFibre() {
		return fibre;
	}

	public void setFibre(float fibre) {
		this.fibre = fibre;
	}

	public float getProteine() {
		return proteine;
	}

	public void setProteine(float proteine) {
		this.proteine = proteine;
	}

	public float getSel() {
		return sel;
	}

	public void setSel(float sel) {
		this.sel = sel;
	}
	
	
}