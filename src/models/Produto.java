package models;
import exceptions.EstoqueInsuficienteException;

public class Produto {
    private String nome;
    private double preco;
    private int estoque;

    public Produto(String nome, double preco, int estoque) {
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
    }

    public double getPreco() {
        return preco;
    }

    public String getNome() {
        return nome;
    }

    public int getEstoque() {
        return estoque;
    }

    public void vender(int quantidade) throws EstoqueInsuficienteException {
        if (quantidade > estoque)
            throw new EstoqueInsuficienteException("Estoque insuficiente para a venda.");
        estoque -= quantidade;
    }

    public void reporEstoque(int quantidade)
    {
        estoque += quantidade;
    }

    // Método para exibir as informações do produto
    public void exibirProduto() {
        System.out.println("Nome: " + nome);
        System.out.println("Preço: R$ " + preco);
        System.out.println("Quantidade em estoque: " + estoque);
        System.out.println("------------------------------");
    }
}
