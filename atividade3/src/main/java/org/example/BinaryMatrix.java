package org.example;


import java.util.Arrays;

/**/
public class BinaryMatrix {
    private int[] tree; // Matriz para armazenar a árvore
    private int size;   // Tamanho atual da árvore

    public BinaryMatrix(int capacity) {
        tree = new int[capacity];
        Arrays.fill(tree, Integer.MIN_VALUE); // Usar Integer.MIN_VALUE como valor "nulo"
        size = 0;
    }

    // Verifica se a árvore está vazia
    public boolean isEmpty() {
        return size == 0;
    }

    // Insere um valor na árvore
    public void insert(int value) {
        if (size == tree.length) {
            System.out.println("Erro: Árvore cheia!");
            return;
        }
        tree[size] = value;
        System.out.println("Inserido " + value + " na posição " + size);
        size++;
    }

    // Exibe a raiz da árvore
    public void showRoot() {
        if (isEmpty()) {
            System.out.println("A árvore está vazia!");
        } else {
            System.out.println("Raiz: " + tree[0]);
        }
    }

    // Exibe a árvore em ordem simétrica
    public void inOrder(int index) {
        if (index >= size || tree[index] == Integer.MIN_VALUE) return;

        // Filho esquerdo
        inOrder(2 * index + 1);

        // Nó atual
        System.out.print(tree[index] + " ");

        // Filho direito
        inOrder(2 * index + 2);
    }

    // Exibe a árvore em pré-ordem
    public void preOrder(int index) {
        if (index >= size || tree[index] == Integer.MIN_VALUE) return;

        // Nó atual
        System.out.print(tree[index] + " ");

        // Filho esquerdo
        preOrder(2 * index + 1);

        // Filho direito
        preOrder(2 * index + 2);
    }

    // Exibe a árvore em pós-ordem
    public void postOrder(int index) {
        if (index >= size || tree[index] == Integer.MIN_VALUE) return;

        // Filho esquerdo
        postOrder(2 * index + 1);

        // Filho direito
        postOrder(2 * index + 2);

        // Nó atual
        System.out.print(tree[index] + " ");
    }

    // Remove um valor da árvore
    public void remove(int value) {
        int index = find(value);
        if (index == -1) {
            System.out.println("Valor " + value + " não encontrado!");
            return;
        }

        // Substituir pelo último valor e reduzir o tamanho
        tree[index] = tree[size - 1];
        tree[size - 1] = Integer.MIN_VALUE;
        size--;

        System.out.println("Removido valor " + value + " da posição " + index);
    }

    // Encontra o índice de um valor
    private int find(int value) {
        for (int i = 0; i < size; i++) {
            if (tree[i] == value) return i;
        }
        return -1;
    }

}
