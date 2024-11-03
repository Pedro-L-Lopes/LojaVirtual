package models;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {
    // Lista que armazenará os itens adicionados ao carrinho
    private List<ItemCarrinho> itens = new ArrayList<>();

    // Classe interna para representar um item no carrinho e sua quantidade
    public static class ItemCarrinho {
        private Produto produto; // Produto associado ao item no carrinho
        private int quantidade;  // Quantidade desse produto

        // Construtor para inicializar o item do carrinho com um produto e sua quantidade
        public ItemCarrinho(Produto produto, int quantidade) {
            this.produto = produto;
            this.quantidade = quantidade;
        }

        // Método para obter o produto associado a este item
        public Produto getProduto() {
            return produto;
        }

        // Método para obter a quantidade deste item
        public int getQuantidade() {
            return quantidade;
        }
    }

    // Método para adicionar um item ao carrinho
    public void adicionarItem(Produto produto, int quantidade) {
        itens.add(new ItemCarrinho(produto, quantidade)); // Cria um novo ItemCarrinho e adiciona à lista
    }

    // Método para calcular o total do carrinho somando o preço de cada item multiplicado pela sua quantidade
    public double calcularTotal() {
        double total = 0;
        for (ItemCarrinho item : itens) {
            total += item.getProduto().getPreco() * item.getQuantidade(); // Soma o preço total de todos os itens
        }
        return total; // Retorna o total calculado
    }

    // Método para obter a lista de itens do carrinho
    public List<ItemCarrinho> obterItens() {
        return itens; // Retorna a lista de itens
    }
}
