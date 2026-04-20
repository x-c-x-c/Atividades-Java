//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {

        System.out.println("=== SISTEMA DE VEÍCULOS ===\n");
        Caminhao caminhao = null;
        CarroPasseio carro = null;
        CarroPasseio carroAntigo = null;

        try {
            caminhao = new Caminhao("ABC-1234", "Scania", 850.00, 2020, 320000.00, 15.0);
            System.out.println("Criado: " + caminhao);

            carro = new CarroPasseio("XYZ-5678", "Toyota", 180.00, 2019, 85000.00);
            System.out.println("Criado: " + carro);

            carroAntigo = new CarroPasseio("OLD-0001", "Fiat", 120.00, 1998, 18000.00);
            System.out.println("Criado: " + carroAntigo);

        } catch (ParametroInvalidoVeiculoException e) {
            System.out.println("Erro ao criar veículo: " + e.getMessage());
            return;
        }

        System.out.println("\n Locações normais ");

        try {
            double total = caminhao.alugarVeiculo(10.0, 3);
            System.out.printf("Caminhão (10t / 3 dias): R$ %.2f%n", total);

        } catch (ParametroLocacaoInvalidoException e) {
            System.out.println("Parâmetro inválido: " + e.getMessage());
        } catch (SobrecargaCaminhaoException e) {
            System.out.println("Sobrecarga: " + e.getMessage());
        }

        try {
            double total = carro.alugarVeiculo(0, 5);
            System.out.printf("Carro passeio (5 dias): R$ %.2f%n", total);

        } catch (ParametroLocacaoInvalidoException e) {
            System.out.println("Parâmetro inválido: " + e.getMessage());
        }

        System.out.println("\nLocação com sobrecarga");

        try {
            double total = caminhao.alugarVeiculo(20.0, 3);
            System.out.printf("Total: R$ %.2f%n", total);

        } catch (SobrecargaCaminhaoException e) {
            System.out.println("Aviso: " + e.getMessage());
            System.out.printf("  Excesso: %.2f toneladas%n", e.getExcessoToneladas());

            try {
                double totalComTaxa = caminhao.alugarComTaxaSobrecarga(
                        e.getPesoInformado(), 3);
                System.out.printf("  Taxa de sobrecarga aplicada → Total: R$ %.2f%n",
                        totalComTaxa);
            } catch (ParametroLocacaoInvalidoException ex) {
                System.out.println("Erro interno: " + ex.getMessage());
            }

        } catch (ParametroLocacaoInvalidoException e) {
            System.out.println("Parâmetro inválido: " + e.getMessage());
        }

        System.out.println("\nIPVA ");
        System.out.printf("Caminhão  (1,5%% FIPE): R$ %.2f%n", caminhao.calcularIpva());
        System.out.printf("Carro     (4%% FIPE):   R$ %.2f%n", carro.calcularIpva());
        System.out.printf("Carro antigo (isento): R$ %.2f%n",  carroAntigo.calcularIpva());
        System.out.println("\nExceções no construtor (ParametroInvalidoVeiculoException)");

        try {
            new Caminhao("", "Volvo", 500.00, 2021, 200000.00, 10.0);
        } catch (ParametroInvalidoVeiculoException e) {
            System.out.println("OK " + e.getMessage());
        }

        try {
            new CarroPasseio("DEF-9999", "Honda", -200.00, 2022, 70000.00);
        } catch (ParametroInvalidoVeiculoException e) {
            System.out.println("OK " + e.getMessage());
        }

        try {
            new Caminhao("GHI-1111", "Mercedes", 700.00, 1800, 150000.00, 8.0);
        } catch (ParametroInvalidoVeiculoException e) {
            System.out.println("OK " + e.getMessage());
        }

        try {
            new Caminhao("JKL-2222", "MAN", 600.00, 2018, 180000.00, -5.0);
        } catch (ParametroInvalidoVeiculoException e) {
            System.out.println("OK " + e.getMessage());
        }

        System.out.println("\n Exceções nos métodos ");

        try {
            caminhao.alugarVeiculo(-1.0, 3);
        } catch (ParametroLocacaoInvalidoException e) {
            System.out.println("OK " + e.getMessage());
        } catch (SobrecargaCaminhaoException e) {
            System.out.println("Sobrecarga: " + e.getMessage());
        }

        try {
            carro.alugarVeiculo(0, 0);
        } catch (ParametroLocacaoInvalidoException e) {
            System.out.println("OK " + e.getMessage());
        }

        System.out.println("\n Catch genérico com VeiculoException ");

        try {
            caminhao.alugarVeiculo(0, -1); // dias inválido
        } catch (VeiculoException e) {
            // VeiculoException é mãe de todas — funciona como curinga
            System.out.println("✓ Capturado via VeiculoException: " + e.getMessage());
            System.out.println("  Tipo real: " + e.getClass().getSimpleName());
        }

        System.out.println("\n=== FIM ===");
    }
}