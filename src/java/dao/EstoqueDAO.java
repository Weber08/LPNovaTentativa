package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
                        rs.getString("unidade"),
                        rs.getString("marca"),
                        rs.getString("fornecedor"),
                        rs.getInt("dataDeCompra"),
                        rs.getInt("vencimento"));                  
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
                    rs.getString("unidade"),
                    rs.getString("marca"),
                    rs.getString("fornecedor"),
                    rs.getInt("dataDeCompra"),
                    rs.getInt("vencimento"));
                    //NULL PARA SER SETADO
                //turma.setMatriculaProfessorCoordenador(rs.getInt("professorCoordenador")); CASO TENHA CHAVE ESTRANGEIRA
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            fecharConexao(conexao , comando);
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
            String sql = "insert into estoque (codigo , nome , preco , quantidade ,unidade , marca , fornecedor , dataDeCompra , vencimento ) values (?,?,?,?,?,?,?,?,?)";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, estoque.getCodigo());
            comando.setString(2, estoque.getNome());
            comando.setFloat(3, estoque.getPreco());
            comando.setFloat(4, estoque.getQuantidade());
            comando.setString(5,estoque.getUnidade());
            comando.setString(6, estoque.getMarca());
            comando.setString(7, estoque.getFornecedor());
            comando.setInt(8, estoque.getDataDeCompra());
            comando.setInt(9, estoque.getVencimento());
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
}
