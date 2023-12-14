package Compras;

import java.math.BigDecimal;

public class ItemCarrinho {


    private Produto produto;
    private int quantidade;

    public ItemCarrinho(Produto produto, int quantidade) {
        if (produto == null) throw new IllegalArgumentException("Produto inválido: null");
        if (quantidade==0) throw new IllegalArgumentException("Quantidade inválida: 0");
        if (quantidade<0) throw new IllegalArgumentException("Quantidade inválida: -1");
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public ItemCarrinho(Produto produto) {
        this(produto,1);
    }

    public Produto getProduto(){
        return this.produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public BigDecimal getTotal(){
        return this.produto.getPreco().multiply(new BigDecimal(this.quantidade));
    }

    public void incrementar(int quantidade) {
        if (quantidade<0) throw new IllegalArgumentException("Valor inválido: -1");
        this.quantidade+=quantidade;
    }

    public void setQuantidade(int quant) {
        if (quant<0) throw new IllegalArgumentException("Valor inválido: -1");
        this.quantidade = quant;
    }
}
