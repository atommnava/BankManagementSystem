package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

/*
 * @brief La clase Login es el principal archivo en el que se estara guiando al usuario desde la ventana principal de un sistema de banco,
 *        con el propósito de manejar un cuenta bancaria, la cual involucra una mayor fluidez y eficiencia para una cuenta bancaria. Estas son las opciones a las que
 *        el usuario puede adentrarse con la acción de un click.
 *        A) 'SIGN IN'. En orden para ingresar a su cuenta bancaria,
 *            el cliente cuenta con dos espacios con lo cual, llenara con sus credenciales: 
 *            1. No. de tarjeta
 *            2. PIN
 *        B) 'SIGN UP'. Un sistema para el manejo de una cuenta bancaria no funciona en caso de no integrar con una opción de registro,
 *            con base a lo anterior, el usuario será trnasferido a una nueva ventana con la cual se le solicitaran algunos datos personales.
 *        C) 'CLEAR'. Una simple función que le ofrece al usuario la posibilidad de limpiar el espacio para la entrada de datos bancarios en la
 *            entrada principal
 *            
 *       
 * @author Atom Alexander M. Nava
 * @date 16/08/24
 */


public class Login extends JFrame implements ActionListener {

    // Variables globales
    JButton login, signUp, clear;
    JTextField cardTextField;
    JPasswordField pinTextField;

    /*
     * @brief Constructor 'Login' que crea la ventana principal, con la impletación de labels, text-fields y botones.
     * @author Atom Alexander M. Nava
     * @date 16/08/24
     */
    Login(){
        setTitle("ATM");
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.png"));
        Image i2 = i1.getImage().getScaledInstance(225,100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(525,10,225,100);
        add(label);

        JLabel text = new JLabel("Welcome User");
        text.setForeground(Color.white);
        text.setFont(new Font("Times New Roman",Font.BOLD,48));
        text.setBounds(120, 40, 400, 40);
        add(text);

        JLabel cardNo = new JLabel("Card No: ");
        cardNo.setForeground(Color.white);
        cardNo.setFont(new Font("Times New Roman",Font.BOLD,28));
        cardNo.setBounds(120,  150,  150,  30);
        add(cardNo);

        cardTextField = new JTextField();
        cardTextField.setBounds(300, 150, 230, 30);
        cardTextField.setFont(new Font("Arial", Font.CENTER_BASELINE,14));
        add(cardTextField);

        JLabel pin = new JLabel("PIN: ");
        pin.setForeground(Color.white);
        pin.setFont(new Font("Times New Roman", Font.BOLD,28));
        pin.setBounds(120, 220, 250, 40);
        add(pin);

        pinTextField = new JPasswordField();
        pinTextField.setBounds(300, 220, 230, 30);
        pinTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(pinTextField);

        login = new JButton("SIGN IN");
        login.setBounds(300, 300, 100, 30);
        login.setBackground(Color.WHITE);
        login.setForeground(Color.BLACK);
        login.addActionListener(this);
        add(login);

        clear = new JButton("CLEAR");
        clear.setBounds(430, 300, 100, 30);
        clear.setBackground(Color.WHITE);
        clear.setForeground(Color.BLACK);
        clear.addActionListener(this);
        add(clear);

        signUp = new JButton("SIGN UP");
        signUp.setBounds(300, 350, 230, 30);
        signUp.setBackground(Color.WHITE);
        signUp.setForeground(Color.BLACK);
        signUp.addActionListener(this);
        add(signUp);

        ImageIcon i12 = new ImageIcon(ClassLoader.getSystemResource("icons/card.png"));
        Image i22 = i12.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
        ImageIcon i32 = new ImageIcon(i22);
        JLabel label2 = new JLabel(i32);
        label2.setBounds(630,350,100,100);
        add(label2);

        ImageIcon i13 = new ImageIcon(ClassLoader.getSystemResource("icons/backbg.png"));
        Image i23 = i13.getImage().getScaledInstance(850,480, Image.SCALE_DEFAULT);
        ImageIcon i33 = new ImageIcon(i23);
        JLabel label3 = new JLabel(i33);
        label3.setBounds(0,0,850,480);
        add(label3);

        setSize(800, 480);
        setVisible(true);
        setLocation(350, 200);
    }

    @Override
    /* @brief La clase login implementa la interfaz 'ActionListener' en orden para responder a eventos,
     *        con base a la acción del usuario, sabremos si desea ingersar con sus credenciales o registrarse.
     * 
     * @param e. Parámetro e funciona para responder a eventos diferentes a los que el usuario tiene acceso.
     * @author Atom Alexander M. Nava
     * @date 16/08/24
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == clear) {
            cardTextField.setText("");
            pinTextField.setText("");
        } else if (e.getSource() == login) {
            Conn conn = new Conn();
            String cardNumber = cardTextField.getText();
            String pinNumber = pinTextField.getText();
            String query = "select * from login where cardNumber = '" +cardNumber+
                    "' and pin = '"+pinNumber+"'";
            try {
                ResultSet rs = conn.s.executeQuery(query);
                if (rs.next()) {
                    setVisible(false);
                    new Transactions(pinNumber).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Card Number");
                }
            } catch(Exception ex) {
                System.out.println(ex);
            }

        } else if (e.getSource() == signUp) {
            setVisible(false);
            new SignupOne().setVisible(true);
        }

    }
    /*
     * @brief Método principal. Función donde corre el programa principal e implementa todas las funciones
     *                          del sistema de banco.
     * @param args. Punto de entrada
     * @author Atom Alexander M. Nava
     * @date 16/08/24
     */
    public static void main(String[] args) {
        new Login();
    }

}
