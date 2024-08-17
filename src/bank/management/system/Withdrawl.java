package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

/*
 * @brief La clase 'Withdrawl' representa el desembolso de dinero que se realizara a la cuenta en particular, la cantidad ingresada desde teclado por el cliente será lo que se restarade la cuenta.
 *        Similar a la clase 'Deposit' cuenta con un botón 'Back' para continuar realizando operaciones.
 * @author Atom Alexander M. Nava
 * @date 17/08/24
 */
public class Withdrawl extends JFrame implements ActionListener {
    // Variables globales
    JTextField amount;
    JButton withdraw, back;
    String pinNumber;
    /*
     * @brief Constructor 'Withdrawl' en donde se dirige al cliente a una ventana diferente con la posibilidad de ingresar una cantidad
     *        'valida' a desembolsar en su cuenta. El usuario puede retractarse  en cualquer momento de la operación y cancelarlo pulsando el botón 'back'
     * @param formNo. Su funcionalidad es para llevar el correcto manejo de las cuentas de banco en función de su
     *                número de formulario.  
     * @author Atom Alexander M. Nava
     * @date 17/08/24
     */
    Withdrawl(String pinNumber){
        this.pinNumber = pinNumber;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("Enter the amount you want to withdrawl");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(170,300,400,20);
        image.add(text);

        amount = new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD, 22));
        amount.setBounds(170,350,320,25);
        image.add(amount);

        withdraw = new JButton("Withdraw");
        withdraw.setBounds(355,485,150,30);
        withdraw.addActionListener(this);
        image.add(withdraw);

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
     *        El desembolso se almacena temporalmente con la fecha de expedición, estos datos quedan
     *        registrados en nuestra base con el tipo de movimiento que se realizo, en este caso 'Desembolso'.
     * @param e. Botón 'withdrawl' para responder a la orden del usuario
     * @author Atom Alexander M. Nava
     * @date 17/08/24
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == withdraw) {
            String number = amount.getText();
            Date date = new Date();
            if (number.equals("")) {
                JOptionPane.showMessageDialog(null, "Please, enter an available amount to deposit");
            } else {
                try {
                    //Conexión con MySQL
                    Conn conn = new Conn();
                    String query = "insert into bank values('" + pinNumber + "', '" + date + "', 'Withdrawl',  '" + number + "')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Ds " + number + " Withdraw successfully");
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
     * @brief Método principal para ejecutar la funcionalidad de la clase 'Withdrawl'.
     * @author Atom Alexander M. Nava
     * @date 17/08/24
     */
    public static void main(String[] args) {
        new Withdrawl("");
    }

}
