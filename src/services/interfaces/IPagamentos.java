package services.interfaces;
import exceptions.PagamentoException;

public interface IPagamentos {
    boolean processarPagamento(double valor) throws PagamentoException;
}

