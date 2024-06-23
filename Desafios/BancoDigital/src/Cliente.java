public class Cliente {
    private String nome;
    private int idade;

    public Cliente(String nome, int idade) {
        this.nome = nome;
        if (idade < 18) {
            throw new IllegalArgumentException("O cliente precisa ser maior de idade para ter uma conta.");
        }
        this.idade = idade;
    }

	public String getNome() {
		return nome;
	}

    public void setNome(String nome) {
		this.nome = nome;
	}

}
