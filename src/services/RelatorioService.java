package services;

import models.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

// Serviço responsável pela geração de relatórios de vendas e inventário de produtos
public class RelatorioService {
    private final List<Pedido> pedidos = new ArrayList<>(); // Lista de pedidos concluídos
    private final List<Produto> produtosDisponiveis; // Lista de produtos disponíveis na loja

    public RelatorioService(List<Produto> produtosDisponiveis) {
        this.produtosDisponiveis = produtosDisponiveis;
    }

    // Registra um pedido finalizado para inclusão no relatório de vendas
    public void registrarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    // Gera e exibe o relatório de vendas, detalhando cada pedido registrado
    public void gerarRelatorioVendas() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"); // Formato da data

        System.out.println("\nRelatório de Vendas:");
        for (Pedido pedido : pedidos) {
            String dataFormatada = pedido.getData().format(formatter);
            System.out.printf("Cliente: %s | Data: %s | Total: R$%.2f\n",
                    pedido.getCliente().clienteNome(), dataFormatada, pedido.getCarrinho().calcularTotal());
            System.out.println("Itens:");
            for (Carrinho.ItemCarrinho item : pedido.getCarrinho().obterItens()) {
                System.out.printf(" - %s: %d unidades\n", item.getProduto().getNome(), item.getQuantidade());
            }
            System.out.println("----------------------------");
        }
    }

    // Gera e exibe o inventário, mostrando o estoque atual de cada produto
    public void gerarInventario() {
        System.out.println("\nInventário de Produtos:");
        for (Produto produto : produtosDisponiveis) {
            produto.exibirProduto();
        }
    }
}
