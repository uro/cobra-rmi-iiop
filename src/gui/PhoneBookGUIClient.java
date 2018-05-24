package gui;

import zad1.PhoneDirectoryClientFactory;
import zad1.PhoneDirectoryInterface;

import javax.naming.NamingException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.rmi.RemoteException;

public class PhoneBookGUIClient {
    private JTextField textField1;
    private JButton getNameButton;
    private JTextField addName;
    private JButton addNameButton;
    private JTextField editName;
    private JButton editInPhonebookButton;
    private JPanel main;
    private JLabel nameLabel;
    private JTextField addNumber;
    private JTextField editNumber;
    private PhoneDirectoryInterface pd;

    private PhoneBookGUIClient() throws NamingException {

        this.pd = PhoneDirectoryClientFactory.create();

        getNameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String number = pd.getPhoneNumber(textField1.getText());
                    nameLabel.setText(number);
                } catch (RemoteException e1) {
                    e1.printStackTrace();
                }
            }
        });
        addNameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    boolean number = pd.addPhoneNumber(addName.getText(), addNumber.getText());
                    if(number)
                    JOptionPane.showMessageDialog(null, "Phone number Added");

                } catch (RemoteException e1) {
                    e1.printStackTrace();
                }
            }
        });
        editInPhonebookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    boolean number = pd.replacePhoneNumber(editName.getText(), editNumber.getText());
                    if(number)
                        JOptionPane.showMessageDialog(null, "Phone number Edited");

                } catch (RemoteException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }

    public static void main(String[] args) throws NamingException {
        JFrame app = new JFrame("PhoneBook App");
        app.setContentPane(new PhoneBookGUIClient().main);
        app.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        app.setMinimumSize(new Dimension(600, 200));
        app.pack();
        app.setVisible(true);
    }
}
