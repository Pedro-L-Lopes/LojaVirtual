package services.interfaces;
import exceptions.PagamentoException;

public interface IPagamentos {
    // Método para processar pagamento de um valor específico, com possibilidade de lançar uma exceção de pagamento
    boolean processarPagamento(double valor) throws PagamentoException;
}

