package dio.bootcamp.api_nuvem.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

@Entity(name="tb_bootcamp")
public class Bootcamp {

    @Id
    private String nome;
    @Column(nullable=false)
    private LocalDate dataInicial;
    @Column(nullable=false)
    private LocalDate dataFinal;
    @Column(nullable=false)
    @ManyToMany(fetch= FetchType.EAGER)
    private Set<AtividadesCursos> ativCursos = new HashSet<>();

    public Bootcamp(){}

    public Bootcamp(LocalDate dataInicial, LocalDate dataFinal, String nome, Set<AtividadesCursos> ativCursos) {
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        this.nome = nome;
        this.ativCursos = ativCursos;
    }

    public LocalDate getDataInicial() {
        return dataInicial;
    }

    public LocalDate getDataFinal() {
        return dataFinal;
    }

    public String getNome() {
        return nome;
    }

    public Set<AtividadesCursos> getAtivCursos() {
        return ativCursos;
    }

    public void setAtivCursos(Set<AtividadesCursos> ativCursos) {
        this.ativCursos = ativCursos;
    }

}
