package modelo;

import dao.ProdutoDAO;
import java.sql.SQLException;
import java.util.List;

public class Produto {

    private int codigo;
    private String nome;
    private float preco;
    private float quantidade;

    public Produto(int codigo, String nome, float preco, float quantidade) {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public float getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(float quantidade) {
        this.quantidade = quantidade;
    }

    public static Produto obterProduto(int codigo) throws ClassNotFoundException {
        return ProdutoDAO.obterProduto(codigo);
    }

    public static List<Produto> obterProdutos() throws ClassNotFoundException {
        return ProdutoDAO.obterProdutos();
    }

    public void gravar() throws SQLException, ClassNotFoundException {
        ProdutoDAO.gravar(this);
    }
    
    public void alterar() throws SQLException,ClassNotFoundException {
        ProdutoDAO.alterar(this);
    }
    
    public void excluir() throws SQLException, ClassNotFoundException {
        ProdutoDAO.excluir(this);
    }
}
