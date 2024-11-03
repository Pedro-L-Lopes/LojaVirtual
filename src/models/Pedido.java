package models;
import java.time.LocalDateTime;
import services.interfaces.IPagamentos;
import exceptions.PagamentoException;

public class Pedido {
    private Cliente cliente;
    private Carrinho carrinho;
    private LocalDateTime data;
    private IPagamentos pagamentoService;

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

