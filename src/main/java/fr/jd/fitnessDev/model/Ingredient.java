package fr.jd.fitnessDev.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "INGREDIENT")
@Getter
@Setter
@NoArgsConstructor
public class Ingredient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(length = 50, nullable = false)
	private String nom;

	@Column(nullable = false)
	private Categorie categorie;

	private float kcal;
	private float glucide;
	private float sucre;
	private float lipide;
	private float acideGras;
	private float fibre;
	private float proteine;
	private float sel;
}