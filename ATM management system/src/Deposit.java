import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class Deposit implements ActionListener {
    JFrame depositFrame;
    JLabel background, accNo, display ;
    JButton clear, deposit, exit,back;
    JTextField depositAmount;
    JPanel depositDisplay;



    ImageIcon icon = new ImageIcon("atm.jpg");
    Image image = icon.getImage().getScaledInstance(1000,700,Image.SCALE_SMOOTH);
    ImageIcon atmImage = new ImageIcon(image);
    ImageIcon logo = new ImageIcon("SP.jpeg");
    String accountNo;
    HashMap<String,Integer> account;
    HashMap<String,Double> amount;
    Deposit(String accountNo,HashMap<String,Integer> account, HashMap<String,Double> amount){
        this.accountNo = accountNo;
        this.account = account;
        this.amount = amount;

        setFrame();

    }
    private void setButtons() {
        clear = new JButton("Clear");
        deposit = new JButton("Deposit");
        back = new JButton("Back");
        exit = new JButton("Exit");

        clear.setBackground(new Color(255, 255, 57));
        clear.setForeground(new Color(80, 180, 255));
        clear.setHorizontalAlignment(JLabel.CENTER);
        clear.setFont(new Font(null,Font.BOLD,15));
        clear.setBorder(null);
        clear.setFocusable(false);
        clear.setBounds(5,200,200,35);
        clear.addActionListener(this);

        deposit.setBackground(new Color(255, 255, 57));
        deposit.setForeground(new Color(80, 180, 255));
        deposit.setHorizontalAlignment(JLabel.CENTER);
        deposit.setFont(new Font(null,Font.BOLD,15));
        deposit.setBorder(null);
        deposit.setFocusable(false);
        deposit.setBounds(365,200,200,35);
        deposit.addActionListener(this);

        back.setBackground(new Color(255, 255, 57));
        back.setForeground(new Color(80, 180, 255));
        back.setHorizontalAlignment(JLabel.CENTER);
        back.setFont(new Font(null,Font.BOLD,15));
        back.setBorder(null);
        back.setFocusable(false);
        back.setBounds(5,250,200,35);
        back.addActionListener(this);

        exit.setBackground(new Color(255, 255, 57));
        exit.setForeground(new Color(80, 180, 255));
        exit.setHorizontalAlignment(JLabel.CENTER);
        exit.setFont(new Font(null,Font.BOLD,15));
        exit.setBorder(null);
        exit.setFocusable(false);
        exit.setBounds(365,250,200,35);
        exit.addActionListener(this);

        depositDisplay.add(clear);
        depositDisplay.add(deposit);
        depositDisplay.add(back);
//        depositDisplay.add(exit);
    }

    private void setLabels() {
        accNo = new JLabel("Acc. no. "+ accountNo);
        display = new JLabel("Enter amount to deposit");
        depositAmount = new JTextField("");

        display.setBackground(Color.BLACK);
        display.setForeground(new Color(255, 255, 57));
        display.setHorizontalAlignment(JLabel.CENTER);
        display.setFont(new Font(null,Font.PLAIN,20));
//        display.setOpaque(true);
        display.setBounds(150,60,265,30);

        depositAmount.setBackground(new Color(80, 180, 255));
        depositAmount.setForeground(Color.BLACK);
//        depositAmount.setBorder(null);
        depositAmount.setFont(new Font(null,Font.PLAIN,20));
        depositAmount.setHorizontalAlignment(JLabel.CENTER);
        depositAmount.setBounds(150,100,265,30);

        accNo.setBackground(new Color(255, 255, 255, 50));
        accNo.setForeground(new Color(255, 255, 57));
        accNo.setHorizontalAlignment(JLabel.CENTER);
        accNo.setFont(new Font(null,Font.PLAIN,20));
        accNo.setOpaque(true);
        accNo.setBounds(150,20,270,30);

        depositDisplay.add(display);
        depositDisplay.add(depositAmount);
        depositDisplay.add(accNo);
    }
    private void setDisplay(){
        depositDisplay = new JPanel();


        depositDisplay.setBounds(100,100,570,300);
        depositDisplay.setBackground(new Color(80, 180, 255));
        depositDisplay.setBorder(new LineBorder(Color.DARK_GRAY,5));
//        depositDisplay.setOpaque(true);
        depositDisplay.setLayout(null);


        setLabels();
        setButtons();
    }


    private void setFrame(){
        depositFrame = new JFrame("ATM");
        background = new JLabel(atmImage);

        background.setBounds(0,0,500,500);

        setDisplay();

        depositFrame.add(depositDisplay);
        depositFrame.add(background);

        depositFrame.setSize(1000,700);
        depositFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        depositFrame.setLayout(null);
        depositFrame.setIconImage(logo.getImage());
        depositFrame.setResizable(false);
        depositFrame.pack();
        depositFrame.setLocationRelativeTo(null);
        depositFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==clear){
            depositAmount.setText("");
        }
        else if(e.getSource()== deposit){
            double withAmt = Double.parseDouble(depositAmount.getText());
            double balance = amount.get(accountNo) + withAmt;

            if(depositAmount.getText().isEmpty() ){
                JOptionPane.showConfirmDialog(depositDisplay,"Enter amount", "Warning",JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE);
            }
            else {
                amount.replace(accountNo, balance);
                JOptionPane.showConfirmDialog(depositDisplay, "Deposit successful", "Info", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
                new InfoPage(accountNo, account, amount);
                depositFrame.dispose();
            }
        }
        else if(e.getSource()== back){
            new InfoPage(accountNo,account,amount);
            depositFrame.dispose();
        }
        else if(e.getSource()== exit){
            depositFrame.dispose();
        }
    }
}
