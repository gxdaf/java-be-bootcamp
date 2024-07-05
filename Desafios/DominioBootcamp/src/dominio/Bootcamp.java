package dominio;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Bootcamp {
    private LocalDate dataInicial;
    private LocalDate dataFinal;
    private String nome;
    private String descricao;
    private Set<Devs> devs = new HashSet<>();
    private Set<AtividadesCursos> ativCursos = new HashSet<>();
    private Set<Mentorias> mentorias = new HashSet<>();

    public Bootcamp(LocalDate dataInicial, LocalDate dataFinal, String nome, String descricao, Set<AtividadesCursos> ativCursos,
            Set<Mentorias> mentorias) {
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        this.nome = nome;
        this.descricao = descricao;
        this.ativCursos = ativCursos;
        this.mentorias = mentorias;
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

    public String getDescricao() {
        return descricao;
    }

    public Set<Devs> getDevs() {
        return devs;
    }

    public Set<AtividadesCursos> getAtivCursos() {
        return ativCursos;
    }

    public Set<Mentorias> getMentorias() {
        return mentorias;
    }

    public void setDevs(Set<Devs> devs) {
        this.devs = devs;
    }

}
