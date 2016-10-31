package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Cliente;

public class ClienteDAO {
        public static List<Cliente> obterClientes() throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<Cliente> clientes = new ArrayList<Cliente>();        
        try {
            conexao = BDMini.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from cliente");
            while (rs.next()) {
                Cliente cliente = new Cliente(rs.getInt("codigo"),                     
                        rs.getString("nome"));                  
                        clientes.add(cliente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return clientes;
    }
    
        public static Cliente obterCliente(int codigo) throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        Cliente cliente = null;
        try {
            conexao = BDMini.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from cliente where codigo = " + codigo);
            rs.first();
            cliente = new Cliente(rs.getInt("codigo"),
                    rs.getString("nome"));
                    //NULL PARA SER SETADO
                //turma.setMatriculaProfessorCoordenador(rs.getInt("professorCoordenador")); CASO TENHA CHAVE ESTRANGEIRA
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            fecharConexao(conexao , comando);
        }
        return cliente;
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
    
        public static void gravar(Cliente cliente) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        try {
            conexao = BDMini.getConexao();
            String sql = "insert into cliente (codigo , nome ) values (?,?)";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, cliente.getCodigo());
            comando.setString(2, cliente.getNome());
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
