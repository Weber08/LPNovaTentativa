package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Produto;

public class ProdutoDAO {
    public static List<Produto> obterProdutos() throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<Produto> produtos = new ArrayList<Produto>();        
        try {
            conexao = BDMini.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from produto");
            while (rs.next()) {
                Produto produto = new Produto(rs.getInt("codigo"),                     
                        rs.getString("nome"));                  
                        produtos.add(produto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return produtos;
    }
    
        public static Produto obterProduto(int codigo) throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        Produto produto = null;
        try {
            conexao = BDMini.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from produto where codigo = " + codigo);
            rs.first();
            produto = new Produto(rs.getInt("codigo"),
                    rs.getString("nome"));
                    //NULL PARA SER SETADO
                //turma.setMatriculaProfessorCoordenador(rs.getInt("professorCoordenador")); CASO TENHA CHAVE ESTRANGEIRA
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            fecharConexao(conexao , comando);
        }
        return produto;
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
    
        public static void gravar(Produto produto) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        try {
            conexao = BDMini.getConexao();
            String sql = "insert into produto (codigo , nome ) values (?,?)";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, produto.getCodigo());
            comando.setString(2, produto.getNome());
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