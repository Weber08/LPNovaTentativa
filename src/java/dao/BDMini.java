package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
        
public class BDMini {
       public static Connection getConexao()
               throws ClassNotFoundException, SQLException{
           Connection conexao = null;
           Class.forName("com.mysql.jdbc.Driver");
           conexao = DriverManager.getConnection
                   ("jdbc:mysql://localhost/minilanche", "root", "");
           return conexao;
       } 
}
