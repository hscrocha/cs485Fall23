package edu.loyola.cs485.view;

import edu.loyola.cs485.controller.ClientService;

import javax.swing.*;
import java.awt.event.*;
import java.util.List;

public class ClientCrudDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JButton deleteButton;
    private JButton newButton;
    private JList lstClientUI;

    public ClientCrudDialog() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonCancel);
        populateList();

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
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public void populateList(){
        try {
            ClientService service = new ClientService();
            List lstdata = service.getClients();

            lstClientUI.setListData( lstdata.toArray() );
        }catch(Exception ex){
            System.out.println(ex);
            JOptionPane.showMessageDialog(this,"Error: "+ex.getMessage());
        }
    }

    public static void main(String[] args) {
        ClientCrudDialog dialog = new ClientCrudDialog();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
