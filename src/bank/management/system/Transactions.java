package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * @brief La clase 'Transactions' requiere la interfaz 'ActionListener' para manipular el cajero a propósito de realizar movimientos
 *        bancarios en la cuenta del cliente. Esta clase conecta la parte gráfica con el sistema de cajero ATM, que cuenta con la ayuda de
 *        las clases para el correcto funcionamiento de un sistema de cajero ATM, añadiendole mayor realismo al programa.
 * @author Atom Alexander M. Nava
 * @date 17/08/24
 */
public class Transactions extends JFrame implements ActionListener {

    //Variables globales
    JButton deposit, withdrawl, miniStatement, pinChange,
    fastCash, balanceenQuiry, exit;
    String pinNumber;
    /*
     * @brief Constructor 'Transactions' para la creación del cajero ATM que jugara el papel importante como intermediario
     *        para llevar a cabo todas las funcionalidades, con el fin de realizar movimientos para una cuenta bancaria.
     * @param formNo. Su funcionalidad es para llevar el correcto manejo de las cuentas de banco en función de su
     *                número de formulario.
     * @author Atom Alexander M. Nava
     * @date 17/08/24
     */
    Transactions(String pinNumber){
        this.pinNumber = pinNumber;
        setLayout(null);

        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("Please select your Transaction");
        text.setBounds(215,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);

        deposit = new JButton("Deposit");
        deposit.setBounds(170,415,150,30);
        deposit.addActionListener(this);
        image.add(deposit);

        withdrawl = new JButton("Cash Withdrawl");
        withdrawl.setBounds(355,415,150,30);
        withdrawl.addActionListener(this);
        image.add(withdrawl);

        fastCash = new JButton("Fast Cash");
        fastCash.setBounds(170,450,150,30);
        fastCash.addActionListener(this);
        image.add(fastCash);

        miniStatement = new JButton("Mini Statement");
        miniStatement.setBounds(355,450,150,30);
        miniStatement.addActionListener(this);
        image.add(miniStatement);

        pinChange = new JButton("Pin Change");
        pinChange.setBounds(170,485,150,30);
        pinChange.addActionListener(this);
        image.add(pinChange);

        balanceenQuiry = new JButton("Balanceen Quiry");
        balanceenQuiry.setBounds(355,485,150,30);
        balanceenQuiry.addActionListener(this);
        image.add(balanceenQuiry);

        exit = new JButton("Exit");
        exit.setBounds(355,520,150,30);
        exit.addActionListener(this);
        image.add(exit);

        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    /*
     * @brief Implemetación de la interfaz 'ActionListener' para llevar a cabo todas las funcionalidades del sistema
     *        de cajero ATM para que el usuario realice movimientos en su cuenta.
     * @param e. Parámetro e para responder a los eventos del usuario.
     * @author Atom Alexander M. Nava
     * @date 17/08/24
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == exit){
            System.exit(0);
        } else if (e.getSource() == deposit){
            setVisible(false);
            new Deposit(pinNumber).setVisible(true);
        } else if (e.getSource() == withdrawl){
            setVisible(false);
            new Withdrawl(pinNumber).setVisible(true);
        } else if (e.getSource() == fastCash){
            setVisible(false);
            new FastCash(pinNumber).setVisible(true);
        } else if (e.getSource() == pinChange){
            setVisible(false);
            new PinChange(pinNumber).setVisible(true);
        } else if (e.getSource() == balanceenQuiry){
            setVisible(false);
            new BalanceEnquiry(pinNumber).setVisible(true);
        } else if (e.getSource() == miniStatement){
            new MiniStatement(pinNumber).setVisible(true);
        }
    }
    /*
     * @brief Método principal para ejecutar la operación para realizar movimientos accesibles en la cuenta del cliente.
     * @author Atom Alexander M. Nava
     * @date 17/08/24
     */
    public static void main(String[] args) {
        new Transactions("");
    }
}
