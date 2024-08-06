package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

import com.toedter.calendar.JDateChooser;

public class SignupOne extends JFrame {
    SignupOne()
    {
        setLayout(null);
        Random ran = new Random();
        long random = Math.abs((ran.nextLong() % 9000L) + 1000L);
        JLabel formNo = new JLabel("APPLICATION FORM NO. " + random);
        formNo.setFont(new Font("Serif", Font.BOLD, 38));
        formNo.setBounds(140, 20, 600, 40);
        add(formNo);

        JLabel personalDetails = new JLabel("Page 1: Personal Details");
        personalDetails.setFont(new Font("Serif", Font.BOLD, 22));
        personalDetails.setBounds(290, 80, 400, 30);
        add(personalDetails);

        JLabel name = new JLabel("Name:");
        name.setFont(new Font("Serif", Font.BOLD, 20));
        name.setBounds(100, 140, 100, 30);
        add(name);

        JTextField nameTextField = new JTextField();
        nameTextField.setFont(new Font("Serif", Font.BOLD, 14));
        nameTextField.setBounds(300, 140, 400, 30);
        add(nameTextField);

        JLabel fName = new JLabel("Father´s Name:");
        fName.setFont(new Font("Serif", Font.BOLD, 20));
        fName.setBounds(100, 190, 200, 30);
        add(fName);

        JTextField fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("Serif", Font.BOLD, 14));
        fnameTextField.setBounds(300, 190, 400, 30);
        add(fnameTextField);

        JLabel dob = new JLabel("Date of Birth:");
        dob.setFont(new Font("Serif", Font.BOLD, 20));
        dob.setBounds(100, 240, 200, 30);
        add(dob);

        JDateChooser dateChooser = new JDateChooser();
        dateChooser.setBounds(300,240,200,30);
        dateChooser.setForeground(new Color(105,105,105));
        add(dateChooser);

        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("Serif", Font.BOLD, 20));
        gender.setBounds(100, 290, 200, 30);
        add(gender);

        JRadioButton male = new JRadioButton("Male");
        male.setBounds(300, 290, 120, 30);
        male.setBackground(Color.WHITE);
        add(male);

        JRadioButton female = new JRadioButton("Female");
        female.setBounds(450, 290, 120, 30);
        female.setBackground(Color.WHITE);
        add(female);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);

        JLabel email = new JLabel("Email Address:");
        email.setFont(new Font("Serif", Font.BOLD, 20));
        email.setBounds(100, 340, 200, 30);
        add(email);

        JTextField emailTextField = new JTextField();
        emailTextField.setFont(new Font("Serif", Font.BOLD, 14));
        emailTextField.setBounds(300, 340, 400, 30);
        add(emailTextField);

        JLabel maritalS = new JLabel("Marital Status:");
        maritalS.setFont(new Font("Serif", Font.BOLD, 20));
        maritalS.setBounds(100, 390, 200, 30);
        add(maritalS);

        JRadioButton married = new JRadioButton("Married");
        married.setBounds(300, 390, 100, 30);
        married.setBackground(Color.WHITE);
        add(married);

        JRadioButton unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(450, 390, 100, 30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);

        JRadioButton other = new JRadioButton("Other");
        other.setBounds(630, 390, 100, 30);
        other.setBackground(Color.WHITE);
        add(other);

        ButtonGroup maritalGroup = new ButtonGroup();
        maritalGroup.add(married);
        maritalGroup.add(unmarried);
        maritalGroup.add(other);

        JLabel address = new JLabel("Address:");
        address.setFont(new Font("Serif", Font.BOLD, 20));
        address.setBounds(100, 440, 200, 30);
        add(address);

        JTextField addressTextField = new JTextField();
        addressTextField.setFont(new Font("Serif", Font.BOLD, 14));
        addressTextField.setBounds(300, 440, 400, 30);
        add(addressTextField);

        JLabel city = new JLabel("City:");
        city.setFont(new Font("Serif", Font.BOLD, 20));
        city.setBounds(100, 490, 200, 30);
        add(city);

        JTextField cityTextField = new JTextField();
        cityTextField.setFont(new Font("Serif", Font.BOLD, 14));
        cityTextField.setBounds(300, 490, 400, 30);
        add(cityTextField);

        JLabel state = new JLabel("State:");
        state.setFont(new Font("Serif", Font.BOLD, 20));
        state.setBounds(100, 540, 200, 30);
        add(state);

        JTextField stateTextField = new JTextField();
        stateTextField.setFont(new Font("Serif", Font.BOLD, 14));
        stateTextField.setBounds(300, 540, 400, 30);
        add(stateTextField);

        JLabel pinC = new JLabel("PIN Code:");
        pinC.setFont(new Font("Serif", Font.BOLD, 20));
        pinC.setBounds(100, 590, 200, 30);
        add(pinC);

        JTextField pinCTextField = new JTextField();
        pinCTextField.setFont(new Font("Serif", Font.BOLD, 14));
        pinCTextField.setBounds(300, 590, 400, 30);
        add(pinCTextField);

        JButton next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.BLACK);
        next.setFont(new Font("Serif", Font.BOLD, 14));
        next.setBounds(620, 660, 80, 30);
        add(next);

        getContentPane().setBackground(Color.WHITE);
        setSize(850,800);
        setLocationRelativeTo(null);
        setVisible(true);

    }
    public static void main(String[] args) {
        new SignupOne();
    }
}
