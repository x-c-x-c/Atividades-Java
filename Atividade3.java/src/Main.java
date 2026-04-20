import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Pessoa pessoa1 = new Pessoa();
        System.out.println("Digite o nome da pessoa: ");
        pessoa1.nome = scanner.nextLine();
        System.out.println("Digite o peso da pessoa: ");
        pessoa1.peso = scanner.nextDouble();
        System.out.println("Digite a altura da pessoa: ");
        pessoa1.altura = scanner.nextDouble();
        scanner.nextLine();

        Pessoa pessoa2 = new Pessoa();
        System.out.println("Digite o nome da pessoa: ");
        pessoa2.nome = scanner.nextLine();
        System.out.println("Digite o peso da pessoa: ");
        pessoa2.peso = scanner.nextDouble();
        System.out.println("Digite a altura da pessoa: ");
        pessoa2.altura = scanner.nextDouble();
        scanner.nextLine();

        Pessoa pessoa3 = new Pessoa();
        System.out.println("Digite o nome da pessoa: ");
        pessoa3.nome = scanner.nextLine();
        System.out.println("Digite o peso da pessoa: ");
        pessoa3.peso = scanner.nextDouble();
        System.out.println("Digite a altura da pessoa: ");
        pessoa3.altura = scanner.nextDouble();
        scanner.nextLine();

        Pessoa pessoa4 = new Pessoa();
        System.out.println("Digite o nome da pessoa: ");
        pessoa4.nome = scanner.nextLine();
        System.out.println("Digite o peso da pessoa: ");
        pessoa4.peso = scanner.nextDouble();
        System.out.println("Digite a altura da pessoa: ");
        pessoa4.altura = scanner.nextDouble();
        scanner.nextLine();
        scanner.close();

        Pessoa[] pessoas = new Pessoa[4]; 
        pessoas[0] = pessoa1;
        pessoas[1] = pessoa2;
        pessoas[2] = pessoa3;
        pessoas[3] = pessoa4;
        Pessoa maiorPeso = pessoas[0];
        for (int i = 1; i < pessoas.length; i++) {
            if (pessoas[i].peso > maiorPeso.peso) {
                maiorPeso = pessoas[i];
            }
        }
        System.out.println("Pessoa com maior peso: " + maiorPeso.nome);

        pessoas[0] = pessoa1;
        pessoas[1] = pessoa2;
        pessoas[2] = pessoa3;
        pessoas[3] = pessoa4;
        Pessoa maiorAltura = pessoas[0];
        for (int i = 1; i < pessoas.length; i++) {
            if (pessoas[i].altura > maiorAltura.altura) {
                maiorAltura = pessoas[i];
            }
        }
        System.out.println("Pessoa com maior altura: " + maiorAltura.nome);

        double mediaPeso = (pessoa1.peso + pessoa2.peso + pessoa3.peso + pessoa4.peso) / 4;
        System.out.printf("Média do peso: %.2f", mediaPeso);

        double mediaAltura = (pessoa1.altura + pessoa2.altura + pessoa3.altura + pessoa4.altura) / 4;
        System.out.printf("\nMédia da altura: %.2f", mediaAltura);
    }
}
