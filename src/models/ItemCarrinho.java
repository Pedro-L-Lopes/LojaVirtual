package models;

public class ItemCarrinho {
    private Produto produto; //Produto associado ao item do carrinho
    private final int quantidade; //Quantidade do produto no carrinho

    public ItemCarrinho(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }
}

