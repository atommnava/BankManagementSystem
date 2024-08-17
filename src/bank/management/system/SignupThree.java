package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

/*
 * @brief La clase 'SignupThre', representada por la página 3, despliega los campos finales a llenar para
 *        la entrega de la tarjeta bancaria con terminación XXXX-XXXX-XXXX-NNNN, además de proporcionar el PIN.
 *        Únicamente habra que llenar los campos vacíos con la información de la cuenta y los servicios requeridos.
 *        Al final, cuando el usuario se cercioro de que toda la información completada sea correcta, se le desplegara su
 *        su número de tarjeta con su PIN
 * @author Atom Alexander M. Nava
 * @date 17/08/24
 */
public class SignupThree extends JFrame implements ActionListener {

    //Variables gloables
    JRadioButton r1, r2, r3, r4;
    JCheckBox c1, c2, c3, c4, c5, c6, c7;
    JButton submit, cancel;
    String formNo;
    /*
     * @brief Constructor 'SignupThree' para la construcción de una ventana mayor, formulario final para la obtención 
     *        de los datos de la cuenta bancaria.
     * @param formNo. Su funcionalidad es para llevar el correcto manejo de las cuentas de banco en función de su
     *                número de formulario.
     * @author Atom Alexander M. Nava
     * @date 17/08/24
     */
    SignupThree(String formNo){
        this.formNo = formNo;
        setLayout(null);
        JLabel i1 = new JLabel("Page 3: Account Details");
        i1.setFont(new Font("Raleway", Font.BOLD, 22));
        i1.setBounds(280, 40, 400, 40);
        add(i1);

        JLabel type = new JLabel("Account Type");
        type.setFont(new Font("Raleway", Font.BOLD, 22));
        type.setBounds(100, 140, 200, 30);
        add(type);

        r1 = new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway", Font.BOLD, 16));
        r1.setBackground(Color.WHITE);
        r1.setBounds(100, 180, 200, 20);
        add(r1);

        r2 = new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Raleway", Font.BOLD, 16));
        r2.setBackground(Color.WHITE);
        r2.setBounds(350, 180, 250, 20);
        add(r2);

        r3 = new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway", Font.BOLD, 16));
        r3.setBackground(Color.WHITE);
        r3.setBounds(100, 220, 200, 20);
        add(r3);

        r4 = new JRadioButton("Recurring deposit Account");
        r4.setFont(new Font("Raleway", Font.BOLD, 16));
        r4.setBackground(Color.WHITE);
        r4.setBounds(350, 220, 300, 20);
        add(r4);

        ButtonGroup groupAccount = new ButtonGroup();
        groupAccount.add(r1);
        groupAccount.add(r2);
        groupAccount.add(r3);
        groupAccount.add(r4);

        JLabel card = new JLabel("Card Number");
        card.setFont(new Font("Raleway", Font.BOLD, 22));
        card.setBounds(100, 300, 200, 30);
        add(card);

        JLabel number = new JLabel("XXXX-XXXX-XXXX-6432");
        number.setFont(new Font("Raleway", Font.BOLD, 22));
        number.setBounds(330, 300, 300, 30);
        add(number);

        JLabel cardDetail = new JLabel("Your 16 Digit Card Number");
        cardDetail.setFont(new Font("Raleway", Font.BOLD, 12));
        cardDetail.setBounds(100, 330, 300, 20);
        add(cardDetail);

        JLabel pin = new JLabel("PIN");
        pin.setFont(new Font("Raleway", Font.BOLD, 22));
        pin.setBounds(100, 370, 200, 30);
        add(pin);

        JLabel pNumber = new JLabel("XXXX");
        pNumber.setFont(new Font("Raleway", Font.BOLD, 22));
        pNumber.setBounds(330, 380, 300, 30);
        add(pNumber);

        JLabel pinDetail = new JLabel("Your 4 Digit Password");
        pinDetail.setFont(new Font("Raleway", Font.BOLD, 12));
        pinDetail.setBounds(100, 400, 300, 20);
        add(pinDetail);

        JLabel services = new JLabel("Services Required");
        services.setFont(new Font("Raleway", Font.BOLD, 18));
        services.setBounds(100, 450, 200, 30);
        add(services);

        c1 = new JCheckBox("ATM CARD");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway", Font.BOLD, 16));
        c1.setBounds(100,500,200,30);
        add(c1);

        c2 = new JCheckBox("Interest Banking ");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway", Font.BOLD, 16));
        c2.setBounds(350,500,200,30);
        add(c2);

        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway", Font.BOLD, 16));
        c3.setBounds(100,550,200,30);
        add(c3);

        c4 = new JCheckBox("EMAIL & SMS Alerts");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway", Font.BOLD, 16));
        c4.setBounds(350,550,200,30);
        add(c4);

        c5 = new JCheckBox("Cheque Book");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway", Font.BOLD, 16));
        c5.setBounds(100,600,200,30);
        add(c5);

        c6 = new JCheckBox("E-Statement");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Raleway", Font.BOLD, 16));
        c6.setBounds(350,600,200,30);
        add(c6);

        c7 = new JCheckBox("I Hereby declares that the entered details are correct to the" +
                "best of my knowledge.");
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Raleway", Font.BOLD, 15));
        c7.setBounds(100,680,700,30);
        add(c7);

        submit = new JButton("Submit");
        submit.setBackground(Color.white);
        submit.setForeground(Color.black);
        submit.setFont(new Font("Raleway", Font.BOLD, 14));
        submit.setBounds(250,720,100,30);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBackground(Color.white);
        cancel.setForeground(Color.RED);
        cancel.setFont(new Font("Raleway", Font.BOLD, 14));
        cancel.setBounds(400,720,100,30);
        cancel.addActionListener(this);
        add(cancel);

        getContentPane().setBackground(Color.white);

        setSize(850, 820);
        setLocation(350, 0);
        setVisible(true);
    }

    /*
     * @brief Implementación de la interfaz 'ActionListener' en orden para responder a eventos. Al contar con una experiencia 
     *        personalizada para el usuario, deberá especificar el tipo de cuenta que se está manejando, (esta información también
     *        se guardara en la base de datos) las opciones son:
     *        1. Saving Account
     *        2. Fixed Deposit Account
     *        3. Current Account
     *        4. Recurring Deposit Account
     * @param e. Implementamos el boton 'Submit' a fin de añadir por último el beneficio de la duda al cliente para en caso de retractarse.
     * @author Atom Alexander M. Nava
     * @date 17/08/24
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            String accountType = null;
            if (r1.isSelected()) {
                accountType = "Saving Account";
            } else if (r2.isSelected()) {
                accountType = "Fixed Deposit Account";
            } else if (r3.isSelected()) {
                accountType = "Current Account";
            } else if (r4.isSelected()) {
                accountType = "Recurring Deposit Account";
            }
            // Código para generar el número de la tarjeta y el PIN aleatoriamente
            Random random = new Random();
            String cardNumber = "" + Math.abs((random.nextLong() % 90000000L) + 5040936000000000L);
            String pinNumber = "" + Math.abs((random.nextLong() % 9000L) + 1000L);
            String facility = "";

            if (c1.isSelected()) {
                facility = facility + "ATM CARD";
            } else if (c2.isSelected()) {
                facility = facility + "Interest Banking";
            } else if (c3.isSelected()) {
                facility = facility + "Mobile Banking";
            } else if (c4.isSelected()) {
                facility = facility + "EMAIL & SMS Alerts";
            } else if (c5.isSelected()) {
                facility = facility + "Cheque Book";
            } else if (c6.isSelected()) {
                facility = facility + "E-Statement";
            }
            try {
                if (accountType.equals("")) {
                    JOptionPane.showMessageDialog(null, "Account Type is required...");
                } else {
                    //Conexión con la base de datos MySQL
                    Conn conn = new Conn();
                    String queryl = "insert into signupthree values('" + formNo + "', '" + accountType + "', '" + cardNumber + "', '" + pinNumber + "', '" + facility + "')";
                    String queryl2 = "insert into login values('" + formNo + "', '" + cardNumber + "', '" + pinNumber + "')";
                    conn.s.executeUpdate(queryl);
                    conn.s.executeUpdate(queryl2);
                    //Insertar los datos de la mesa 'signuptwo' y 'signupthree' 
                    JOptionPane.showMessageDialog(null, "Card Number " + cardNumber +
                            "\n Pin: " + pinNumber);

                    setVisible(false);
                    new Deposit(pinNumber).setVisible(false);
                }
            } catch(Exception ex) {
                System.out.println(ex);
            }
        } else if (e.getSource() == cancel) {
            setVisible(false);
            new Login().setVisible(true);
        }
    }

    /*
     * @brief Método principal para ejecutar todo el código de la clase 'SignupThree' a fin de la obtención
     *        de los datos finales para proporcionar el número de tarjeta y PIN
     * @author Atom Alexander M. Nava
     * @date 17/08/24
     */
    public static void main(String[] args) {
      new SignupThree("");
        System.out.println();
    }

}
