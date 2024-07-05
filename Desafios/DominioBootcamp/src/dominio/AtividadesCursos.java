package dominio;

public class AtividadesCursos {

    private String titulo;
    private String descricao;
    private int cargaHoraria;
    public static final int XP_PADRAO = 10;

    public AtividadesCursos(String titulo, String descricao, int cargaHoraria) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.cargaHoraria = cargaHoraria;
    }

    public int calcularXP(){
        return XP_PADRAO * cargaHoraria;
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
