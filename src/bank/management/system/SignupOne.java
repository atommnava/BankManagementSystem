package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

/*
 * @brief La clase 'SignupOne' implementa en menor proporción la parte gráfica y se enfoca más en la
 *        entrada de datos personales. Los datos quedan registrados en la base datos para que se pueda
 *        acceder a ellos posteriormente. 
 *        
 *        Nota:
 *        En el README especifico que para la entrada de datos para la fecha de nacimiento integro la librería
 *        'jcalendar.jar', con el fin de ahorrar timepo y recursos.
 * @author Atom Alexander M. Nava
 * @date 16/08/24
 */

public class SignupOne extends JFrame implements ActionListener {

    //Variables globales
    JTextField nameTextField, fnameTextField, dobTextField, emailTextField,
            addressTextField, cityTextField, stateTextField, pinCTextField;
    JButton next;
    JRadioButton male, female, other, married, unmarried;
    JDateChooser dateChooser;

    //Código para generar el número del formulario aleatorio
    Random ran = new Random();
    long random = Math.abs((ran.nextLong() % 9000L) + 1000L);
    String first = "" + Math.abs(random);

    SignupOne()
    {
        setLayout(null);
        
        JLabel formNo = new JLabel("APPLICATION FORM NO. " + random);
        formNo.setFont(new Font("Raleway", Font.BOLD, 38));
        formNo.setBounds(140, 20, 600, 40);
        add(formNo);

        JLabel personalDetails = new JLabel("Page 1: Personal Details");
        personalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        personalDetails.setBounds(290, 80, 400, 30);
        add(personalDetails);

        JLabel name = new JLabel("Name:");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100, 140, 100, 30);
        add(name);

        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        nameTextField.setBounds(300, 140, 400, 30);
        add(nameTextField);

        JLabel fName = new JLabel("Father´s Name:");
        fName.setFont(new Font("Raleway", Font.BOLD, 20));
        fName.setBounds(100, 190, 200, 30);
        add(fName);

        fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        fnameTextField.setBounds(300, 190, 400, 30);
        add(fnameTextField);

        JLabel dob = new JLabel("Date of Birth:");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100, 240, 200, 30);
        add(dob);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(300,240,200,30);
        dateChooser.setForeground(new Color(105,105,105));
        add(dateChooser);

        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100, 290, 200, 30);
        add(gender);

        male = new JRadioButton("Male");
        male.setBounds(300, 290, 120, 30);
        male.setBackground(Color.WHITE);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(450, 290, 120, 30);
        female.setBackground(Color.WHITE);
        add(female);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);

        JLabel email = new JLabel("Email Address:");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100, 340, 200, 30);
        add(email);

        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        emailTextField.setBounds(300, 340, 400, 30);
        add(emailTextField);

        JLabel maritalS = new JLabel("Marital Status:");
        maritalS.setFont(new Font("Raleway", Font.BOLD, 20));
        maritalS.setBounds(100, 390, 200, 30);
        add(maritalS);

        married = new JRadioButton("Married");
        married.setBounds(300, 390, 100, 30);
        married.setBackground(Color.WHITE);
        add(married);

        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(450, 390, 100, 30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);

        other = new JRadioButton("Other");
        other.setBounds(630, 390, 100, 30);
        other.setBackground(Color.WHITE);
        add(other);

        ButtonGroup maritalGroup = new ButtonGroup();
        maritalGroup.add(married);
        maritalGroup.add(unmarried);
        maritalGroup.add(other);

        JLabel address = new JLabel("Address:");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(100, 440, 200, 30);
        add(address);

        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        addressTextField.setBounds(300, 440, 400, 30);
        add(addressTextField);

        JLabel city = new JLabel("City:");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100, 490, 200, 30);
        add(city);

        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        cityTextField.setBounds(300, 490, 400, 30);
        add(cityTextField);

        JLabel state = new JLabel("State:");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100, 540, 200, 30);
        add(state);

        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        stateTextField.setBounds(300, 540, 400, 30);
        add(stateTextField);

        JLabel pinC = new JLabel("PIN Code:");
        pinC.setFont(new Font("Raleway", Font.BOLD, 20));
        pinC.setBounds(100, 590, 200, 30);
        add(pinC);

        pinCTextField = new JTextField();
        pinCTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        pinCTextField.setBounds(300, 590, 400, 30);
        add(pinCTextField);

        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.BLACK);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 660, 80, 30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);
        setSize(850,800);
        setLocationRelativeTo(null);
        setVisible(true);

    }
    /*
     * @brief Implementación de la interfaz 'ActionListener' para responder a los eventos del usuario.
     *        Obtención de los datos para la primera página. Utilizando las funciones .getText() tanto getDateEditor()
     *        es como podremos almacenar temporalmente losd datos registrados en la base de datos de la página 1.
     * @param e. Parámetro 'e' sin usos.
     * @author Atom Alexander M. Nava
     * @date 16/08/24
     */
    public void actionPerformed(ActionEvent e)
    {
        String formNo = "" + random;
        String name = nameTextField.getText();
        String fname = fnameTextField.getText();
        String dob = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if (male.isSelected()) {
            gender = "Male";
        } else if(female.isSelected()) {
            gender = "Female";
        }

        String email = emailTextField.getText();
        String marital = null;
        if (married.isSelected()) {
            marital = "Married";
        } else if(unmarried.isSelected()) {
            marital = "Unmarried";
        } else if(other.isSelected()) {
            marital = "Other";
        }

        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String pinC = pinCTextField.getText();

        // Enlace con la base de datos y un query para insertar los datos de la página 1
        try {
            if (name.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter your name");
            } else {
                Conn c = new Conn();
                String query = "insert into signup values('" +
                        formNo + "', '" + name + "', '" + fname + "', '" + dob + "', '" + gender + "', '" + email + "', '" + marital + "', '" + address + "', '" + city + "', '" + state + "',  '" + pinC + "')";
                c.s.executeUpdate(query);

                setVisible(false);
                new SignupTwo(formNo).setVisible(true);
            }
        } catch(Exception ex) {
            System.out.println(ex);
        }
    }

    /*
     * @brief Método principal para desplegar la página 1, con su propia ventana independiente
     *        a las otras clases para que sea más dinámico con el usuario.
     * @author Atom Alexander M. Nava
     * @date 16/08/24
     */
    public static void main(String[] args) {
        new SignupOne();
    }
}
