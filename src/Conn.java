package bank.management.system;

import java.sql.*;
/*
 * @brief La clase 'Conn' integra la funcionaldiad para conectar la parte de código con
 *        la base de datos MySQL. Esto le proporciona al proyecto un enfoque más realista en
 *        tanto a la parte para guardar los datos de los clientes.
 * @author Atom Alexander M. Nava
 * @date 16/08/24
 */

public class Conn {

    Connection c;
    Statement s;
    /*
     * @brief Constructor 'Conn' para realzar la conexión con la base de datos
     *        Usando una conexión y un estado para hacer posible el enlace entre estas plataformas.
     * @author Atom Alexander M. Nava
     * @date 16/08/24
     */
    public Conn() {
        try {
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanagementsystem", "root", "");
            s = c.createStatement();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
