package dio.bootcamp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dio.bootcamp.model.AtividadesCursos;
import dio.bootcamp.repository.AtividadesCursosRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class AtividadesCursosService {

    @Autowired
    private AtividadesCursosRepository repository;

    public AtividadesCursos save(AtividadesCursos atividadeCurso) {
        return repository.save(atividadeCurso);
    }

    public Optional<AtividadesCursos> findById(long id) {
        List<AtividadesCursos> ativCursos = repository.findAll();
        return ativCursos.stream()
                .filter(ac -> ac.getId().equals(id))
                .findFirst();
   
        
    }

    public AtividadesCursos findByTitulo(String titulo) {
            List<AtividadesCursos> ativCursos = repository.findAll();
        Optional<AtividadesCursos> match = ativCursos.stream()
                                                     .filter(ac -> ac.getTitulo().equals(titulo))
                                                 .findFirst();
   
        return match.orElseThrow(() -> new NoSuchElementException("No value present"));
    }

    public List<AtividadesCursos> findAll() {
        return repository.findAll();
    }

    public boolean deleteById(Long id) {
        Optional<AtividadesCursos> cursoOptional = repository.findById(id);
        if (cursoOptional.isPresent()) {
            repository.deleteById(id);
            return true;  // Deletion successful
        }
        return false;  // Entity with given ID not found, deletion failed
    }
    

    public long count() {
        return repository.count();
    }

    public Optional<Integer> calcularXPById(long id) {
        Optional<AtividadesCursos> atividadeCurso = repository.findById(id);
        return atividadeCurso.map(AtividadesCursos::calcularXP);
    }

}
