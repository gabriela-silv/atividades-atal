package org.example;
import javax.swing.JOptionPane;


public class Main {
    public static void main(String[] args) {
        int input = 20;
        String result;
        BinaryMatrix tree = new BinaryMatrix(100); // Capacidade de 100 nós

        while (input != 0) {
            result = showMenu();

            if (result.equals("")) {
                JOptionPane.showMessageDialog(null, "Digite um valor numérico!");
                result = showMenu();
            } else {
                input = Integer.parseInt(result);

                switch (input) {
                    case 1:
                        String item = JOptionPane.showInputDialog("Digite um número para inserir na árvore!");
                        tree.insert(Integer.parseInt(item));
                        break;
                    case 2:
                        String vl = JOptionPane.showInputDialog("Digite o valor que você deseja remover!");
                        tree.remove(Integer.parseInt(vl));
                        break;
                    case 3:
                        JOptionPane.showMessageDialog(null, "Os valores serão exibidos no console!");
                        tree.showRoot();
                        break;
                    case 4:
                        JOptionPane.showMessageDialog(null, "Os valores serão exibidos no console!");
                        System.out.println("Ordem simétrica:");
                        tree.inOrder(0);
                        System.out.println("");
                        break;
                    case 5:
                        JOptionPane.showMessageDialog(null, "Os valores serão exibidos no console!");
                        System.out.println("Pré-ordem:");
                        tree.preOrder(0);
                        System.out.println("");
                        break;
                    case 6:
                        JOptionPane.showMessageDialog(null, "Os valores serão exibidos no console!");
                        System.out.println("Pós-ordem:");
                        tree.postOrder(0);
                        System.out.println("");
                        break;
                }
            }
        }
    }

    public static String showMenu() {
        String result = JOptionPane.showInputDialog("" +
                "Digite:" +
                "\n 1: Para inserir " +
                "\n 2: Para remover" +
                "\n 3: Para exibir a raiz " +
                "\n 4: Para exibir ordem simétrica " +
                "\n 5: Para exibir pré-ordem " +
                "\n 6: Para exibir pós-ordem " +
                "\n 0: Para sair");

        if (result == null) {
            result = "";
        }

        return result;
    }
}
