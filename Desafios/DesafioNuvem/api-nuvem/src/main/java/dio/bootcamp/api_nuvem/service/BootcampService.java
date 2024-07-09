package dio.bootcamp.api_nuvem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import dio.bootcamp.api_nuvem.model.AtividadesCursos;
import dio.bootcamp.api_nuvem.model.Bootcamp;
import dio.bootcamp.api_nuvem.repository.BootcampRepository;
import dio.bootcamp.api_nuvem.service.impl.CommonService;

import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;

@Service
public class BootcampService implements CommonService<Bootcamp> {

    @Autowired
    private BootcampRepository repository;

    @Autowired
    private AtividadesCursosService ativCursosService;

    public ResponseEntity<?> saveBootcamp(Bootcamp bootcamp) {
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

            return ResponseEntity.ok("Bootcamp criado.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.getMessage());
        }
    }

    @Override
    public Bootcamp findById(String nome) {
        List<Bootcamp> bootcamp = repository.findAll();
        Optional<Bootcamp> match =  bootcamp.stream()
        .filter(bc -> bc.getNome().equals(nome))
        .findFirst();
        return match.orElseThrow(() -> new NoSuchElementException());
        
    }

    @Override
    public List<Bootcamp> findAll() {
        return repository.findAll();
    }

    @Override
    public boolean deleteById(String nome) {
        Bootcamp bootcamp = repository.findByNome(nome);
        if (bootcamp != null) {
            repository.delete(bootcamp);
            return true;
        }
        return false;
    }

    @Override
    public long count() {
        return repository.count();
    }

}
