package dequeimplementacao;

import java.util.NoSuchElementException;

public class Deque<E> implements IDeque<E> {
    private E[] deque;
    private int inicio;
    private int fim;
    private int tamanho;
    private int capacidade;

    // Construtor padrão com capacidade inicial
    public Deque(int capacidadeInicial) {
        deque = (E[]) new Object[capacidadeInicial];
        capacidade = capacidadeInicial;
        inicio = 0;
        fim = 0;
        tamanho = 0;
    }

    // Adiciona um elemento no início do deque
    @Override
    public void addFirst(E element) {
        if (tamanho == capacidade) {
            redimensionar();
        }
        inicio = (inicio - 1 + capacidade) % capacidade; // Decrementa o índice de início
        deque[inicio] = element;
        tamanho++;
    }

    // Adiciona um elemento no fim do deque
    @Override
    public void addLast(E element) {
        if (tamanho == capacidade) {
            redimensionar();
        }
        deque[fim] = element;
        fim = (fim + 1) % capacidade; // Incrementa o índice de fim
        tamanho++;
    }

    // Remove e retorna o elemento do início do deque
    @Override
    public E removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("Deque está vazio");
        }
        E element = deque[inicio];
        deque[inicio] = null;
        inicio = (inicio + 1) % capacidade; // Incrementa o índice de início
        tamanho--;
        return element;
    }

    // Remove e retorna o elemento do fim do deque
    @Override
    public E removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("Deque está vazio");
        }
        fim = (fim - 1 + capacidade) % capacidade; // Decrementa o índice de fim
        E element = deque[fim];
        deque[fim] = null;
        tamanho--;
        return element;
    }

    // Retorna o elemento do início do deque sem removê-lo
    @Override
    public E getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("Deque está vazio");
        }
        return deque[inicio];
    }

    // Retorna o elemento do fim do deque sem removê-lo
    @Override
    public E getLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("Deque está vazio");
        }
        int ultimoIndice = (fim - 1 + capacidade) % capacidade;
        return deque[ultimoIndice];
    }

    // Verifica se o deque está vazio
    @Override
    public boolean isEmpty() {
        return tamanho == 0;
    }

    // Retorna o tamanho atual do deque
    @Override
    public int size() {
        return tamanho;
    }

    // Método auxiliar para redimensionar o deque quando estiver cheio
    private void redimensionar() {
        int novaCapacidade = capacidade * 2;
        E[] novoDeque = (E[]) new Object[novaCapacidade];
        for (int i = 0; i < tamanho; i++) {
            novoDeque[i] = deque[(inicio + i) % capacidade];
        }
        deque = novoDeque;
        inicio = 0;
        fim = tamanho;
        capacidade = novaCapacidade;
    }
}
