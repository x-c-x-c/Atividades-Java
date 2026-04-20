public final class Caminhao extends Veiculo {

    private final double capacidadeCargaToneladas;

    public Caminhao(String placa, String marca, double valorLocacaoDiaria,
                    int anoFabricacao, double precoFipe, double capacidadeCargaToneladas)
            throws ParametroInvalidoVeiculoException {
        super(placa, marca, valorLocacaoDiaria, anoFabricacao, precoFipe);

        if (capacidadeCargaToneladas <= 0)
            throw new ParametroInvalidoVeiculoException("capacidadeCargaToneladas", "deve ser positiva");

        this.capacidadeCargaToneladas = capacidadeCargaToneladas;
    }

    public double getCapacidadeCargaToneladas() {
        return capacidadeCargaToneladas;
    }

    @Override
    public double alugarVeiculo(double pesoCarga, int dias)
            throws ParametroLocacaoInvalidoException, SobrecargaCaminhaoException {

        if (pesoCarga < 0)
            throw new ParametroLocacaoInvalidoException("pesoCarga",
                    "não pode ser negativo");
        if (dias <= 0)
            throw new ParametroLocacaoInvalidoException("dias",
                    "deve ser maior que zero");

        if (pesoCarga > capacidadeCargaToneladas)
            throw new SobrecargaCaminhaoException(pesoCarga, capacidadeCargaToneladas);

        return getValorLocacaoDiaria() * dias;
    }

    public double alugarComTaxaSobrecarga(double pesoCarga, int dias)
            throws ParametroLocacaoInvalidoException {

        if (pesoCarga < 0)
            throw new ParametroLocacaoInvalidoException("pesoCarga", "não pode ser negativo");
        if (dias <= 0)
            throw new ParametroLocacaoInvalidoException("dias", "deve ser maior que zero");

        double total = getValorLocacaoDiaria() * dias;
        if (pesoCarga > capacidadeCargaToneladas) {
            total *= 1.10;
        }
        return total;
    }

    @Override
    public double calcularIpva() {
        if (isIsentoIpva()) return 0.0;
        return getPrecoFipe() * 0.015;
    }

    @Override
    public String toString() {
        return "Caminhao " + super.toString()
                + String.format(" | Capacidade: %.2ft", capacidadeCargaToneladas);
    }
}