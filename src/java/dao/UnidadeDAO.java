package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Unidade;

public class UnidadeDAO {

    public static List<Unidade> obterUnidades() throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<Unidade> unidades = new ArrayList<Unidade>();
        try {
            conexao = BDMini.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from unidade");
            while (rs.next()) {
                Unidade unidade = new Unidade(rs.getInt("codigo"),
                        rs.getString("descricao"));
                unidades.add(unidade);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return unidades;
    }

    public static Unidade obterUnidade(int codigo) throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        Unidade unidade = null;
        try {
            conexao = BDMini.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from unidade where codigo = " + codigo);
            rs.first();
            unidade = new Unidade(rs.getInt("codigo"),
                    rs.getString("descricao"));
            //NULL PARA SER SETADO
            //turma.setMatriculaProfessorCoordenador(rs.getInt("professorCoordenador")); CASO TENHA CHAVE ESTRANGEIRA
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return unidade;
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

    public static void gravar(Unidade unidade) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        try {
            conexao = BDMini.getConexao();
            String sql = "insert into unidade (codigo , descricao ) values (?,?)";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, unidade.getCodigo());
            comando.setString(2, unidade.getDescricao());
            /* if (curso.getCoordenador() == null){ CASO TENHA CHAVE ESTRANGEIRA
                comando.setNull(6 , Types.NULL);
            }else {
                comando.setInt(6, curso.getCoordenador().getMatricula());
            }*/
            comando.execute();
            comando.close();
            conexao.close();

        } catch (SQLException e) {
            throw e;
        }
    }

    public static void alterar(Unidade unidade) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        try {
            conexao = BDMini.getConexao();
            String sql = "update unidade set descricao = ? where codigo = ?";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1, unidade.getDescricao());
            comando.setInt(2, unidade.getCodigo());
            comando.execute();
            comando.close();
            conexao.close();

        } catch (SQLException e) {
            throw e;
        }
    }

}
