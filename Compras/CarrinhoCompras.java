package Compras;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

public class CarrinhoCompras {

    private Map<String,ItemCarrinho> itens = new LinkedHashMap<>();


    public void addProduto(Produto produto, int quantidade){
        if (produto == null) throw new IllegalArgumentException("Argumento inválido: produto = null");
        if (quantidade < 0) throw new IllegalArgumentException("Argumento inválido: quantidade = -1");

        ItemCarrinho item = itens.get(produto.getCodigo());
        if (item == null) itens.put(produto.getCodigo(), new ItemCarrinho(produto, quantidade));
        else item.setQuantidade(item.getQuantidade() + quantidade);
    }

    public void addProduto(Produto produto) {
        addProduto(produto, 1);
    }

    public void setQuantidade(String codProduto, int quant){
        if (quant<0) throw new IllegalArgumentException("Quantidade inválida: -1");
        if (codProduto == null) throw new IllegalArgumentException("Código de produto inválido: null");
        try {
            this.itens.get(codProduto).setQuantidade(quant);
        }catch (Exception e){
            for (ItemCarrinho itemCarrinho :this.itens.values()){
                if (!itemCarrinho.getProduto().getCodigo().equalsIgnoreCase(codProduto))
                    throw new CarrinhoComprasException("Não deve ser possível definir uma quantidade para um produto que não está no carrinho"+e.getMessage());
            }
        }


    }

    public Produto removerProduto(String codProduto){
        Produto produto = new Produto(codProduto);
        this.itens.remove(produto.getCodigo());
        return produto;
    }

    public int getQuantidadeItens(){
        return this.itens.size();
    }

    public BigDecimal getTotal(){
        BigDecimal total = BigDecimal.valueOf(0);
        for(ItemCarrinho item: itens.values()){
            total = total.add(item.getTotal());
        }
        return total;
    }

    public ItemCarrinho getItem(String codProduto) {
        return itens.get(codProduto);
    }

    public boolean existe(String codProduto) {
        if (this.itens.containsKey(codProduto)) return true;
        return false;
    }
}