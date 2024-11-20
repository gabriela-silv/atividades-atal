package cafeteria;

public class GerenciadorPedidos{
	private Deque<Pedido> filaPedidos;

    // Construtor
    public GerenciadorPedidos(int capacidadeInicial) {
        filaPedidos = new Deque<>(capacidadeInicial);
    }

    // Adiciona um pedido na fila de acordo com a prioridade
    public void adicionarPedido(Pedido pedido) {
        if (pedido.isVip()) {
            filaPedidos.addFirst(pedido);  // Clientes VIP têm prioridade e são colocados no início
        } else {
            filaPedidos.addLast(pedido);  // Clientes normais são adicionados ao final da fila
        }
    }

    // Processa o próximo pedido (remove o primeiro da fila)
    public Pedido processarPedido() {
        if (!filaPedidos.isEmpty()) {
            return filaPedidos.removeFirst();  // Processa o pedido no início da fila
        }
        System.out.println("Não há pedidos na fila.");
        return null;
    }

    // Remove um pedido específico (quando o cliente cancela)
    public void cancelarPedido(Pedido pedido) {
        Deque<Pedido> tempDeque = new Deque<>(filaPedidos.size());
        boolean encontrado = false;

        while (!filaPedidos.isEmpty()) {
            Pedido atual = filaPedidos.removeFirst();
            if (atual.equals(pedido)) {
                encontrado = true;  // Pedido encontrado e não será adicionado novamente
                System.out.println("Pedido cancelado: " + pedido);
            } else {
                tempDeque.addLast(atual);  // Adiciona todos os pedidos que não foram cancelados ao deque temporário
            }
        }

        filaPedidos = tempDeque;  // Atualiza a fila original com os pedidos restantes

        if (!encontrado) {
            System.out.println("Pedido não encontrado para cancelamento.");
        }
    }

    // Exibe os pedidos na fila sem removê-los
    public void visualizarPedidos() {
        if (filaPedidos.isEmpty()) {
            System.out.println("Nenhum pedido em espera.");
        } else {
            System.out.println("Pedidos em espera:");
            Deque<Pedido> tempDeque = new Deque<>(filaPedidos.size());
            while (!filaPedidos.isEmpty()) {
                Pedido pedido = filaPedidos.removeFirst();
                System.out.println(pedido);
                tempDeque.addLast(pedido);  // Armazena o pedido temporariamente
            }
            filaPedidos = tempDeque;  // Restaura a fila original
        }
    }

    // Verifica se há pedidos pendentes
    public boolean hasPedidosPendentes() {
        return !filaPedidos.isEmpty();
        }
    
}
