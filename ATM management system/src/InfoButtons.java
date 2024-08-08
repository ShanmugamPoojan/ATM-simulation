import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class InfoButtons implements ActionListener {
    JFrame infoFrame;
    JButton withdraw, deposit,fastCash, balance, changePassword, exit;
    JPanel infoDisplay;

    JPasswordField passwordField;
    String accountNo;
    HashMap<String,Integer> account;
    HashMap<String, Double> amount;
    InfoButtons(JPanel infoDisplay, String accountNo, JPasswordField passwordField,JFrame infoFrame,HashMap<String,Integer> account, HashMap<String, Double> amount){
        this.infoDisplay = infoDisplay;
        this.accountNo = accountNo;
        this.passwordField = passwordField;
        this.infoFrame = infoFrame;
        this.account = account;
        this.amount = amount;

        setButtons();
    }

    private void setButtons() {
        withdraw = new JButton("Withdraw");
        deposit = new JButton("Deposit");
        fastCash = new JButton("FastCash");
        changePassword = new JButton("Change PIN");
        balance = new JButton("Balance");
        exit = new JButton("Exit");

        withdraw.setBackground(new Color(255, 255, 57));
        withdraw.setForeground(new Color(80, 180, 255));
        withdraw.setHorizontalAlignment(JLabel.CENTER);
        withdraw.setFont(new Font(null,Font.BOLD,15));
        withdraw.setBorder(null);
        withdraw.setFocusable(false);
        withdraw.setBounds(5,150,200,35);
        withdraw.addActionListener(this);

        deposit.setBackground(new Color(255, 255, 57));
        deposit.setForeground(new Color(80, 180, 255));
        deposit.setHorizontalAlignment(JLabel.CENTER);
        deposit.setFont(new Font(null,Font.BOLD,15));
        deposit.setBorder(null);
        deposit.setFocusable(false);
        deposit.setBounds(365,150,200,35);
        deposit.addActionListener(this);

        fastCash.setBackground(new Color(255, 255, 57));
        fastCash.setForeground(new Color(80, 180, 255));
        fastCash.setHorizontalAlignment(JLabel.CENTER);
        fastCash.setFont(new Font(null,Font.BOLD,15));
        fastCash.setBorder(null);
        fastCash.setFocusable(false);
        fastCash.setBounds(5,200,200,35);
        fastCash.addActionListener(this);

        balance.setBackground(new Color(255, 255, 57));
        balance.setForeground(new Color(80, 180, 255));
        balance.setHorizontalAlignment(JLabel.CENTER);
        balance.setFont(new Font(null,Font.BOLD,15));
        balance.setBorder(null);
        balance.setFocusable(false);
        balance.setBounds(365,200,200,35);
        balance.addActionListener(this);

        changePassword.setBackground(new Color(255, 255, 57));
        changePassword.setForeground(new Color(80, 180, 255));
        changePassword.setHorizontalAlignment(JLabel.CENTER);
        changePassword.setFont(new Font(null,Font.BOLD,15));
        changePassword.setBorder(null);
        changePassword.setFocusable(false);
        changePassword.setBounds(5,250,200,35);
        changePassword.addActionListener(this);

        exit.setBackground(new Color(255, 255, 57));
        exit.setForeground(new Color(80, 180, 255));
        exit.setHorizontalAlignment(JLabel.CENTER);
        exit.setFont(new Font(null,Font.BOLD,15));
        exit.setBorder(null);
        exit.setFocusable(false);
        exit.setBounds(365,250,200,35);
        exit.addActionListener(this);


        infoDisplay.add(withdraw);
        infoDisplay.add(deposit);
        infoDisplay.add(fastCash);
        infoDisplay.add(balance);
        infoDisplay.add(changePassword);
        infoDisplay.add(exit);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== withdraw){
            new Withdraw(accountNo,account, amount);
            infoFrame.dispose();
        }
        else if(e.getSource()== deposit){
            new Deposit(accountNo,account, amount);
            infoFrame.dispose();
        }
        else if(e.getSource()== fastCash){
            new FastCash(accountNo,account, amount);
            infoFrame.dispose();
        }
        else if(e.getSource()== balance){
            new Balance(accountNo,account, amount);
            infoFrame.dispose();
        }
        else if(e.getSource()== changePassword){
            new ChangePIN(accountNo, account, amount);
            infoFrame.dispose();
        }
        else if(e.getSource()== exit){
            new LoginPage(accountNo,account, amount);
            infoFrame.dispose();
        }
    }
}
