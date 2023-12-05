package edu.loyola.cs485.view;

import edu.loyola.cs485.controller.UserService;
import edu.loyola.cs485.model.entity.User;

import javax.swing.*;
import java.awt.event.*;

public class LoginDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField txtLogin;
    private JPasswordField txtPassword;

    public LoginDialog() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        // add your code here
        try {
            String login = txtLogin.getText();
            String password = txtPassword.getText();

            UserService service = new UserService();
            User logged = service.login(login, password);
            if(logged != null){
                //Sucessfull Login
                JOptionPane.showMessageDialog(this,
                        "Welcome "+logged.getLogin());
                dispose();
            } else {
                //Incorrect Login or Password
                JOptionPane.showMessageDialog(this,
                        "Login or Password Incorrect.");
            }
        }catch(Exception ex){
            System.out.println(ex);
            JOptionPane.showMessageDialog(this,ex.getMessage());
        }
    }

    private void onCancel() {
        // add your code here if necessary
        System.exit(0);
    }

    public static void main(String[] args) {
        LoginDialog dialog = new LoginDialog();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
