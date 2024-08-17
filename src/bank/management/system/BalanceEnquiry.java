package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

/*
 * @brief Clase 'BalanceEnquiery' proporciona el balance actual del cliente. Lo mantiene informado sobre el balance de cuenta.
 *        Esta clase lleva a cabo dos funciones principales:
 *        1. Depósito
 *        2. Desembolso
 *        Cuando el cliente desea ver su balance se despliega desde una variable local el balance, se suma la cantidad que se
 *        deposito o que se haya desembolsado, en caso de este, se resta.
 * @author Atom Alexander M. Nava
 * @date 17/08/24
 */
public class BalanceEnquiry extends JFrame implements ActionListener {
    //Variables globales
    JButton back;
    String pinNumber;
    /*
     * @brief Constructor 'BalanceEnquiry' para visualizar la parte gráfica con el cajero ATM, en este se despliegara
     *        el balanace actual de la cuenta.
     * @param formNo. Su funcionalidad es para llevar el correcto manejo de las cuentas de banco en función de su
     *                número de formulario. 
     * @author Atom Alexander M. Nava
     * @date 17/08/24
     */
    BalanceEnquiry(String pinNumber){
        this.pinNumber = pinNumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        back = new JButton("Back");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);

        //Conexión con MySQL
        Conn c = new Conn();
        int balance = 0;
        try {
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '" + pinNumber + "'");
            while (rs.next()) {
                // Acción para depositar
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                }
                // Acción para desembolsar
                else 
                {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        } catch (Exception ex) {
                System.out.println(ex);
            }
        JLabel text = new JLabel("Your Current Account Balance is: Ds " + balance);
        text.setForeground(Color.WHITE);
        text.setBounds(170,300, 400, 30);
        image.add(text);

        setSize(900,900);
        setLocation(300,0);
        setVisible(true);

    }
    /*
     * @brief Método principal para ejecutar la funcionalidad de la clase 'BalanceEnquiry'.
     * @author Atom Alexander M. Nava
     * @date 17/08/24
     */
    public static void main(String[] args) {
        new BalanceEnquiry("");
    }

     /*
     * @brief Implementación de la interfaz 'Action Listener'.
     *        Se deja de visualizar la ventana actual y se reedirige a la ventana principal.
     * @param e. Sin uso.
     * @author Atom Alexander M. Nava
     * @date 17/08/24
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Transactions(pinNumber).setVisible(true);
    }
}
