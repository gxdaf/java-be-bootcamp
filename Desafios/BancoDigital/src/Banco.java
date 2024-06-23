import java.util.List;

public class Banco {

    public static void main(String[] args) {
        Cliente gabriela = new Cliente("Gabriela", 22);
        Cliente barbara = new Cliente("Barbara", 23);

        Conta contaGabriela = new Conta(gabriela, "Poupança");
        Conta contaBarbara = new Conta(barbara, "Corrente");

        contaGabriela.depositar(500);
        
        contaBarbara.imprimirExtrato();
        contaGabriela.imprimirExtrato();

        contaGabriela.transferir(250, contaBarbara);

        contaBarbara.imprimirExtrato();
        contaGabriela.imprimirExtrato();
    }

}
