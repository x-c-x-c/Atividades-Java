public abstract sealed class Veiculo implements Fretavel, Tributavel
        permits Caminhao, CarroPasseio {

    private final String placa;
    private final String marca;
    private double valorLocacaoDiaria;
    private final int anoFabricacao;
    private double precoFipe;

    public Veiculo(String placa, String marca, double valorLocacaoDiaria,
                   int anoFabricacao, double precoFipe)
            throws ParametroInvalidoVeiculoException {

        if (placa == null || placa.isBlank())
            throw new ParametroInvalidoVeiculoException("placa", "não pode ser vazia");
        if (marca == null || marca.isBlank())
            throw new ParametroInvalidoVeiculoException("marca", "não pode ser vazia");
        if (valorLocacaoDiaria <= 0)
            throw new ParametroInvalidoVeiculoException("valorLocacaoDiaria", "deve ser positivo");
        if (anoFabricacao < 1886 || anoFabricacao > java.time.Year.now().getValue())
            throw new ParametroInvalidoVeiculoException("anoFabricacao",
                    "valor inválido: " + anoFabricacao);
        if (precoFipe <= 0)
            throw new ParametroInvalidoVeiculoException("precoFipe", "deve ser positivo");

        this.placa = placa;
        this.marca = marca;
        this.valorLocacaoDiaria = valorLocacaoDiaria;
        this.anoFabricacao = anoFabricacao;
        this.precoFipe = precoFipe;
    }

    protected boolean isIsentoIpva() {
        int anoAtual = java.time.Year.now().getValue();
        return (anoAtual - anoFabricacao) > 20;
    }

    public String getPlaca()               { return placa; }
    public String getMarca()               { return marca; }
    public double getValorLocacaoDiaria()  { return valorLocacaoDiaria; }
    public int    getAnoFabricacao()       { return anoFabricacao; }
    public double getPrecoFipe()           { return precoFipe; }

    public void setValorLocacaoDiaria(double valorLocacaoDiaria)
            throws ParametroInvalidoVeiculoException {
        if (valorLocacaoDiaria <= 0)
            throw new ParametroInvalidoVeiculoException("valorLocacaoDiaria", "deve ser positivo");
        this.valorLocacaoDiaria = valorLocacaoDiaria;
    }

    public void setPrecoFipe(double precoFipe)
            throws ParametroInvalidoVeiculoException {
        if (precoFipe <= 0)
            throw new ParametroInvalidoVeiculoException("precoFipe", "deve ser positivo");
        this.precoFipe = precoFipe;
    }

    @Override
    public String toString() {
        return String.format("[%s] %s | Ano: %d | Diária: R$ %.2f | FIPE: R$ %.2f",
                placa, marca, anoFabricacao, valorLocacaoDiaria, precoFipe);
    }
}