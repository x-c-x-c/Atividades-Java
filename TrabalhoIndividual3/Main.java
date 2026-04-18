public class Main {
    public static void main(String[] args) {

        Cliente cliente = new Cliente("Maria Silva", "maria@email.com", "123.456.789-00");
        Pedido pedido = new Pedido(1, cliente);

        pedido.adicionarItem(new ItemPedido("Teclado Mecânico", 150.00, 1));
        pedido.adicionarItem(new ItemPedido("Mouse Gamer", 80.00, 1));
        pedido.adicionarItem(new ItemPedido("Mousepad", 30.00, 2));

        pedido.fecharPedido();

        System.out.println();

        Pedido pedido2 = new Pedido(2, cliente);
        pedido2.adicionarItem(new ItemPedido("Cabo USB", 20.00, 1));
        pedido2.adicionarItem(new ItemPedido("Hub USB", 45.00, 1));
        pedido2.fecharPedido();
    }
}