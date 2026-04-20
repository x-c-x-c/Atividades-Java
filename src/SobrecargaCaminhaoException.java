public class SobrecargaCaminhaoException extends VeiculoException {

    private final double pesoInformado;
    private final double capacidadeMaxima;

    public SobrecargaCaminhaoException(double pesoInformado, double capacidadeMaxima) {
        super(String.format(
                "Peso informado (%.2ft) ultrapassa a capacidade máxima do caminhão (%.2ft).",
                pesoInformado, capacidadeMaxima));
        this.pesoInformado = pesoInformado;
        this.capacidadeMaxima = capacidadeMaxima;
    }

    public double getPesoInformado()   { return pesoInformado; }
    public double getCapacidadeMaxima(){ return capacidadeMaxima; }

    /** Quanto de excesso, em toneladas. */
    public double getExcessoToneladas() {
        return pesoInformado - capacidadeMaxima;
    }
}
