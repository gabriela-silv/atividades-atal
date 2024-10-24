package cafeteria;

public class Pedido {
	private String cliente;  // Nome do cliente
    private boolean isVip;   // Flag para verificar se o cliente é VIP

    // Construtor da classe Pedido
    public Pedido(String cliente, boolean isVip) {
        this.cliente = cliente;
        this.isVip = isVip;
    }

    // Método que retorna se o cliente é VIP
    public boolean isVip() {
        return isVip;
    }

    // Método toString para exibir o pedido de forma legível
    @Override
    public String toString() {
        return "Pedido{" +
                "cliente='" + cliente + '\'' +
                ", VIP=" + isVip +
                '}';
    }

    // Sobrescreve o método equals para comparar pedidos pelo nome do cliente
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;  // Verifica se é o mesmo objeto
        if (obj == null || getClass() != obj.getClass()) return false;  // Verifica se não é nulo ou de outra classe
        Pedido pedido = (Pedido) obj;  // Faz o cast para Pedido
        return cliente.equals(pedido.cliente);  // Compara os nomes dos clientes
    }

    // Sobrescreve o método hashCode caso seja necessário em futuras comparações (boas práticas)
    @Override
    public int hashCode() {
        return cliente.hashCode();
    }

}
