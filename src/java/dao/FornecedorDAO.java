package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Fornecedor;

public class FornecedorDAO {

    public static List<Fornecedor> obterFornecedores() throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
        try {
            conexao = BDMini.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from fornecedor");
            while (rs.next()) {
                Fornecedor fornecedor = new Fornecedor(rs.getInt("codigo"),
                        rs.getString("descricao"));
                fornecedores.add(fornecedor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return fornecedores;
    }

    public static Fornecedor obterFornecedor(int codigo) throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        Fornecedor fornecedor = null;
        try {
            conexao = BDMini.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from fornecedor where codigo = " + codigo);
            rs.first();
            fornecedor = new Fornecedor(rs.getInt("codigo"),
                    rs.getString("descricao"));

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return fornecedor;
    }

    public static void fecharConexao(Connection conexao, Statement comando) {
        try {
            if (comando != null) {
                comando.close();
            }
            if (conexao != null) {
                conexao.close();
            }
        } catch (SQLException e) {

        }
    }

    public static void gravar(Fornecedor fornecedor) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        try {
            conexao = BDMini.getConexao();
            String sql = "insert into fornecedor (codigo , descricao ) values (?,?)";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, fornecedor.getCodigo());
            comando.setString(2, fornecedor.getDescricao());

            comando.execute();
            comando.close();
            conexao.close();

        } catch (SQLException e) {
            throw e;
        }
    }

    public static void alterar(Fornecedor fornecedor) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        try {
            conexao = BDMini.getConexao();
            String sql = "update fornecedor set descricao = ? where codigo = ?";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1, fornecedor.getDescricao());
            comando.setInt(2, fornecedor.getCodigo());
            comando.execute();
            comando.close();
            conexao.close();

        } catch (SQLException e) {
            throw e;
        }
    }

    public static void excluir(Fornecedor fornecedor) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        try {
            conexao = BDMini.getConexao();
            String sql = "delete from fornecedor where codigo = ?";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, fornecedor.getCodigo());
            comando.execute();
            comando.close();
            conexao.close();

        } catch (SQLException e) {
            throw e;
        }
    }
}
