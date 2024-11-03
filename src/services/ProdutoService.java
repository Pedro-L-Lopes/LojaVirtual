package services;

import models.Produto;

import java.util.ArrayList;
import java.util.List;

public class ProdutoService {

    public static List<Produto> listarProdutos(){
        // Criar produtos disponíveis
        List<Produto> produtosDisponiveis = new ArrayList<>();
        produtosDisponiveis.add(new Produto("Camiseta", 49.99, 10));
        produtosDisponiveis.add(new Produto("Calça", 89.99, 5));
        produtosDisponiveis.add(new Produto("Moleton", 149.99, 5));
        produtosDisponiveis.add(new Produto("Chapelão", 79.99, 5));

        return produtosDisponiveis;
    }

}
