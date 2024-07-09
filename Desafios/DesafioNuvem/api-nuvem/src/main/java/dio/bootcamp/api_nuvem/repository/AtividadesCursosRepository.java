package dio.bootcamp.api_nuvem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dio.bootcamp.api_nuvem.model.AtividadesCursos;

@Repository
public interface AtividadesCursosRepository extends JpaRepository<AtividadesCursos, Long>{

    public AtividadesCursos findByTitulo(String titulo);

}
