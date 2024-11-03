package services;

import models.Produto;
import java.util.ArrayList;
import java.util.List;

// Classe responsável por gerenciar a lista de produtos disponíveis na loja
public class ProdutoService {

    // Método que retorna uma lista de produtos disponíveis
    public static List<Produto> listarProdutos() {
        // Cria e adiciona produtos à lista
        List<Produto> produtosDisponiveis = new ArrayList<>();
        produtosDisponiveis.add(new Produto("Camiseta", 49.99, 10));
        produtosDisponiveis.add(new Produto("Calça", 89.99, 5));
        produtosDisponiveis.add(new Produto("Moleton", 149.99, 5));
        produtosDisponiveis.add(new Produto("Chapelão", 79.99, 5));

        return produtosDisponiveis; // Retorna a lista de produtos
    }
}
