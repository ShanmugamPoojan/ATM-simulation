import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.HashMap;

public class LoginPage {

    JFrame loginFrame;
    JLabel background, bankName, accNo, password;
    JTextField accNoField;
    JPasswordField passwordField;
    JPanel display, login;
//    JButton submit, clear;


    ImageIcon icon = new ImageIcon("atm.jpg");
    Image image = icon.getImage().getScaledInstance(1000,700,Image.SCALE_SMOOTH);
    ImageIcon atmImage = new ImageIcon(image);
    ImageIcon logo = new ImageIcon("SP.jpeg");


    String accountNo;
    HashMap<String,Integer> account;
    HashMap<String, Double>amount;
    LoginPage(HashMap<String,Integer> account, HashMap<String,Double> amount){
        this.account = account;
        this.amount = amount;
        setFrame();
    }
    LoginPage(String accountNo, HashMap<String,Integer> account, HashMap<String,Double> amount){
        this.accountNo = accountNo;
        this.account = account;
        this.amount = amount;
        setFrame();
    }
    private void setButtons(){
        new LoginButton(accNoField,passwordField,display,loginFrame,account, amount);
    }

    private void setLabels(){
        login = new JPanel();

        bankName = new JLabel("XYZ bank");
        accNo = new JLabel("Acc. no.");
        password = new JLabel("PIN");


        bankName.setBackground(Color.BLACK);
        bankName.setForeground(new Color(255, 255, 57));
        bankName.setHorizontalAlignment(JLabel.CENTER);
        bankName.setFont(new Font(null,Font.PLAIN,30));
//        bankName.setOpaque(true);
        bankName.setBounds(200,20,170,50);

//  *************************************************************
        login.setBackground(new Color(255, 255, 255, 50));
        login.setBounds(120,100,340,100);

        accNo.setBackground(Color.BLUE);
        accNo.setForeground(new Color(255, 255, 57));
        accNo.setHorizontalAlignment(JLabel.CENTER);
        accNo.setFont(new Font(null,Font.BOLD,20));
//        accNo.setOpaque(true);
        accNo.setBounds(10,10,100,30);

        password.setBackground(Color.BLUE);
        password.setForeground(new Color(255, 255, 57));
        password.setHorizontalAlignment(JLabel.CENTER);
        password.setFont(new Font(null,Font.BOLD,20));
//        password.setOpaque(true);
        password.setBounds(10,60,100,30);


        accNoField = new JTextField();
        passwordField = new JPasswordField();

        accNoField.setBackground(new Color(80, 180, 255));
        accNoField.setForeground(Color.BLACK);
        accNoField.setBorder(null);
        accNoField.setFont(new Font(null,Font.PLAIN,20));
        accNoField.setHorizontalAlignment(JLabel.CENTER);
        accNoField.setBounds(110,10,200,30);
//        accNoField.setM

        passwordField.setBackground(new Color(80, 180, 255));
        passwordField.setForeground(Color.BLACK);
        passwordField.setBorder(null);
        passwordField.setFont(new Font(null,Font.PLAIN,20));
        passwordField.setHorizontalAlignment(JLabel.CENTER);
        passwordField.setBounds(110,60,200,30);

//  ***************************************************************

        login.setLayout(null);

        display.add(bankName);
        login.add(accNo);
        login.add(password);

        login.add(accNoField);
        login.add(passwordField);


        display.add(login);
    }
    private void setDisplay(){
        display = new JPanel();


        display.setBounds(100,100,570,300);
        display.setBackground(new Color(80, 180, 255));
        display.setBorder(new LineBorder(Color.DARK_GRAY,5));
        display.setLayout(null);

        setLabels();
        setButtons();
    }
    private void setFrame(){
        loginFrame = new JFrame("ATM");
        background = new JLabel(atmImage);


        background.setBounds(0,0,500,500);

        setDisplay();

        loginFrame.add(display);
        loginFrame.add(background);

        loginFrame.setSize(1000,700);
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        loginFrame.setLayout(null);
        loginFrame.setIconImage(logo.getImage());
        loginFrame.setResizable(false);
        loginFrame.pack();
        loginFrame.setLocationRelativeTo(null);
        loginFrame.setVisible(true);
    }
}
