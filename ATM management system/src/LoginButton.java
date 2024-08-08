import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class LoginButton implements ActionListener {
    JFrame loginFrame;
    JButton submit, clear;
    JPanel loginDisplay;
    JTextField accNoField;
    JPasswordField passwordField;
    HashMap<String,Integer> account;
    HashMap<String, Double> amount;
    LoginButton(JTextField accNoField, JPasswordField passwordField,JPanel loginDisplay,JFrame loginFrame, HashMap<String,Integer> account,HashMap<String, Double> amount){
        this.accNoField = accNoField;
        this.passwordField = passwordField;
        this.loginDisplay = loginDisplay;
        this.loginFrame = loginFrame;
        this.account = account;
        this.amount = amount;

        setButtons();

    }
    private void setButtons(){

        clear = new JButton("Clear");
        submit = new JButton("Submit");


        clear.setBackground(new Color(255, 255, 57));
        clear.setForeground(new Color(80, 180, 255));
        clear.setHorizontalAlignment(JLabel.CENTER);
        clear.setFont(new Font(null,Font.BOLD,15));
        clear.setBorder(null);
        clear.setFocusable(false);
        clear.setBounds(5,250,200,35);
        clear.addActionListener(this);

        submit.setBackground(new Color(255, 255, 57));
        submit.setForeground(new Color(80, 180, 255));
        submit.setHorizontalAlignment(JLabel.CENTER);
        submit.setFont(new Font(null,Font.BOLD,15));
        submit.setBorder(null);
        submit.setFocusable(false);
        submit.setBounds(365,250,200,35);
        submit.addActionListener(this);

        loginDisplay.add(clear);
        loginDisplay.add(submit);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        String string;
        if(e.getSource()==clear){
            accNoField.setText("");
            passwordField.setText("");
        }
        else if(e.getSource()==submit){

            if(accNoField.getText().isEmpty() ||  passwordField.getPassword().length == 0){
                JOptionPane.showConfirmDialog(loginDisplay,"Enter Account no./ PIN", "Warning",JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE);
            }
            else if(account.get(accNoField.getText())==null){
                JOptionPane.showConfirmDialog(loginDisplay,"Invalid Account no./ PIN", "Warning",JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE);
            }
            else if(account.get(accNoField.getText()).equals(Integer.valueOf(String.valueOf(passwordField.getPassword())))){

                new InfoPage(accNoField.getText(),account, amount);
                loginFrame.dispose();
            }
            else {
                JOptionPane.showConfirmDialog(loginDisplay,"Invalid Account no./ PIN", "Warning",JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE);
            }

        }

    }
}
