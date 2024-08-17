package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

/*
 * @brief La clase 'MiniStatement' funciona de manera un poco similar la clase 'BalanceEnquiry'. Simplemente que en esta te informa
 *        con un breve resúmen respecto a los movimientos realizandos en tu cuenta, es decir, que te informara sobre todos lo que suceda en tu cuenta. 
 *        Esto proporciona un forma rápida y eficiente para el manejo de tu la cuenta del cliente.
 * @author Atom Alexander M. Nava
 * @date 17/08/24
 */
public class MiniStatement extends JFrame {
    //Variables globales
    String pinNumber;
    /*
     * @brief Constructor 'MiniStatement' recrea la parte gráfica con un diseño simple pero eficiente que representa el mini resúmen
     *        de los movimientos que se han registrado a nombre de la cuenta del cliente, con lo cual, el usuario podra visualizar todos
     *        los movimientos que se hayan llevado a cabo anteriormente.
     * @param formNo. Su funcionalidad es para llevar el correcto manejo de las cuentas de banco en función de su
     *                número de formulario.  
     * @author Atom Alexander M. Nava
     * @date 17/08/24
     */
    MiniStatement(String pinNumber){
        this.pinNumber = pinNumber;
        setTitle("Mini Statement");
        setLayout(null);

        JLabel mini = new JLabel();
        add(mini);

        JLabel bank = new JLabel("World Bank");
        bank.setBounds(150,20,100,20);
        add(bank);

        JLabel card = new JLabel();
        card.setBounds(20,80,300,20);
        add(card);

        JLabel balance = new JLabel();
        balance.setBounds(20,400,300,20);
        add(balance);

        try {
            // Conexión con la base de datos MySQL
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from login where pin = '" + pinNumber + "'");
            // Label para desplegar la información de la tarjeta del cliente, a fin de que el mismo compruebe
            // que la información proporcionada es verídica.
            while (rs.next()) {
                card.setText("Card Number: " + rs.getString("cardnumber").substring(0,4) + " XXXX" + " XXXX " +
                        rs.getString("cardnumber").substring(12));
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }

        try {
            // Conexión con la base de datos MySQL por segunda vez, para ver de manera transparente y eficeinte
            // los movimientos realizados.
            Conn conn = new Conn();
            int bal = 0;
            ResultSet rs = conn.s.executeQuery("select * from bank where pin = '" + pinNumber + "'");
            while (rs.next()) {
                mini.setText(mini.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
                        rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
                        rs.getString("amount") + "<br><br><html>");
                if (rs.getString("type").equals("Deposit")) {
                    bal += Integer.parseInt(rs.getString("amount"));
                } else {
                    bal -= Integer.parseInt(rs.getString("amount"));
                }
            }
            balance.setText("Your current Account balance is Ds $" + bal);
        } catch (Exception ex2) {
            System.out.println(ex2);
        }

        mini.setBounds(20,140,400,200);

        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }
    /*
     * @brief Método principal en donde se ejecutara la funcionalidad para la rápida visualización de los movimientos 
     *        realizados en la cuenta del cliente.
     * @author Atom Alexander M. Nava
     * @date 17/08/24
     */
     
    public static void main(String[] args) {
        new MiniStatement("");
    }
}
