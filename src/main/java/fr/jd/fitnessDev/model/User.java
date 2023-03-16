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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "USER")
@Getter
@Setter
@NoArgsConstructor
public class User {
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

	@OneToMany(mappedBy = "user")
	private List<Plat> lstPlat = new ArrayList<>();

	@OneToMany(mappedBy = "user")
	private List<Seance> lstSeance = new ArrayList<>();

}
