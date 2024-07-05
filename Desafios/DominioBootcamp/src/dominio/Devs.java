package dominio;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Devs {

    private String nome;
    private Set<Mentorias> mentorias = new HashSet<>();
    private Set<AtividadesCursos> ativCursosConcluidos = new HashSet<>();
    private Set<AtividadesCursos> ativCursosInscritos = new HashSet<>();

    public Devs(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void inscreverBootcamp(Bootcamp bootcamp){
        this.ativCursosInscritos.addAll(bootcamp.getAtivCursos());
    }

    public void progredir(AtividadesCursos ativCurso){
        ativCursosInscritos.removeIf(curso -> curso.getTitulo().equals(ativCurso.getTitulo()));
        ativCursosConcluidos.add(ativCurso);
    }

    public String exibirCursosInscritos(){
        return ativCursosInscritos.stream()
            .map(AtividadesCursos::getTitulo)  
            .collect(Collectors.joining(", "));
    }

    public String exibirCursosConcluidos(){
        return ativCursosConcluidos.stream()
            .map(AtividadesCursos::getTitulo)  
            .collect(Collectors.joining(", "));
    }

    public int calcularTotalXp(){
        return ativCursosConcluidos.stream()
            .mapToInt(n -> n.getCargaHoraria() * AtividadesCursos.XP_PADRAO)
            .sum();
    }

    public Set<Mentorias> getMentorias() {
        return mentorias;
    }

    public void setMentorias(Set<Mentorias> mentorias) {
        this.mentorias = mentorias;
    }

    public Set<AtividadesCursos> getAtivCursosConcluidos() {
        return ativCursosConcluidos;
    }

    public void setAtivCursos(Set<AtividadesCursos> ativCursos) {
        this.ativCursosInscritos = ativCursos;}

    @Override
    public String toString() {
        return String.format("Dev %s, inscrito em: %s", this.nome, exibirCursosInscritos());
    }

}
