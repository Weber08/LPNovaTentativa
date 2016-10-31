package modelo;

import dao.UnidadeDAO;
import java.sql.SQLException;
import java.util.List;

public class Unidade {
    private int codigo;
    private String descricao;

    public Unidade(int codigo, String descricao) {
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
    
        public static Unidade obterUnidade(int codigo) throws ClassNotFoundException {
        return UnidadeDAO.obterUnidade(codigo);
    }

    public static List<Unidade> obterUnidades() throws ClassNotFoundException {
        return UnidadeDAO.obterUnidades();
    }

    public void gravar() throws SQLException, ClassNotFoundException {
        UnidadeDAO.gravar(this);
    }
}
