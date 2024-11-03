package models;

public class Cliente {
    private String nome;
    private String endereco;

    public String clienteNome() {
        return nome;
    }

    public void cadastroCliente(String nome, String endereco) throws Exception {
        if (nome.length() < 5) {
            throw new Exception("O nome precisa ser completo (mínimo de 10 caracteres).");
        }
        if (endereco.length() < 10) {
            throw new Exception("O endereço precisa ser completo (mínimo de 10 caracteres).");
        }

        this.nome = nome;
        this.endereco = endereco;
    }
}
