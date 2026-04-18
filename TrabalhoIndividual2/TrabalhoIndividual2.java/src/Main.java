import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int opcao;
        double valorDeposito;
        double valorSaque;
        Scanner scanner = new Scanner(System.in);

        ContaBancaria conta = new ContaBancaria();
        conta.numero = 2932;
        conta.titular = "Pograma";
        
        
        do {
            System.out.println("\n1 - Ver Saldo");
            System.out.println("2 - Depositar");
            System.out.println("3 - Sacar");
            System.out.println("0 - Sair");
            System.out.println("Digite a opção desejada:");
            opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    System.out.printf("Seu Saldo: %.2f", conta.saldo);
                    break; 
                
                case 2:
                    System.out.println("Digite o valor que deseja depositar: ");
                    valorDeposito = scanner.nextDouble();
                    conta.depositar(valorDeposito);
                    break;
                
                case 3:
                    System.out.println("Digite o valor que deseja sacar: ");
                    valorSaque = scanner.nextDouble();
                    conta.sacar(valorSaque);
                    break;

                case 0:
                    System.out.println("Bye Bye, volte sempre!");
                    break;

                default:
                    System.out.println("Opcao invalida, Tente novamente.");

            }
        } while (opcao != 0);
                scanner.close();
    }
}

