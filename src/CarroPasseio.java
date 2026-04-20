public final class CarroPasseio extends Veiculo {

    public CarroPasseio(String placa, String marca, double valorLocacaoDiaria,
                        int anoFabricacao, double precoFipe)
            throws ParametroInvalidoVeiculoException {
        super(placa, marca, valorLocacaoDiaria, anoFabricacao, precoFipe);
    }

    @Override
    public double alugarVeiculo(double pesoCarga, int dias)
            throws ParametroLocacaoInvalidoException {

        if (pesoCarga < 0)
            throw new ParametroLocacaoInvalidoException("pesoCarga", "não pode ser negativo");
        if (dias <= 0)
            throw new ParametroLocacaoInvalidoException("dias", "deve ser maior que zero");

        return getValorLocacaoDiaria() * dias;
    }

    @Override
    public double calcularIpva() {
        if (isIsentoIpva()) return 0.0;
        return getPrecoFipe() * 0.04;
    }

    @Override
    public String toString() {
        return "CarroPasseio " + super.toString();
    }
}
