package dio.bootcamp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dio.bootcamp.model.Bootcamp;

@Repository
public interface BootcampRepository extends JpaRepository<Bootcamp, String>{

    public Bootcamp findByNome(String nome);

}
