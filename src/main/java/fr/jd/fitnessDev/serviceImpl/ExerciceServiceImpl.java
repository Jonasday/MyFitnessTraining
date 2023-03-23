package fr.jd.fitnessDev.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.jd.fitnessDev.model.Exercice;
import fr.jd.fitnessDev.repository.ExerciceRepository;
import fr.jd.fitnessDev.service.ExerciceService;

@Service
public class ExerciceServiceImpl implements ExerciceService {

	@Autowired
    private final ExerciceRepository exerciceRepository;
    
    public ExerciceServiceImpl(ExerciceRepository exerciceRepository) {
        this.exerciceRepository = exerciceRepository;
    }

    @Override
    public Exercice create(Exercice exercice) {
        return exerciceRepository.save(exercice);
    }
    
    @Override
    public Exercice detail(Long id) {
    	return exerciceRepository.findById(id).get();
    }

    @Override
    public List<Exercice> read() {
        return exerciceRepository.findAll();
    }

    @Override
    public Exercice update(Long id, Exercice exercice) {
        return exerciceRepository.findById(id)
        .map(e-> {
            e.setNom(exercice.getNom());
            e.setMuscle(exercice.getMuscle());
            e.setImage(exercice.getImage());
            e.setPoids(exercice.getPoids());
            e.setSerie(exercice.getSerie());
            e.setRep(exercice.getRep());
            return exerciceRepository.save(e);
        }).orElseThrow(() -> new RuntimeException("Exercice non trouvé !"));
    }

    @Override
    public String delete(Long id) {
        exerciceRepository.deleteById(id);
        return "Exercice supprimé";
    }
    
}
