
package br.com.infox.dal;
import java.sql.*;

public class ModuloConexao {
    public static Connection conector(){
        java.sql.Connection conexao = null;
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/infox";
        String user = "root";
        String senha = "";
        
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url,user,senha);
            return conexao;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}
