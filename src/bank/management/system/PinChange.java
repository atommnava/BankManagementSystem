package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * @brief Clase 'PinChange' ofrece la opción de cambiar el PIN de la tarjeta del usuario. La clase integra la parte gráfica
 *        la del cajero, proporcinando una estilo más realista. El usuario visualizara dos campos en el que se le solicitara
 *        que ingrese el nuevo PIN reemplazara el anterior PIN. A continuación, se le solicita al cliente que ingrese nuevamente
 *        el nuevo PIN, esta funcionalidad sa ha integrado con el tiempo en todos los cajeros ATM.
 *        
 *        La aplicación valida que se encuentre rellenado el campo donde el cliente ingresa el nuevo PIN, así como tambien que
 *        el campo donde reescribes el PIN valida que no este vacío y que ambos campos coincidan.
 * @author Atom Alexander M. Nava
 * @date 18/08/24
 */
public class PinChange extends JFrame implements ActionListener {
    // Variables globales
    JPasswordField pin, rePin;
    JButton change, back;
    String pinNumber;
    /*
     * @brief Constructor 'PinChange' extiende la parte gráfica para el desarrollo de la ventana con los campos requeridos
     *        para el cambio de PIN. Estos son de tipo 'JPasswordField', un cambio relevante y que añade un atisbo de privacidad
     *        y seguridad para los clientes.
     * @author Atom Alexander M. Nava
     * @date 18/08/24
     */
    PinChange(String pinNumber){
        this.pinNumber = pinNumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(250, 280, 500, 35);
        image.add(text);

        JLabel pinText = new JLabel("New PIN:");
        pinText.setForeground(Color.WHITE);
        pinText.setFont(new Font("System", Font.BOLD, 16));
        pinText.setBounds(165, 320, 180, 25);
        image.add(pinText);

        pin = new JPasswordField();
        pin.setFont(new Font("Raleway", Font.BOLD, 25));
        pin.setBounds(330, 320, 180, 25);
        image.add(pin);

        JLabel rePinText = new JLabel("Re-Enter New PIN:");
        rePinText.setForeground(Color.WHITE);
        rePinText.setFont(new Font("System", Font.BOLD, 16));
        rePinText.setBounds(165, 360, 180, 25);
        image.add(rePinText);

        rePin = new JPasswordField();
        rePin.setFont(new Font("Raleway", Font.BOLD, 25));
        rePin.setBounds(330, 360, 180, 25);
        image.add(rePin);

        change = new JButton("CHANGE");
        change.setBounds(355,485,150,30);
        change.addActionListener(this);
        image.add(change);

        back = new JButton("BACK");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);

        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    /*
     * @brief Implementación de la interfaz 'ActionListener' para llevar a cabo el cambio de PIN de la tarjeta.
     *        A fin de cambiar el PIN de la tarjeta el usuario debe haber verificado que haya lenado ambos campos 
     *        y que el PIN coincida, en este momento, el cliente debe pulsar el boton 'Change'. El PIN quedara registrado
     *        en la tarjeta y modificado sin corromper la integridad de la cuenta del cliente.
     * @param e. Parámetro 'e' trabaja con e botón 'Change', cuando este es pulsado sabemos que es cuando el cliente 
     *        desea realizar la orden para el cambio de PIN.
     * @author Atom Alexander M. Nava
     * @date 18/08/24
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == change) {
            try {
                String newPin = pin.getText();
                String rPin = rePin.getText();

                if (!newPin.equals(rPin)) {
                    JOptionPane.showMessageDialog(null, "PIN does not match");
                    return;
                }

                if (newPin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please, enter PIN");
                    return;
                }

                if (rPin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please, Re-Enter New PIN");
                    return;
                }

                // Conexión con la base de datos MySQL
    
                Conn conn = new Conn();

                // Sobreescribe los datos del PIN de la tarjeta en particular sin corromper la integridad de la cuenta.
                // Además, debe actualizar el PIN en la base de datos, especificamente en las mesas 'bank', 'login' y 'signupthree' ,
                // en estas se encuentra el valor del PIN de cada tarjeta.

                String query1 = "update bank set pin = '" + rPin + "' where pin = '" + pinNumber + "'";
                String query2 = "update login set pin = '" + rPin + "' where pin = '" + pinNumber + "'";
                String query3 = "update signupthree set pin = '" + rPin + "' where pin = '" + pinNumber + "'";

                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                conn.s.executeUpdate(query3);

                JOptionPane.showMessageDialog(null, "PIN Changed Successfully");
                setVisible(false);
                new Transactions(rPin).setVisible(true);

            } catch (Exception ex) {
                System.out.println(ex);
            }
        } else {
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }
    }

    /*
     * @brief Método principal en donde se ejecutara la funcionalidad de la clase 'PinChange'. Para llevar a cabo el proceso
     *        para el cambio de PIN, necesitamos la ayuda del cliente para que ingrese el nuevo PIN que reemplazara al anterior.
     * @author Atom Alexander M. Nava
     * @date 18/08/24
     */
    public static void main(String[] args) {
        new PinChange("").setVisible(true);
    }
}
