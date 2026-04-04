public class topfilme {
    String titulo;
    String genero;
    double nota;
    String diretor;

    public void imprimir() {
        System.out.println("Meu filme favorito\n");
        System.out.println("Titulo: " + titulo);
        System.out.println("Genero: " + genero);
        System.out.printf("Nota: %.2f\n", nota);
        System.out.println("Diretor: " + diretor);
    }
}

