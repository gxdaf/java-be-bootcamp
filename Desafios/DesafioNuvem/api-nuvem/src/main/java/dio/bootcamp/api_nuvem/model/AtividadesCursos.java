package dio.bootcamp.api_nuvem.model;

import jakarta.persistence.*;

@Entity(name="tb_ativ_curso")
public class AtividadesCursos {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique=true, nullable=false)
    private String titulo;
    private String descricao;
    @Column(nullable=false)
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
