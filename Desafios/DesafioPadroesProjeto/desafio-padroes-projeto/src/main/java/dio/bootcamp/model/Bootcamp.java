package dio.bootcamp.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

@Entity
public class Bootcamp {

    @Id
    private String nome;
    private LocalDate dataInicial;
    private LocalDate dataFinal;
    @ManyToMany
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
