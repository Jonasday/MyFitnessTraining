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
@Table(name = "EXERCICE")
@Getter
@Setter
@NoArgsConstructor
public class Exercice {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(length = 50, nullable = false)
	private String nom;

	@Column(length = 50)
	private String muscle;

	private byte[] image;
	private float poids = 0;
	private int serie = 4;
	private int rep = 10;

}
