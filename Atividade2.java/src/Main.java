import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite um numero: ");
        int n = scanner.nextInt();
        scanner.close();
        int sucessor = n + 1;
        int antecessor = n - 1;
        System.out.println("O antecessor de " + n + " é " + antecessor);
        System.out.println("O sucessor de " + n + " é " + sucessor);
    }
}
