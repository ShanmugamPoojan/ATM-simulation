import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class Balance implements ActionListener {
    JFrame balanceFrame;
    JLabel background, accNo, display ,printAccNo, printBalance,printDate, printName;
    JButton printRcept, exit,back;
    JTextField balanceAmount;
    JPanel balanceDisplay, printRceptDisplay;



    ImageIcon icon = new ImageIcon("atm.jpg");
    Image image = icon.getImage().getScaledInstance(1000,700,Image.SCALE_SMOOTH);
    ImageIcon atmImage = new ImageIcon(image);
    ImageIcon logo = new ImageIcon("SP.jpeg");
    String accountNo;
    HashMap<String,Double> amount;
    HashMap<String,Integer> account;
    Balance(String accountNo,HashMap<String,Integer> account, HashMap<String,Double> amount){
        this.accountNo = accountNo;
        this.account = account;
        this.amount = amount;

        setFrame();

    }
    private void setButtons() {
        printRcept = new JButton("Print Rcept");
        back = new JButton("Back");
        exit = new JButton("Exit");

        printRcept.setBackground(new Color(255, 255, 57));
        printRcept.setForeground(new Color(80, 180, 255));
        printRcept.setHorizontalAlignment(JLabel.CENTER);
        printRcept.setFont(new Font(null,Font.BOLD,15));
        printRcept.setBorder(null);
        printRcept.setFocusable(false);
        printRcept.setBounds(365,200,200,35);
        printRcept.addActionListener(this);

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

        balanceDisplay.add(printRcept);
        balanceDisplay.add(back);
        balanceDisplay.add(exit);
    }

    private void setLabels() {
        accNo = new JLabel("Acc. no. "+ accountNo);
        display = new JLabel("Account balance");
        balanceAmount = new JTextField();

        display.setBackground(Color.BLACK);
        display.setForeground(new Color(255, 255, 57));
        display.setHorizontalAlignment(JLabel.CENTER);
        display.setFont(new Font(null,Font.PLAIN,20));
//        display.setOpaque(true);
        display.setBounds(150,60,265,30);

        balanceAmount.setBackground(new Color(80, 180, 255));
        balanceAmount.setForeground(Color.BLACK);
//        balanceAmount.setBorder(null);
        balanceAmount.setFont(new Font(null,Font.PLAIN,20));
        balanceAmount.setHorizontalAlignment(JLabel.CENTER);
        balanceAmount.setBounds(150,100,265,30);
        balanceAmount.setEditable(false);
        balanceAmount.setText(String.valueOf(amount.get(accountNo)));

        accNo.setBackground(new Color(255, 255, 255, 50));
        accNo.setForeground(new Color(255, 255, 57));
        accNo.setHorizontalAlignment(JLabel.CENTER);
        accNo.setFont(new Font(null,Font.PLAIN,20));
        accNo.setOpaque(true);
        accNo.setBounds(150,20,270,30);

        balanceDisplay.add(display);
        balanceDisplay.add(balanceAmount);
        balanceDisplay.add(accNo);
    }
// ******************************* for displaying print rcept ************************************
    private void setPrintRceptDetails() {
//        creating the display panel ********************

        printRceptDisplay = new JPanel();

        printRceptDisplay.setBackground(Color.WHITE);
        printRceptDisplay.setForeground(Color.BLACK);
        printRceptDisplay.setBounds(720,125,200,200);
        printRceptDisplay.setLayout(null);
        printRceptDisplay.setVisible(false);

//        creating components of display panel **************

        printName = new JLabel("XYZ BANK");
        printAccNo = new JLabel("Acc no. ********"+accountNo.substring(7));
        printBalance = new JLabel("Balance: "+String.valueOf(amount.get(accountNo))+ " rs");
        printDate = new JLabel("Date: --/--/----");


        printName.setBackground(new Color(255, 255, 255, 50));
        printName.setForeground(Color.BLACK);
        printName.setHorizontalAlignment(JLabel.CENTER);
        printName.setFont(new Font(null,Font.PLAIN,15));
        printName.setBounds(20,20,160,20);

        printDate.setBackground(new Color(255, 255, 255, 50));
        printDate.setForeground(Color.BLACK);
        printDate.setHorizontalAlignment(JLabel.LEFT);
        printDate.setFont(new Font(null,Font.PLAIN,15));
        printDate.setBounds(20,50,160,15);

        printAccNo.setBackground(new Color(255, 255, 255, 50));
        printAccNo.setForeground(Color.black);
        printAccNo.setHorizontalAlignment(JLabel.LEFT);
        printAccNo.setFont(new Font(null,Font.PLAIN,15));
        printAccNo.setBounds(20,80,160,20);

        printBalance.setBackground(new Color(255, 255, 255, 50));
        printBalance.setForeground(Color.BLACK);
        printBalance.setHorizontalAlignment(JLabel.LEFT);
        printBalance.setFont(new Font(null,Font.PLAIN,15));
        printBalance.setBounds(20,110,170,20);


//        for adding components of the print panel *****************

        printRceptDisplay.add(printName);
        printRceptDisplay.add(printAccNo);
        printRceptDisplay.add(printDate);
        printRceptDisplay.add(printBalance);

//         for adding print panel to main frame *******************

        balanceFrame.add(printRceptDisplay);
    }
    private void setDisplay(){
//          for creating a new display screen ***************************
        balanceDisplay = new JPanel();

        balanceDisplay.setBounds(100,100,570,300);
        balanceDisplay.setBackground(new Color(80, 180, 255));
        balanceDisplay.setBorder(new LineBorder(Color.DARK_GRAY,5));
        balanceDisplay.setLayout(null);

        balanceFrame.add(balanceDisplay);

        setPrintRceptDetails();

        setLabels();
        setButtons();
    }

    private void setFrame(){
        balanceFrame = new JFrame("ATM");
        background = new JLabel(atmImage);


        background.setBounds(0,0,500,500);

        setDisplay();

        balanceFrame.add(balanceDisplay);
        balanceFrame.add(background);

        balanceFrame.setSize(1000,700);
        balanceFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        balanceFrame.setIconImage(logo.getImage());
        balanceFrame.setResizable(false);
        balanceFrame.pack();
        balanceFrame.setLocationRelativeTo(null);
        balanceFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==printRcept){

            printRceptDisplay.setVisible(true);

        }
        else if(e.getSource()== back){
            new InfoPage(accountNo,account,amount);
            balanceFrame.dispose();
        }
        else if(e.getSource()== exit){
            balanceFrame.dispose();
        }
    }
}
