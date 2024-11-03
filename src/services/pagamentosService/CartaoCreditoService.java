package services.pagamentosService;
import exceptions.PagamentoException;
import services.interfaces.IPagamentos;

public class CartaoCreditoService implements IPagamentos {
    @Override
    public boolean processarPagamento(double valor) throws PagamentoException {
        if (valor <= 0) {
            throw new PagamentoException("Erro no pagamento com cartão de crédito.");
        }
        System.out.println("Pagamento com cartão de crédito aprovado para o valor de: " + valor);
        return true;
    }
}
