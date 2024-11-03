package services.pagamentosService;
import services.interfaces.IPagamentos;
import exceptions.PagamentoException;

// Implementação do serviço de pagamento via boleto
public class BoletoService implements IPagamentos {
    // Sobrescreve o método da interface IPagamentos
    @Override
    public boolean processarPagamento(double valor) throws PagamentoException {
        // Verifica se o valor é menor ou igual a zero
        if (valor <= 0) {
            throw new PagamentoException("Erro no pagamento com boleto: valor inválido."); // Lança exceção com mensagem apropriada
        }
        // Simula a geração do boleto
        System.out.println("Boleto gerado para o valor de: " + valor);
        return true; // Retorna true se o pagamento for processado com sucesso
    }
}