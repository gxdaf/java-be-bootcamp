package dio.bootcamp.api_nuvem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dio.bootcamp.api_nuvem.model.AtividadesCursos;
import dio.bootcamp.api_nuvem.repository.AtividadesCursosRepository;
import dio.bootcamp.api_nuvem.service.impl.CommonService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class AtividadesCursosService implements CommonService<AtividadesCursos> {

    @Autowired
    private AtividadesCursosRepository repository;

    @Override
    public AtividadesCursos save(AtividadesCursos atividadeCurso) {
        return repository.save(atividadeCurso);
    }

    public AtividadesCursos findByTitulo(String titulo) {
        List<AtividadesCursos> ativCursos = repository.findAll();
        Optional<AtividadesCursos> match = ativCursos.stream()
                                                     .filter(ac -> ac.getTitulo().equals(titulo))
                                                     .findFirst();
        return match.orElseThrow(() -> new NoSuchElementException());
    }

    @Override
    public List<AtividadesCursos> findAll() {
        return repository.findAll();
    }

    @Override
    public long count() {
        return repository.count();
    }

    public Optional<Integer> calcularXPById(long id) {
        Optional<AtividadesCursos> atividadeCurso = repository.findById(id);
        return atividadeCurso.map(AtividadesCursos::calcularXP);
    }

    @Override
    public AtividadesCursos findById(Long id) {
        List<AtividadesCursos> ativCursos = repository.findAll();
        Optional<AtividadesCursos> match = ativCursos.stream()
        .filter(ac -> ac.getId().equals(id))
        .findFirst();
        return match.orElseThrow(() -> new NoSuchElementException());
        
    }

    @Override
    public boolean deleteById(Long id) {
        Optional<AtividadesCursos> cursoOptional = repository.findById(id);
        if (cursoOptional.isPresent()) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
