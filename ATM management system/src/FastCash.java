import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class FastCash implements ActionListener{
    JFrame fastCashFrame;
    JLabel background, accNo, display ;
    JButton  hundred, twoHundred,fiveHundred,thousand,fiveThousand,back;
    JPanel fastCashDisplay;



    ImageIcon icon = new ImageIcon("atm.jpg");
    Image image = icon.getImage().getScaledInstance(1000,700,Image.SCALE_SMOOTH);
    ImageIcon atmImage = new ImageIcon(image);
    ImageIcon logo = new ImageIcon("SP.jpeg");
    String accountNo;
    HashMap<String,Integer> account;
    HashMap<String,Double> amount;
    FastCash(String accountNo,HashMap<String,Integer> account, HashMap<String,Double> amount){
        this.accountNo = accountNo;
        this.account = account;
        this.amount = amount;

        setFrame();

    }

    private void setButtons() {
        hundred = new JButton("100");
        twoHundred = new JButton("200");
        fiveHundred = new JButton("500");
        thousand = new JButton("1000");
        fiveThousand = new JButton("5000");
        back = new JButton("Back");

        hundred.setBackground(new Color(255, 255, 57));
        hundred.setForeground(new Color(80, 180, 255));
        hundred.setHorizontalAlignment(JLabel.CENTER);
        hundred.setFont(new Font(null,Font.BOLD,15));
        hundred.setBorder(null);
        hundred.setFocusable(false);
        hundred.setBounds(5,150,200,35);
        hundred.addActionListener(this);

        twoHundred.setBackground(new Color(255, 255, 57));
        twoHundred.setForeground(new Color(80, 180, 255));
        twoHundred.setHorizontalAlignment(JLabel.CENTER);
        twoHundred.setFont(new Font(null,Font.BOLD,15));
        twoHundred.setBorder(null);
        twoHundred.setFocusable(false);
        twoHundred.setBounds(365,150,200,35);
        twoHundred.addActionListener(this);

        fiveHundred.setBackground(new Color(255, 255, 57));
        fiveHundred.setForeground(new Color(80, 180, 255));
        fiveHundred.setHorizontalAlignment(JLabel.CENTER);
        fiveHundred.setFont(new Font(null,Font.BOLD,15));
        fiveHundred.setBorder(null);
        fiveHundred.setFocusable(false);
        fiveHundred.setBounds(5,200,200,35);
        fiveHundred.addActionListener(this);

        thousand.setBackground(new Color(255, 255, 57));
        thousand.setForeground(new Color(80, 180, 255));
        thousand.setHorizontalAlignment(JLabel.CENTER);
        thousand.setFont(new Font(null,Font.BOLD,15));
        thousand.setBorder(null);
        thousand.setFocusable(false);
        thousand.setBounds(365,200,200,35);
        thousand.addActionListener(this);

        fiveThousand.setBackground(new Color(255, 255, 57));
        fiveThousand.setForeground(new Color(80, 180, 255));
        fiveThousand.setHorizontalAlignment(JLabel.CENTER);
        fiveThousand.setFont(new Font(null,Font.BOLD,15));
        fiveThousand.setBorder(null);
        fiveThousand.setFocusable(false);
        fiveThousand.setBounds(365,250,200,35);
        fiveThousand.addActionListener(this);

        back.setBackground(new Color(255, 255, 57));
        back.setForeground(new Color(80, 180, 255));
        back.setHorizontalAlignment(JLabel.CENTER);
        back.setFont(new Font(null,Font.BOLD,15));
        back.setBorder(null);
        back.setFocusable(false);
        back.setBounds(5,250,200,35);
        back.addActionListener(this);


        fastCashDisplay.add(hundred);
        fastCashDisplay.add(twoHundred);
        fastCashDisplay.add(fiveHundred);
        fastCashDisplay.add(fiveThousand);
        fastCashDisplay.add(thousand);
        fastCashDisplay.add(back);
    }
    private void setDisplay(){
        fastCashDisplay = new JPanel();


        fastCashDisplay.setBounds(100,100,570,300);
        fastCashDisplay.setBackground(new Color(80, 180, 255));
        fastCashDisplay.setBorder(new LineBorder(Color.DARK_GRAY,5));
//        fastCashDisplay.setOpaque(true);
        fastCashDisplay.setLayout(null);


        setLabels();
        setButtons();
    }


    private void setLabels() {
        accNo = new JLabel("Acc. no. "+ accountNo);
        display = new JLabel("Choose amount to withdraw");
        

        display.setBackground(Color.BLACK);
        display.setForeground(new Color(255, 255, 57));
        display.setHorizontalAlignment(JLabel.CENTER);
        display.setFont(new Font(null,Font.PLAIN,20));
//        display.setOpaque(true);
        display.setBounds(150,60,265,30);
        
        accNo.setBackground(new Color(255, 255, 255, 50));
        accNo.setForeground(new Color(255, 255, 57));
        accNo.setHorizontalAlignment(JLabel.CENTER);
        accNo.setFont(new Font(null,Font.PLAIN,20));
        accNo.setOpaque(true);
        accNo.setBounds(150,20,270,30);

        fastCashDisplay.add(display);
        fastCashDisplay.add(accNo);
    }
    private void setFrame(){
        fastCashFrame = new JFrame("ATM");
        background = new JLabel(atmImage);


        background.setBounds(0,0,500,500);

        setDisplay();

        fastCashFrame.add(fastCashDisplay);
        fastCashFrame.add(background);

        fastCashFrame.setSize(1000,700);
        fastCashFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        fastCashFrame.setLayout(null);
        fastCashFrame.setIconImage(logo.getImage());
        fastCashFrame.setResizable(false);
        fastCashFrame.pack();
        fastCashFrame.setLocationRelativeTo(null);
        fastCashFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== hundred){
            double withAmt = Double.parseDouble(hundred.getText());
            double balance = amount.get(accountNo) - withAmt;

            if(amount.get(accountNo)< withAmt || balance <0 ){
                JOptionPane.showConfirmDialog(fastCashDisplay,"Low Balance", "Warning",JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE);
            }
            else {
                amount.replace(accountNo, balance);
                JOptionPane.showConfirmDialog(fastCashDisplay, "Withdraw successful", "Info", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
                new InfoPage(accountNo,account,amount);
                fastCashFrame.dispose();
            }
        }
        else if(e.getSource()== twoHundred){
            double withAmt = Double.parseDouble(twoHundred.getText());
            double balance = amount.get(accountNo) - withAmt;

            if(amount.get(accountNo)< withAmt || balance <0 ){
                JOptionPane.showConfirmDialog(fastCashDisplay,"Low Balance", "Warning",JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE);
            }
            else {
                amount.replace(accountNo, balance);
                JOptionPane.showConfirmDialog(fastCashDisplay, "Withdraw successful", "Info", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
                new InfoPage(accountNo,account,amount);
                fastCashFrame.dispose();
            }
        }
        else if(e.getSource()== fiveHundred){
            double withAmt = Double.parseDouble(fiveHundred.getText());
            double balance = amount.get(accountNo) - withAmt;

            if(amount.get(accountNo)< withAmt || balance <0 ){
                JOptionPane.showConfirmDialog(fastCashDisplay,"Low Balance", "Warning",JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE);
            }
            else {
                amount.replace(accountNo, balance);
                JOptionPane.showConfirmDialog(fastCashDisplay, "Withdraw successful", "Info", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
                new InfoPage(accountNo,account,amount);
                fastCashFrame.dispose();
            }
        }
        else if(e.getSource()== fiveThousand){
            double withAmt = Double.parseDouble(fiveThousand.getText());
            double balance = amount.get(accountNo) - withAmt;

            if(amount.get(accountNo)< withAmt || balance <0 ){
                JOptionPane.showConfirmDialog(fastCashDisplay,"Low Balance", "Warning",JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE);
            }
            else {
                amount.replace(accountNo, balance);
                JOptionPane.showConfirmDialog(fastCashDisplay, "Withdraw successful", "Info", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
                new InfoPage(accountNo,account,amount);
                fastCashFrame.dispose();
            }
        }
        else if(e.getSource()== thousand){
            double withAmt = Double.parseDouble(fiveThousand.getText());
            double balance = amount.get(accountNo) - withAmt;

            if(amount.get(accountNo)< withAmt || balance <0 ){
                JOptionPane.showConfirmDialog(fastCashDisplay,"Low Balance", "Warning",JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE);
            }
            else {
                amount.replace(accountNo, balance);
                JOptionPane.showConfirmDialog(fastCashDisplay, "Withdraw successful", "Info", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
                new InfoPage(accountNo,account,amount);
                fastCashFrame.dispose();
            }
        }
        else if(e.getSource()== back){
            new InfoPage(accountNo,account,amount);
            fastCashFrame.dispose();
        }
    }
}
