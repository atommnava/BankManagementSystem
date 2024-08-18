package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.*;
import java.util.*;

/*
 * @brief Clase 'FastCash' ofrece la posibilidad al cliente de una rápida y eficiente manera de desembolsar efectivo para una ocación
 *        esporadica, es una funcionalidad interesante y destacada que tienen los cajeros ATM de hoy en día.
 *        El programa le da libertad al clietnre para que retire cantidades hormiga, como son las siguientes:
 *        1. $ 100      4. $2,000
 *        2. $ 500      5. $5,000
 *        3. $ 1,000    6. $10,000
 *        Depsues de que el cliente haya tomado una decisíon, se le enviar un mensaje al cliente, 
 *        indicando si la orden se realizo con éxito.
 * @author Atom Alexander M. Nava
 * @date 17/08/24
 */
public class FastCash extends JFrame implements ActionListener {

    // Variables globales
    JButton deposit, withdrawl, miniStatement, pinChange,
            fastCash, balanceenQuiry, exit;
    String pinNumber;
    /*
     * @brief Constructor 'FastCash' que desarrolla la parte gráfica para el usuario, en orden para realizar movimientos en el cajero
     *        ATM, el cliente tiene la posibilidad de desembolsar poco dinero.
     * @param formNo. Su funcionalidad es para llevar el correcto manejo de las cuentas de banco en función de su
     *                número de formulario. 
     * @author Atom Alexander M. Nava
     * @date 17/08/24
     */
    FastCash(String pinNumber){
        this.pinNumber = pinNumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("SELECT WITHDRAWL AMOUNT");
        text.setBounds(215,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);

        deposit = new JButton("Ds 100");
        deposit.setBounds(170,415,150,30);
        deposit.addActionListener(this);
        image.add(deposit);

        withdrawl = new JButton("Ds 500");
        withdrawl.setBounds(355,415,150,30);
        withdrawl.addActionListener(this);
        image.add(withdrawl);

        fastCash = new JButton("Ds 1000");
        fastCash.setBounds(170,450,150,30);
        fastCash.addActionListener(this);
        image.add(fastCash);

        miniStatement = new JButton("Ds 2000");
        miniStatement.setBounds(355,450,150,30);
        miniStatement.addActionListener(this);
        image.add(miniStatement);

        pinChange = new JButton("Ds 5000");
        pinChange.setBounds(170,485,150,30);
        pinChange.addActionListener(this);
        image.add(pinChange);

        balanceenQuiry = new JButton("Ds 10000");
        balanceenQuiry.setBounds(355,485,150,30);
        balanceenQuiry.addActionListener(this);
        image.add(balanceenQuiry);

        exit = new JButton("BACK");
        exit.setBounds(355,520,150,30);
        exit.addActionListener(this);
        image.add(exit);

        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    /* 
     * @brief Implementación de la interfaz 'ActionListener'.
     *        Estructura del código con la que funciona la parte gráfica con el sistema de cajero,
     *        con el cual el cliente tendra la libertad de retirar una cantidad pequeña de efectivo. 
     * @author Atom Alexander M. Nava
     * @date 17/08/24
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exit){
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        } else {
            String amount = ((JButton)e.getSource()).getText().substring(3); // 500 Ds

            // Conexión con la base de datos MySQL
            Conn c = new Conn();
            try {
                ResultSet rs = c.s.executeQuery("select * from bank where pin = '" + pinNumber + "'");
                int balance = 0;
                while (rs.next()) {
                    if (rs.getString("type").equals("Deposit")) {
                        balance += Integer.parseInt(rs.getString("amount"));
                    } else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }

                if (e.getSource() != exit && balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null, "insufficient balance");
                    return;
                }
                // Obtención de la fecha en que se expidió la orden
                Date date = new Date(System.currentTimeMillis());
                String query = "insert into bank values('" + pinNumber + "', '" + date + "', 'Withdrawl', '" + amount + "')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Ds " + amount + " Debited Successfully");

                setVisible(false);
                new Transactions(pinNumber).setVisible(true);
            } catch (Exception e1) {
                System.out.println(e1);
            }
        }
    }
     /*
     * @brief Método principal en donde se ejecutara la funcionalidad para la visualización  
     *        de las diferentes opciones a las que el cliente puede acceder.
     * @author Atom Alexander M. Nava
     * @date 17/08/24
     */
    public static void main(String[] args) {
        new FastCash("");
    }
}
