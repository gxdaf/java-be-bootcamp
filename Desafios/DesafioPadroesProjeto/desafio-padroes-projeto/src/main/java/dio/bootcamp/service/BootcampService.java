package dio.bootcamp.service;

import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import dio.bootcamp.model.AtividadesCursos;
import dio.bootcamp.model.Bootcamp;
import dio.bootcamp.repository.BootcampRepository;

@Service
public class BootcampService {

    @Autowired
    private BootcampRepository repository;

    @Autowired
    private AtividadesCursosService ativCursosService; 

    public ResponseEntity<?> save(Bootcamp bootcamp) {
        try {
            
            Set<AtividadesCursos> ativCursos = new HashSet<>();
            for (AtividadesCursos atividadesCursos : bootcamp.getAtivCursos()) {
                if (atividadesCursos.getId() == null) {
                    ativCursosService.save(atividadesCursos);
                }
                ativCursos.add(atividadesCursos);
            }

            bootcamp.setAtivCursos(ativCursos);

            repository.save(bootcamp);

            return ResponseEntity.ok("Bootcamp created successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.getMessage());
        }
    }

    public Bootcamp findByNome(String nome) {
        List<Bootcamp> bootcamp = repository.findAll();
        Optional<Bootcamp> match = bootcamp.stream()
                                                     .filter(ac -> ac.getNome().equals(nome))
                                                 .findFirst();
   
        return match.orElseThrow(() -> new NoSuchElementException());
    }

    public List<Bootcamp> findAll() {
        return repository.findAll();
    }

    public boolean deleteByNome(String nome) {
        Bootcamp bootcamp = repository.findByNome(nome);
        if (bootcamp != null) {
            repository.delete(bootcamp);
            return true;
        }
        return false;
    }

    public long count() {
        return repository.count();
    }
}

