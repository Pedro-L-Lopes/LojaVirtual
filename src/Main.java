import exceptions.*;
import models.*;

import services.*;
import services.interfaces.*;
import services.pagamentosService.*;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws EstoqueInsuficienteException {
        Scanner scanner = new Scanner(System.in);

        List<Produto> produtosDisponiveis = ProdutoService.listarProdutos();
        RelatorioService relatorioService = new RelatorioService(produtosDisponiveis);
        Carrinho carrinho;

        String opcao;
        do {
            System.out.println("\nMenu Principal:");
            System.out.println("1 - Inventário de Produtos");
            System.out.println("2 - Relatório de Vendas");
            System.out.println("3 - Comprar");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    relatorioService.gerarInventario();
                    break;
                case "2":
                    relatorioService.gerarRelatorioVendas();
                    break;
                case "3":
                    // Iniciar nova venda
                    carrinho = new Carrinho();
                    CarrinhoService carrinhoService = new CarrinhoService(carrinho, produtosDisponiveis, scanner);
                    carrinhoService.adicionarProdutosAoCarrinho();
                    // Calcular total
                    double total = carrinho.calcularTotal();
                    System.out.printf("Total do carrinho: R$%.2f\n", total);

                    // Cadastrar cliente usando o ClienteService
                    ClienteService clienteService = new ClienteService(scanner);
                    Cliente cliente = clienteService.cadastrarCliente();

                    // Escolher forma de pagamento usando o MetodoPagamentoService
                    MetodoPagamentoService metodoPagamentoService = new MetodoPagamentoService(scanner);
                    IPagamentos metodoPagamento = metodoPagamentoService.escolherMetodoPagamento(total);

                    // Finaliza o pedido e registra no relatório
                    Pedido pedido = new Pedido(cliente, carrinho, metodoPagamento);
                    relatorioService.registrarPedido(pedido);
                    break;
                case "0":
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (!opcao.equals("0"));

        scanner.close(); // Fechar o scanner após o uso
    }
}
