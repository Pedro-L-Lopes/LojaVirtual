package services;

import exceptions.EstoqueInsuficienteException;
import models.Carrinho;
import models.Produto;

import java.util.List;
import java.util.Scanner;

// Classe responsável por gerenciar a adição de produtos ao carrinho de compras
public class CarrinhoService {
    private final Carrinho carrinho;
    private final List<Produto> produtosDisponiveis;
    private final Scanner scanner;

    public CarrinhoService(Carrinho carrinho, List<Produto> produtosDisponiveis, Scanner scanner) {
        this.carrinho = carrinho;
        this.produtosDisponiveis = produtosDisponiveis;
        this.scanner = scanner;
    }

    public void adicionarProdutosAoCarrinho() throws EstoqueInsuficienteException {
        String opcao;

        do {
            // Mostrar produtos disponíveis
            System.out.println("\nProdutos disponíveis:");
            for (Produto produto : produtosDisponiveis) {
                System.out.printf("- %s (R$%.2f, Estoque: %d)\n", produto.getNome(), produto.getPreco(), produto.getEstoque());
            }

            // Adicionar produto ao carrinho
            System.out.println("Digite o nome do produto que deseja adicionar ao carrinho:");
            String nomeProduto = scanner.nextLine();
            Produto produtoSelecionado = null;

            // Buscar produto selecionado
            for (Produto p : produtosDisponiveis) {
                if (p.getNome().equalsIgnoreCase(nomeProduto)) {
                    produtoSelecionado = p;
                    break;
                }
            }

            if (produtoSelecionado != null) {
                System.out.println("Digite a quantidade:");
                int quantidade = Integer.parseInt(scanner.nextLine());

                // Verifica se há estoque suficiente
                if (quantidade <= produtoSelecionado.getEstoque()) {
                    carrinho.adicionarItem(produtoSelecionado, quantidade); // Adiciona ao carrinho
                    produtoSelecionado.vender(quantidade); // Atualiza o estoque do produto
                    System.out.printf("Adicionado %d de %s ao carrinho.\n", quantidade, produtoSelecionado.getNome());
                } else {
                    System.out.println("Estoque insuficiente para a quantidade solicitada.");
                }
            } else {
                System.out.println("Produto não encontrado.");
            }

            // Perguntar se o usuário deseja continuar
            System.out.println("Deseja adicionar mais produtos ao carrinho? (s/n)");
            opcao = scanner.nextLine();
        } while (opcao.equalsIgnoreCase("s"));
    }
}
