package dio.bootcamp.api_nuvem.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import dio.bootcamp.api_nuvem.model.AtividadesCursos;
import dio.bootcamp.api_nuvem.service.AtividadesCursosService;

@RestController
@RequestMapping("/ativCursos")
public class AtividadesCursosController {

    @Autowired
    private AtividadesCursosService service;

    @GetMapping
    public ResponseEntity<List<AtividadesCursos>> buscarCursosExistentes() {
        List<AtividadesCursos> cursos = service.findAll();
        return ResponseEntity.ok(cursos);
    }
    
    @GetMapping("/count")
    public ResponseEntity<Long> mostrarContagem() {
        return ResponseEntity.ok(service.count());
    }

    @GetMapping("/titulo/{titulo}")
    public ResponseEntity<AtividadesCursos> buscarCursoPorTitulo(@PathVariable String titulo) {
        AtividadesCursos curso = service.findByTitulo(titulo);
        if (curso != null) {
            return ResponseEntity.ok(curso);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<AtividadesCursos> buscarCursoPorId(@PathVariable Long id) {
        Optional<AtividadesCursos> curso = Optional.of(service.findById(id));
        return curso.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/calcularXp/{id}")
    public ResponseEntity<Integer> calcularXpPorId(@PathVariable Long id) {
        Optional<Integer> xp = service.calcularXPById(id);
        return xp.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<AtividadesCursos> adicionarAtivCurso(@RequestBody AtividadesCursos ativCurso) {
        AtividadesCursos acs = service.save(ativCurso);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(ativCurso.getId()).toUri();
        return ResponseEntity.created(location).body(acs);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirAtivCurso(@PathVariable Long id) {
        boolean deleted = service.deleteById(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
