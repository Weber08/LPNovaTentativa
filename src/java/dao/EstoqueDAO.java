package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import modelo.Estoque;

public class EstoqueDAO {

    public static List<Estoque> obterEstoques() throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<Estoque> estoques = new ArrayList<Estoque>();
        try {
            conexao = BDMini.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from estoque");
            while (rs.next()) {
                Estoque estoque = new Estoque(rs.getInt("codigo"),
                        rs.getString("nome"),
                        rs.getFloat("preco"),
                        rs.getFloat("quantidade"),
                        null,
                        rs.getString("marca"),
                        null,
                        rs.getInt("dataDeCompra"),
                        rs.getInt("vencimento"));
                estoque.setCodigoUnidade(rs.getInt("codigoUnidade"));
                estoque.setCodigoFornecedor(rs.getInt("codigoFornecedor"));
                estoques.add(estoque);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return estoques;
    }

    public static Estoque obterEstoque(int codigo) throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        Estoque estoque = null;
        try {
            conexao = BDMini.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from estoque where codigo = " + codigo);
            rs.first();
            estoque = new Estoque(rs.getInt("codigo"),
                    rs.getString("nome"),
                    rs.getFloat("preco"),
                    rs.getFloat("quantidade"),
                    null,
                    rs.getString("marca"),
                    null,
                    rs.getInt("dataDeCompra"),
                    rs.getInt("vencimento"));
            estoque.setCodigoUnidade(rs.getInt("codigoUnidade"));
            estoque.setCodigoFornecedor(rs.getInt("codigoFornecedor"));

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return estoque;
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

    public static void gravar(Estoque estoque) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        try {
            conexao = BDMini.getConexao();
            String sql = "insert into estoque (codigo , nome , preco , quantidade , codigoUnidade ,marca , codigoFornecedor , dataDeCompra , vencimento ) values (?,?,?,?,?,?,?,?,?)";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, estoque.getCodigo());
            comando.setString(2, estoque.getNome());
            comando.setFloat(3, estoque.getPreco());
            comando.setFloat(4, estoque.getQuantidade());
            if (estoque.getUnidade() == null) {
                comando.setNull(5, Types.NULL);
            } else {
                comando.setInt(5, estoque.getUnidade().getCodigo());
            }
            comando.setString(6, estoque.getMarca());
            if (estoque.getFornecedor() == null) {
                comando.setNull(7, Types.NULL);
            } else {
                comando.setInt(7, estoque.getFornecedor().getCodigo());
            }
            comando.setInt(8, estoque.getDataDeCompra());
            comando.setInt(9, estoque.getVencimento());

            comando.execute();
            comando.close();
            conexao.close();

        } catch (SQLException e) {
            throw e;
        }
    }

    public static void alterar(Estoque estoque) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        try {
            conexao = BDMini.getConexao();
            String sql = "update estoque set nome = ?,preco = ?,quantidade = ?,codigoUnidade = ?,marca = ?,codigoFornecedor = ?,dataDeCompra = ?,vencimento = ? where codigo = ?";
            PreparedStatement comando = conexao.prepareStatement(sql);

            comando.setString(1, estoque.getNome());
            comando.setFloat(2, estoque.getPreco());
            comando.setFloat(3, estoque.getQuantidade());
            if (estoque.getUnidade() == null) {
                comando.setNull(4, Types.NULL);
            } else {
                comando.setInt(4, estoque.getUnidade().getCodigo());
            }
            comando.setString(5, estoque.getMarca());
            if (estoque.getFornecedor() == null) {
                comando.setNull(6, Types.NULL);
            } else {
                comando.setInt(6, estoque.getFornecedor().getCodigo());
            }
            comando.setInt(7, estoque.getDataDeCompra());
            comando.setInt(8, estoque.getVencimento());
            comando.setInt(9, estoque.getCodigo());

            comando.execute();
            comando.close();
            conexao.close();

        } catch (SQLException e) {
            throw e;
        }
    }

    public static void excluir(Estoque estoque) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        try {
            conexao = BDMini.getConexao();
            String sql = "delete from estoque where codigo = ?";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, estoque.getCodigo());
            comando.execute();
            comando.close();
            conexao.close();

        } catch (SQLException e) {
            throw e;
        }
    }
}
