package modelo;

import dao.FornecedorDAO;
import java.sql.SQLException;
import java.util.List;

public class Fornecedor {

    private int codigo;
    private String descricao;

    public Fornecedor(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public static Fornecedor obterFornecedor(int codigo) throws ClassNotFoundException {
        return FornecedorDAO.obterFornecedor(codigo);
    }

    public static List<Fornecedor> obterFornecedores() throws ClassNotFoundException {
        return FornecedorDAO.obterFornecedores();
    }

    public void gravar() throws SQLException, ClassNotFoundException {
        FornecedorDAO.gravar(this);
    }

    public void alterar() throws SQLException, ClassNotFoundException {
        FornecedorDAO.alterar(this);
    }

    public void excluir() throws SQLException, ClassNotFoundException {
        FornecedorDAO.excluir(this);
    }

}
