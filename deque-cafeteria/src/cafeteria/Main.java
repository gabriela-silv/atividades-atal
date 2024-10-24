package cafeteria;

public class Main {
	public static void main(String[] args) {
        GerenciadorPedidos gerenciador = new GerenciadorPedidos(10);

        // Criando pedidos
        Pedido pedido1 = new Pedido("Cliente 1", false);  // Pedido normal
        Pedido pedido2 = new Pedido("Cliente VIP", true);  // Pedido VIP
        Pedido pedido3 = new Pedido("Cliente 3", false);  // Pedido normal

        // Adicionando pedidos
        gerenciador.adicionarPedido(pedido1);
        gerenciador.adicionarPedido(pedido2);
        gerenciador.adicionarPedido(pedido3);

        // Visualizando pedidos
        gerenciador.visualizarPedidos();

        // Processando um pedido (removendo o primeiro da fila)
        System.out.println("\nProcessando pedido: " + gerenciador.processarPedido());

        // Visualizando após processar um pedido
        System.out.println("\nPedidos restantes após processamento:");
        gerenciador.visualizarPedidos();

        // Cancelando um pedido
        System.out.println("\nCancelando o pedido do Cliente 3:");
        gerenciador.cancelarPedido(pedido3);

        // Visualizando após cancelamento
        System.out.println("\nPedidos restantes após cancelamento:");
        gerenciador.visualizarPedidos();
    }

}
