package dominio;

import java.time.LocalDate;

public class Mentorias {
    
    private String titulo;
    private String descricao;
    private LocalDate dataMentoria;
    
    public Mentorias(String titulo, String descricao, LocalDate dataMentoria) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataMentoria = dataMentoria;
    }
    
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public LocalDate getDataMentoria() {
        return dataMentoria;
    }
    public void setDataMentoria(LocalDate dataMentoria) {
        this.dataMentoria = dataMentoria;
    }

}
