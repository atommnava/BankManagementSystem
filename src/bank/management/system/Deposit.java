package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

/*
 * @brief La clase 'Deposit' acumula a lo sumo la cantidad ingresada desde teclado por el cliente, el programa comprueba que el cliente
 *        haya ingresado una cantidad en teclado $. Para continuar, el usuario debe pulsar el botón 'back' para ser redirigido al inicio.
 * @author Atom Alexander M. Nava
 * @date 17/08/24
 */
public class Deposit extends JFrame implements ActionListener {

    //Variables globales
    JTextField amount;
    JButton deposit, back;
    String pinNumber;

    /*
     * @brief Constructor 'Deposit' en donde se dirige al cliente a una ventana diferente con la posibilidad de ingresar una cantidad
     *        'valida' a depositar en su cuenta. El usuario puede salir de la retractarse de la acción de depositar pulsando el botón 'back'
     * @param formNo. Su funcionalidad es para llevar el correcto manejo de las cuentas de banco en función de su
     *                número de formulario.  
     * @author Atom Alexander M. Nava
     * @date 17/08/24
     */
    Deposit(String pinNumber){
        this.pinNumber = pinNumber;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("Enter the amount you want to deposit");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(170,300,400,20);
        image.add(text);

        amount = new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD, 22));
        amount.setBounds(170,350,320,25);
        image.add(amount);

        deposit = new JButton("Deposit");
        deposit.setBounds(355,485,150,30);
        deposit.addActionListener(this);
        image.add(deposit);

        back = new JButton("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);

        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
    }
     /*
     * @brief Implementación de la interfaz 'Action Listener'.
     *        El deposito de almacena temporalmente con la fecha de expedición, estos quedan
     *        registrados en la base de datos con el tipo de movimiento que se realizo, en este caso 'Deposito'.
     * @param e. Botón 'deposit' para responder a la orden del usuario
     * @author Atom Alexander M. Nava
     * @date 17/08/24
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == deposit) {
            String number = amount.getText();
            Date date = new Date();
            if (number.equals("")) {
                JOptionPane.showMessageDialog(null, "Please, enter an available amount to deposit");
            } else {
                try {
                    // Conexión con la base de datos MySQL
                    Conn conn = new Conn();
                    String query = "insert into bank values('" + pinNumber + "', '" + date + "', 'Deposit',  '" + number + "')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Ds " + number + " Deposited successfully");
                    setVisible(false);
                    new Transactions(pinNumber).setVisible(true);
                } catch (Exception e1) {
                    System.out.println(e1);
                }
            }
        } else if (e.getSource() == back) {
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }
    }
    /*
     * @brief Método principal para ejecturar la funcionalidad de la clase 'Deposit'.
     * @author Atom Alexander M. Nava
     * @date 17/08/24
     */
    public static void main(String[] args) {
        new Deposit("");
    }

}
