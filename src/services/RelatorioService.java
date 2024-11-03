package services;
import models.*;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class RelatorioService {
    private final List<Pedido> pedidos = new ArrayList<>();
    private final List<Produto> produtosDisponiveis;

    public RelatorioService(List<Produto> produtosDisponiveis) {
        this.produtosDisponiveis = produtosDisponiveis;
    }

    // Registrar pedido finalizado para o relatório de vendas
    public void registrarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    // Gera relatório de vendas, exibindo detalhes de cada pedido
    public void gerarRelatorioVendas() {
        // Define o formato desejado
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        System.out.println("\nRelatório de Vendas:");
        for (Pedido pedido : pedidos) {
            // Formata a data de acordo com o padrão especificado
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

    // Gera inventário, exibindo o estoque atual de cada produto
    public void gerarInventario() {
        System.out.println("\nInventário de Produtos:");
        for (Produto produto : produtosDisponiveis) {
            produto.exibirProduto();
        }
    }
}
