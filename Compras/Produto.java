package Compras;

import java.math.BigDecimal;
import java.util.Objects;

public class Produto {

    private String codigo;
    private String nome;
    private BigDecimal preco;


    public Produto(String codigo) {
        this(codigo,"");
    }

    public Produto(String codigo, String nome) {
        this(codigo,nome,BigDecimal.valueOf(0.0));
    }

    public Produto(String codigo, String nome, BigDecimal preco) {
        if (codigo == null) throw new IllegalArgumentException("O código do produto não pode ser null");
        if (codigo.trim().isEmpty()) throw new IllegalArgumentException("O código do produto não pode ser vazio");
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
    }

    public String getCodigo() {
        return codigo;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null) throw new IllegalArgumentException("O nome do produto não pode ser null");
        if (nome.matches("\\d+")) throw new IllegalArgumentException("O nome do produto não pode conter apenas números");
        if (nome.trim().isEmpty()) throw new IllegalArgumentException("O nome do produto não pode conter apenas espaços vazios");
        this.nome = nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }


    public void setPreco(String preco){
        if (preco == null) throw new IllegalArgumentException("O valor do produto não pode se null");
        this.setPreco(new BigDecimal(preco));
    }

    public void setPreco(BigDecimal preco) {
        if (preco == null) throw new IllegalArgumentException("O valor do produto não pode se null");
        if (preco.compareTo(BigDecimal.ZERO)<0) throw new IllegalArgumentException("O valor do produto não pode ser negativo");
        this.preco = preco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return getCodigo().equals(produto.getCodigo()) && Objects.equals(getCodigo(), produto.getCodigo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCodigo(), getCodigo());
    }
}
