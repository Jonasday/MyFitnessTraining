package fr.jd.fitnessDev.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

import fr.jd.fitnessDev.service.SeanceService;
import fr.jd.fitnessDev.service.UtilisateurService;

@Controller
public class SeanceController {
	
	private SeanceService seanceService;
	private UtilisateurService utilisateurService;
	
	@GetMapping("/mes_seances")
    public String readSeances(){
        return "mesSeances";
    } 
	
	@GetMapping("/creer_seance")
    public String createSeance(){
        return "creerSeance";
    }
	
}
