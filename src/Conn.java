package bank.management.system;

import java.sql.*;

public class Conn {

    Connection c;
    Statement s;
    public Conn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/bankmanagementsystem", "root", "");
            s = c.createStatement();
        } catch(Exception e) {
            System.out.println("Error al conectar con la base de datos: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
