package fr.jd.fitnessDev.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import fr.jd.fitnessDev.model.Exercice;
import fr.jd.fitnessDev.service.ExerciceService;


@Controller
public class ExerciceController {
	
	@Autowired
	private ExerciceService exerciceService;
	
	@GetMapping("/mes-exercices")
	public ModelAndView showExercices() {
		ModelAndView mav = new ModelAndView("mesExercices"); 
		List<Exercice> listeExercices = exerciceService.read();
		mav.addObject("allExercices", listeExercices);
		return mav;
	}
	
	@GetMapping("/creer-exercice")
	public ModelAndView createExercice() {
		ModelAndView mav = new ModelAndView("creerExercice");
		Exercice newExercice = new Exercice();
		mav.addObject("exercice", newExercice);
		return mav;
	}
	
	@PostMapping("/save-exercice")
	public String addExercice(@ModelAttribute Exercice exercice) {
		exerciceService.create(exercice);
		return "redirect:/mes-exercices";
	}
	
	@GetMapping("/details-exercice")
	public ModelAndView exerciceDetail(@RequestParam Long id) {
		ModelAndView mav = new ModelAndView("detailExercice");
		Exercice exercice = exerciceService.detail(id);
		mav.addObject("exercice", exercice);
		return mav;
	}
	
	@GetMapping("exercice-modification")
	public ModelAndView modifierExercice(@RequestParam Long id) {
		ModelAndView mav = new ModelAndView("modifierExercice");
		Exercice exercice = exerciceService.detail(id);
		mav.addObject("exercice", exercice);
		return mav;
	}
	
	@PostMapping("modifier-exercice")
	public String updateExercice(@RequestParam Long id, @ModelAttribute Exercice exercice) {
		exerciceService.update(id, exercice);
		return "redirect:/mes-exercices";
	}
	
	//ou /////////////////////////////////////////////////// ????
	
	/*@PutMapping("modifier-exercice/{id}")
	public String updateExercice(@PathVariable Long id, @ModelAttribute("exercice") Exercice exercice) {
	    exerciceService.update(id, exercice);
	    return "redirect:/mes-exercices";
	}*/
	
	@GetMapping("/supprimer-exercice")
	public String deleteExercice(@RequestParam Long id) {
		exerciceService.delete(id);
		return "redirect:/mes-exercices";
	}
}
