public class ContaBancaria {
    int numero;
    String titular;
    double saldo;
    int numeroSaque = 0;

    public ContaBancaria() {
        saldo = 50.00;
    }

        public void depositar(double valorDeposito)  { //parametro pq eh um valor q so existe no deposito
                    saldo = saldo + valorDeposito;
        }

        public void sacar(double valorSaque) {

                    if (valorSaque >= 1000.00) {
                        System.out.println("O limite por saque é de R$ 1.000,00. ");
                    }
                    else if (numeroSaque >= 3){
                            System.out.println("Limite de saques diários atingido ");
                        }
                    else {    
                        saldo = saldo - valorSaque;
                        numeroSaque++;
                    }
        }
       
 }
