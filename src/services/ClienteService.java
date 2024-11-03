package services;

import models.Cliente;

import java.util.Scanner;

public class ClienteService {
    private final Scanner scanner;

    public ClienteService(Scanner scanner) {
        this.scanner = scanner;
    }

    public Cliente cadastrarCliente() {
        Cliente cliente = new Cliente();
        while (true) {
            System.out.println("Informe os seus dados ");
            System.out.println("Nome completo: ");
            String nome = scanner.nextLine();

            System.out.println("Endereço completo: ");
            String endereco = scanner.nextLine();

            try {
                cliente.cadastroCliente(nome, endereco);
                return cliente; // Retorna o cliente cadastrado
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Por favor, insira os dados novamente.\n");
            }
        }
    }
}
