package dio.bootcamp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import dio.bootcamp.model.Bootcamp;
import dio.bootcamp.service.BootcampService;

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
    public ResponseEntity<Bootcamp> getBootcampByNome(@PathVariable String nome) {
        Bootcamp bootcamp = service.findByNome(nome);
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
    public ResponseEntity<Void> createBootcamp(@RequestBody Bootcamp bootcamp) {
        service.save(bootcamp);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{nome}")
    public ResponseEntity<Void> deleteBootcamp(@PathVariable String nome) {
        boolean deleted = service.deleteByNome(nome);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
