package services.pagamentosService;

import exceptions.PagamentoException;
import services.pagamentosService.BoletoService;
import services.pagamentosService.CartaoCreditoService;
import services.interfaces.IPagamentos;
import java.util.Scanner;

public class MetodoPagamentoService {
    private final Scanner scanner;

    public MetodoPagamentoService(Scanner scanner) {
        this.scanner = scanner;
    }

    public IPagamentos escolherMetodoPagamento(double total) {
        System.out.println("Escolha a forma de pagamento:");
        System.out.println("1 - Cartão de Crédito");
        System.out.println("2 - Boleto");

        String escolhaPagamento = scanner.nextLine();
        IPagamentos metodoPagamento;

        switch (escolhaPagamento) {
            case "1":
                metodoPagamento = new CartaoCreditoService(); // Usar Cartão de Crédito
                break;
            case "2":
                metodoPagamento = new BoletoService(); // Usar Boleto
                break;
            default:
                System.out.println("Forma de pagamento inválida. Usando Cartão de Crédito por padrão.");
                metodoPagamento = new CartaoCreditoService(); // Usar Cartão de Crédito como padrão
                break;
        }

        // Processar pagamento
        try {
            if (metodoPagamento.processarPagamento(total)) {
                System.out.println("Pagamento processado com sucesso!");
            }
        } catch (PagamentoException e) {
            System.out.println("Erro ao processar pagamento: " + e.getMessage());
        }

        return metodoPagamento; // Retorna o método de pagamento selecionado
    }
}
