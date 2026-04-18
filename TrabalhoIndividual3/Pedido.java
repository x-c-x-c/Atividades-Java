import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private int id;
    private Cliente cliente;
    private List<ItemPedido> itens;

    public Pedido(int id, Cliente cliente) {
        this.id = id;
        this.cliente = cliente;
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(ItemPedido item) {
        itens.add(item);
    }

    public double calcularTotal() {
        double total = 0;
        for (ItemPedido item : itens) {
            total += item.getSubtotal();
        }
        return total;
    }

    public void fecharPedido() {
        double total = calcularTotal();
        double frete = (total > 250.0) ? 0.0 : 25.0;
        double totalComFrete = total + frete;

        System.out.println("              RECIBO DO PEDIDO          ");
        System.out.println("Pedido: " + id);
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("Email:   " + cliente.getEmail());
        System.out.println("CPF:     " + cliente.getCpf());
        System.out.println("ITENS:");
        for (ItemPedido item : itens) {
            System.out.printf("  %-20s x%d  R$ %.2f%n",
                    item.getNomeProduto(),
                    item.getQuantidade(),
                    item.getSubtotal());
        }
        System.out.printf("Subtotal:               R$ %.2f%n", total);
        if (frete == 0) {
            System.out.println("Frete:                  GRÁTIS");
        } else {
            System.out.printf("Frete:                  R$ %.2f%n", frete);
        }
        System.out.printf("TOTAL:                  R$ %.2f%n", totalComFrete);
    }
}

