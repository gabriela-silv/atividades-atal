package cafeteria;

public interface IDeque<E> {
    // Adiciona um elemento no início do deque
    void addFirst(E element);

    // Adiciona um elemento no fim do deque
    void addLast(E element);

    // Remove e retorna o elemento do início do deque
    E removeFirst();

    // Remove e retorna o elemento do fim do deque
    E removeLast();

    // Retorna o elemento do início do deque sem removê-lo
    E getFirst();

    // Retorna o elemento do fim do deque sem removê-lo
    E getLast();

    // Verifica se o deque está vazio
    boolean isEmpty();

    // Retorna o tamanho atual do deque
    int size();
}
