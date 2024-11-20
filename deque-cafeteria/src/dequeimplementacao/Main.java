package dequeimplementacao;

public class Main {
	public static void main(String[] args) {
        // Criando um deque com capacidade inicial de 5 elementos
        Deque<Integer> deque = new Deque<>(5);

        // Testando o método addFirst e addLast
        System.out.println("Adicionando 10 no início:");
        deque.addFirst(10);
        System.out.println("Deque após adicionar 10 no início: " + deque.getFirst());

        System.out.println("Adicionando 20 no fim:");
        deque.addLast(20);
        System.out.println("Deque após adicionar 20 no fim: " + deque.getLast());

        System.out.println("Adicionando 5 no início:");
        deque.addFirst(5);
        System.out.println("Elemento na frente: " + deque.getFirst());
        System.out.println("Elemento no fim: " + deque.getLast());

        System.out.println("Adicionando 30 no fim:");
        deque.addLast(30);
        System.out.println("Elemento na frente: " + deque.getFirst());
        System.out.println("Elemento no fim: " + deque.getLast());

        // Testando o método getFirst e getLast
        System.out.println("\nElemento no início: " + deque.getFirst());
        System.out.println("Elemento no fim: " + deque.getLast());

        // Testando o método removeFirst
        System.out.println("\nRemovendo o primeiro elemento: " + deque.removeFirst());
        System.out.println("Novo primeiro elemento: " + deque.getFirst());

        // Testando o método removeLast
        System.out.println("Removendo o último elemento: " + deque.removeLast());
        System.out.println("Novo último elemento: " + deque.getLast());

        // Testando o método isEmpty
        System.out.println("\nDeque está vazio? " + deque.isEmpty());

        // Testando a remoção de todos os elementos para esvaziar o deque
        System.out.println("Removendo todos os elementos...");
        deque.removeFirst();
        deque.removeLast();
        System.out.println("Deque está vazio agora? " + deque.isEmpty());

        // Testando redimensionamento do deque
        System.out.println("\nAdicionando mais elementos para testar redimensionamento:");
        deque.addFirst(100);
        deque.addLast(200);
        deque.addFirst(50);
        deque.addLast(300);
        deque.addFirst(25); // Aqui o deque deve redimensionar automaticamente
        deque.addLast(400);

        System.out.println("Elemento na frente após redimensionamento: " + deque.getFirst());
        System.out.println("Elemento no fim após redimensionamento: " + deque.getLast());
        System.out.println("Tamanho atual do deque: " + deque.size());
    }

}
