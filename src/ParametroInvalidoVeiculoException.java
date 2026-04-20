public class ParametroInvalidoVeiculoException extends VeiculoException {
    public ParametroInvalidoVeiculoException(String campo, String motivo) {
        super(String.format("Parâmetro inválido — %s: %s", campo, motivo));
    }
}
