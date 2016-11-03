package modelo;

import dao.ClienteDAO;
import java.sql.SQLException;
import java.util.List;

public class Cliente {
    private int codigo;
    private String nome;

    public Cliente(int codigo, String nome) {
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
    
        public static Cliente obterCliente(int codigo) throws ClassNotFoundException {
        return ClienteDAO.obterCliente(codigo);
    }

    public static List<Cliente> obterClientes() throws ClassNotFoundException {
        return ClienteDAO.obterClientes();
    }

    public void gravar() throws SQLException, ClassNotFoundException {
        ClienteDAO.gravar(this);
    }
    
    public void alterar() throws SQLException, ClassNotFoundException {
        ClienteDAO.alterar(this);
    }
}
