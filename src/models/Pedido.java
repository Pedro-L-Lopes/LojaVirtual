package models;
import java.time.LocalDateTime;
import services.interfaces.IPagamentos;
import exceptions.PagamentoException;

public class Pedido {
    private Cliente cliente;             // Cliente que realizou o pedido
    private Carrinho carrinho;           // Carrinho associado ao pedido, contendo os itens
    private LocalDateTime data;          // Data e hora em que o pedido foi realizado
    private IPagamentos pagamentoService; // Interface para o serviço de pagamento

    public Pedido(Cliente cliente, Carrinho carrinho, IPagamentos pagamentoService) {
        this.cliente = cliente;
        this.carrinho = carrinho;
        this.data = LocalDateTime.now();
        this.pagamentoService = pagamentoService;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public LocalDateTime getData() {
        return data;
    }
}

