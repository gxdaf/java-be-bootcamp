package dio.bootcamp.api_nuvem.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import dio.bootcamp.api_nuvem.model.Bootcamp;
import dio.bootcamp.api_nuvem.service.BootcampService;

@RestController
@RequestMapping("/bootcamp")
public class BootcampController {

    @Autowired
    private BootcampService service;

    @GetMapping
    public ResponseEntity<List<Bootcamp>> getAllBootcamps() {
        List<Bootcamp> bootcamps = service.findAll();
        return ResponseEntity.ok(bootcamps);
    }

    @GetMapping("/{nome}")
    public ResponseEntity<Optional<Bootcamp>> getBootcampByNome(@PathVariable String nome) {
        Optional<Bootcamp> bootcamp = Optional.of(service.findById(nome));
        if (bootcamp != null) {
            return ResponseEntity.ok(bootcamp);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/count")
    public ResponseEntity<Long> mostrarContagem() {
        return ResponseEntity.ok(service.count());
    }

    @PostMapping
    public ResponseEntity<?> createBootcamp(@RequestBody Bootcamp bootcamp) {
        ResponseEntity<?> bs = service.saveBootcamp(bootcamp);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{nome}").buildAndExpand(bootcamp.getNome()).toUri();
        return ResponseEntity.created(location).body(bs);
    }

    @DeleteMapping("/{nome}")
    public ResponseEntity<Void> deleteBootcamp(@PathVariable String nome) {
        boolean deleted = service.deleteById(nome);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
