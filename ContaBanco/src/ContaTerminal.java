import java.util.Scanner;

public class ContaTerminal {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Insira seu nome: ");
        String nomeCliente = scanner.next().toUpperCase();
        
        System.out.println("Insira o número da agência: ");
        int agencia = scanner.nextInt();

        System.out.println("Insira o número da conta e o dígito, conforme seguinte exemplo (0000-0): ");
        String conta = scanner.next();
        
        System.out.println("Insira o saldo disponível: ");
        double saldo = scanner.nextDouble();

        String msg = String.format("Olá %s, obrigado por criar uma conta em nosso banco, sua agência é %s, conta %s e seu saldo %.2f já está disponível para saque", nomeCliente, agencia, conta, saldo);

        System.out.println(msg);

        scanner.close();

    }
}
