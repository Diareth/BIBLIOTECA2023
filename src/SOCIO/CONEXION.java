
package SOCIO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class CONEXION {
    private final String BD="";
    private final String URL="jdbc:mysql://localhost:3306/"+BD;
    private final String user="root";
    private final String password="";
    private final String socio="com.mysql.cj.jdbc.Driver";
    connection cx;

    public CONEXION(connection cx) {
        this.cx = cx;
    }
    
     public Connection conectar()
    {
        try {
            Class.forName(socio);
            cx = (connection)(Connection)DriverManager.getConnection(this.URL, this.user, this.password);
            System.out.println("SE CONECTO A BD "+BD);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("NO SE CONECTO A BD "+BD);
        }
        return (Connection) cx;
    }
    
    public void desconectar()
     {
         cx.close();
    }
    
    public static void main(String[] args) {
        Conexion cn = new Conexion();
        cn.conectar();
    }
    
    
}