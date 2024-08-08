import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class Withdraw implements ActionListener {
    JFrame withdrawFrame;
    JLabel background, accNo, display ;
    JButton clear, withdraw, exit,back;
    JTextField withdrawAmount;
    JPanel withdrawDisplay;



    ImageIcon icon = new ImageIcon("atm.jpg");
    Image image = icon.getImage().getScaledInstance(1000,700,Image.SCALE_SMOOTH);
    ImageIcon atmImage = new ImageIcon(image);
    ImageIcon logo = new ImageIcon("SP.jpeg");
    String accountNo;
    HashMap<String,Integer> account;
    HashMap<String,Double> amount;
    Withdraw(String accountNo,HashMap<String,Integer> account, HashMap<String,Double> amount){
        this.accountNo = accountNo;
        this.account = account;
        this.amount = amount;

        setFrame();

    }
    private void setButtons() {
        clear = new JButton("Clear");
        withdraw = new JButton("Withdraw");
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
        
        withdraw.setBackground(new Color(255, 255, 57));
        withdraw.setForeground(new Color(80, 180, 255));
        withdraw.setHorizontalAlignment(JLabel.CENTER);
        withdraw.setFont(new Font(null,Font.BOLD,15));
        withdraw.setBorder(null);
        withdraw.setFocusable(false);
        withdraw.setBounds(365,200,200,35);
        withdraw.addActionListener(this);

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

        withdrawDisplay.add(clear);
        withdrawDisplay.add(withdraw);
        withdrawDisplay.add(back);
//        withdrawDisplay.add(exit);
    }

    private void setLabels() {
        accNo = new JLabel("Acc. no. "+ accountNo);
        display = new JLabel("Enter amount to withdraw");
        withdrawAmount = new JTextField("");

        display.setBackground(Color.BLACK);
        display.setForeground(new Color(255, 255, 57));
        display.setHorizontalAlignment(JLabel.CENTER);
        display.setFont(new Font(null,Font.PLAIN,20));
//        display.setOpaque(true);
        display.setBounds(150,60,265,30);

        withdrawAmount.setBackground(new Color(80, 180, 255));
        withdrawAmount.setForeground(Color.BLACK);
//        withdrawAmount.setBorder(null);
        withdrawAmount.setFont(new Font(null,Font.PLAIN,20));
        withdrawAmount.setHorizontalAlignment(JLabel.CENTER);
        withdrawAmount.setBounds(150,100,265,30);

        accNo.setBackground(new Color(255, 255, 255, 50));
        accNo.setForeground(new Color(255, 255, 57));
        accNo.setHorizontalAlignment(JLabel.CENTER);
        accNo.setFont(new Font(null,Font.PLAIN,20));
        accNo.setOpaque(true);
        accNo.setBounds(150,20,270,30);

        withdrawDisplay.add(display);
        withdrawDisplay.add(withdrawAmount);
        withdrawDisplay.add(accNo);
    }
    private void setDisplay(){
        withdrawDisplay = new JPanel();


        withdrawDisplay.setBounds(100,100,570,300);
        withdrawDisplay.setBackground(new Color(80, 180, 255));
        withdrawDisplay.setBorder(new LineBorder(Color.DARK_GRAY,5));
//        withdrawDisplay.setOpaque(true);
        withdrawDisplay.setLayout(null);


        setLabels();
        setButtons();
    }


    private void setFrame(){
        withdrawFrame = new JFrame("ATM");
        background = new JLabel(atmImage);

        background.setBounds(0,0,500,500);

        setDisplay();

        withdrawFrame.add(withdrawDisplay);
        withdrawFrame.add(background);

        withdrawFrame.setSize(1000,700);
        withdrawFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        withdrawFrame.setLayout(null);
        withdrawFrame.setIconImage(logo.getImage());
        withdrawFrame.setResizable(false);
        withdrawFrame.pack();
        withdrawFrame.setLocationRelativeTo(null);
        withdrawFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==clear){
            withdrawAmount.setText("");
        }
        else if(e.getSource()== withdraw){

            double withAmt = Double.parseDouble(withdrawAmount.getText());
            double balance = amount.get(accountNo) - withAmt;

            if(withdrawAmount.getText().isEmpty() ){
                JOptionPane.showConfirmDialog(withdrawDisplay,"Enter amount", "Warning",JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE);
            }
            else if(amount.get(accountNo)< withAmt || balance <0 ){
                JOptionPane.showConfirmDialog(withdrawDisplay,"Low Balance", "Warning",JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE);
            }
            else{
                amount.replace(accountNo, balance);
                JOptionPane.showConfirmDialog(withdrawDisplay,"Withdraw successful", "Info",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
                new InfoPage(accountNo,account,amount);
                withdrawFrame.dispose();
            }

        }
        else if(e.getSource()== back){
            new InfoPage(accountNo,account,amount);
            withdrawFrame.dispose();
        }
        else if(e.getSource()== exit){
            withdrawFrame.dispose();
        }
    }
}
