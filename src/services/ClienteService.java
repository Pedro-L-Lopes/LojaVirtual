package services;

import models.Cliente;
import java.util.Scanner;

// Classe responsável pelo serviço de cadastro de clientes
public class ClienteService {
    private final Scanner scanner; // Scanner para capturar entrada do usuário

    // Construtor que recebe um scanner para interações com o usuário
    public ClienteService(Scanner scanner) {
        this.scanner = scanner;
    }

    // Método para cadastrar um novo cliente
    public Cliente cadastrarCliente() {
        Cliente cliente = new Cliente();
        while (true) {
            // Solicita os dados do cliente
            System.out.println("Informe os seus dados ");
            System.out.println("Nome completo: ");
            String nome = scanner.nextLine();

            System.out.println("Endereço completo: ");
            String endereco = scanner.nextLine();

            try {
                cliente.cadastroCliente(nome, endereco); // Tenta cadastrar o cliente
                return cliente; // Retorna o cliente cadastrado se os dados estiverem corretos
            } catch (Exception e) {
                // Exibe mensagem de erro e solicita novos dados caso ocorra uma exceção
                System.out.println(e.getMessage());
                System.out.println("Por favor, insira os dados novamente.\n");
            }
        }
    }
}
