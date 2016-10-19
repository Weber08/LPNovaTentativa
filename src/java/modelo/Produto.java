package modelo;

import dao.ProdutoDAO;
import java.sql.SQLException;
import java.util.List;

public class Produto {

    private int codigo;
    private String nome;

    public Produto(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
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

    public static void obterProduto(int codigo) throws ClassNotFoundException {
        ProdutoDAO.obterProduto(codigo);
    }

    public static List<Produto> obterProdutos() throws ClassNotFoundException {
        return ProdutoDAO.obterProdutos();
    }

    public void gravar() throws SQLException, ClassNotFoundException {
        ProdutoDAO.gravar(this);
    }
}
