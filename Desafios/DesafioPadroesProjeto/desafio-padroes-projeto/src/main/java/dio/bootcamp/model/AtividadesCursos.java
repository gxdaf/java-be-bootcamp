package dio.bootcamp.model;

import jakarta.persistence.*;

@Entity
public class AtividadesCursos {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String titulo;
    private String descricao;
    private Integer cargaHoraria;
    private final int XP_PADRAO = 10;

    public AtividadesCursos() {
    }

    public AtividadesCursos(String titulo, String descricao, int cargaHoraria) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.cargaHoraria = cargaHoraria;
    }

    public int calcularXP(){
        return XP_PADRAO * cargaHoraria;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }
    
    public String getDescricao() {
        return descricao;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }
}
