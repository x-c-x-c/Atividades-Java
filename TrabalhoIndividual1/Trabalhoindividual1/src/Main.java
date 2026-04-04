import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double saldo = 1000.00;
        int opcao;
        double valorDeposito;
        double valorSaque;
        int numeroSaque = 0;
        Scanner scanner = new Scanner(System.in);
        
        
        do {
            System.out.println("\n1 - Ver Saldo");
            System.out.println("2 - Depositar");
            System.out.println("3 - Sacar");
            System.out.println("0 - Sair");
            System.out.println("Digite a opção desejada:");
            opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    System.out.printf("Seu Saldo: %.2f", saldo);
                    break; 
                
                case 2:
                    System.out.println("Digite o valor que deseja depositar: ");
                    valorDeposito = scanner.nextDouble();
                    saldo = saldo + valorDeposito;
                    break;
                
                case 3:
                    System.out.println("Digite o valor que deseja sacar: ");
                    valorSaque = scanner.nextDouble();
                    saldo = saldo - valorSaque;
                    numeroSaque++;

                    if (valorSaque >= 1000.00) {
                        System.out.println("O limite por saque é de R$ 1.000,00. ");
                    }
                        else if (numeroSaque > 3){
                            System.out.println("Limite de saques diários atingido ");
                        }
                            else {
                                saldo = saldo - valorSaque;
                                numeroSaque++;
                            }
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
