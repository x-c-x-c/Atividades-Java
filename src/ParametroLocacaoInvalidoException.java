public class ParametroLocacaoInvalidoException extends VeiculoException {
    public ParametroLocacaoInvalidoException(String campo, String motivo) {
        super(String.format("Parâmetro de locação inválido — %s: %s", campo, motivo));
    }
}
