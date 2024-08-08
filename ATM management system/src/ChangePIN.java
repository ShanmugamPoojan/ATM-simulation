import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class ChangePIN implements ActionListener {
    JFrame changePasswordFrame;
    JLabel background, accNo, display1, display2 ;
    JButton clear, changePassword, back;
    JPasswordField newPasswordField1 ,newPasswordField2;
    JPanel changePasswordDisplay;



    ImageIcon icon = new ImageIcon("atm.jpg");
    Image image = icon.getImage().getScaledInstance(1000,700,Image.SCALE_SMOOTH);
    ImageIcon atmImage = new ImageIcon(image);
    ImageIcon logo = new ImageIcon("SP.jpeg");
    String accountNo;
    HashMap<String,Integer> account;
    HashMap<String,Double> amount;
    ChangePIN(String accountNo, HashMap<String,Integer> account, HashMap<String,Double> amount){
        this.accountNo = accountNo;
        this.account = account;
        this.amount = amount;
        
        setFrame();

    }
    private void setButtons() {
        clear = new JButton("Clear");
        changePassword = new JButton("Change PIN");
        back = new JButton("Back");

        clear.setBackground(new Color(255, 255, 57));
        clear.setForeground(new Color(80, 180, 255));
        clear.setHorizontalAlignment(JLabel.CENTER);
        clear.setFont(new Font(null,Font.BOLD,15));
        clear.setBorder(null);
        clear.setFocusable(false);
        clear.setBounds(5,200,200,35);
        clear.addActionListener(this);
        
        changePassword.setBackground(new Color(255, 255, 57));
        changePassword.setForeground(new Color(80, 180, 255));
        changePassword.setHorizontalAlignment(JLabel.CENTER);
        changePassword.setFont(new Font(null,Font.BOLD,15));
        changePassword.setBorder(null);
        changePassword.setFocusable(false);
        changePassword.setBounds(365,250,200,35);
        changePassword.addActionListener(this);

        back.setBackground(new Color(255, 255, 57));
        back.setForeground(new Color(80, 180, 255));
        back.setHorizontalAlignment(JLabel.CENTER);
        back.setFont(new Font(null,Font.BOLD,15));
        back.setBorder(null);
        back.setFocusable(false);
        back.setBounds(5,250,200,35);
        back.addActionListener(this);


        changePasswordDisplay.add(clear);
        changePasswordDisplay.add(changePassword);
        changePasswordDisplay.add(back);

    }

    private void setLabels() {
        accNo = new JLabel("Acc. no. "+ accountNo);
        display1 = new JLabel("Enter new PIN");
        newPasswordField1 = new JPasswordField();
        display2 = new JLabel("Confirm new PIN");
        newPasswordField2 = new JPasswordField();

        display1.setBackground(Color.BLACK);
        display1.setForeground(new Color(255, 255, 57));
        display1.setHorizontalAlignment(JLabel.CENTER);
        display1.setFont(new Font(null,Font.PLAIN,20));
//        display1.setOpaque(true);
        display1.setBounds(150,60,265,30);

        newPasswordField1.setBackground(new Color(80, 180, 255));
        newPasswordField1.setForeground(Color.BLACK);
//        newPasswordField1.setBorder(null);
        newPasswordField1.setFont(new Font(null,Font.PLAIN,20));
        newPasswordField1.setHorizontalAlignment(JLabel.CENTER);
        newPasswordField1.setBounds(150,90,265,30);

        display2.setBackground(Color.BLACK);
        display2.setForeground(new Color(255, 255, 57));
        display2.setHorizontalAlignment(JLabel.CENTER);
        display2.setFont(new Font(null,Font.PLAIN,20));
//        display2.setOpaque(true);
        display2.setBounds(150,130,265,20);

        newPasswordField2.setBackground(new Color(80, 180, 255));
        newPasswordField2.setForeground(Color.BLACK);
//        newPasswordField1.setBorder(null);
        newPasswordField2.setFont(new Font(null,Font.PLAIN,20));
        newPasswordField2.setHorizontalAlignment(JLabel.CENTER);
        newPasswordField2.setBounds(150,160,265,30);

        accNo.setBackground(new Color(255, 255, 255, 50));
        accNo.setForeground(new Color(255, 255, 57));
        accNo.setHorizontalAlignment(JLabel.CENTER);
        accNo.setFont(new Font(null,Font.PLAIN,20));
        accNo.setOpaque(true);
        accNo.setBounds(150,20,270,30);

        changePasswordDisplay.add(display1);
        changePasswordDisplay.add(newPasswordField1);
        changePasswordDisplay.add(display2);
        changePasswordDisplay.add(newPasswordField2);
        changePasswordDisplay.add(accNo);
    }
    private void setDisplay(){
        changePasswordDisplay = new JPanel();


        changePasswordDisplay.setBounds(100,100,570,300);
        changePasswordDisplay.setBackground(new Color(80, 180, 255));
        changePasswordDisplay.setBorder(new LineBorder(Color.DARK_GRAY,5));
//        changePasswordDisplay.setOpaque(true);
        changePasswordDisplay.setLayout(null);


        setLabels();
        setButtons();
    }


    private void setFrame(){
        changePasswordFrame = new JFrame("ATM");
        background = new JLabel(atmImage);


        background.setBounds(0,0,500,500);

        setDisplay();

        changePasswordFrame.add(changePasswordDisplay);
        changePasswordFrame.add(background);

        changePasswordFrame.setSize(1000,700);
        changePasswordFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        changePasswordFrame.setLayout(null);
        changePasswordFrame.setIconImage(logo.getImage());
        changePasswordFrame.setResizable(false);
        changePasswordFrame.pack();
        changePasswordFrame.setLocationRelativeTo(null);
        changePasswordFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==clear){
            newPasswordField1.setText("");
            newPasswordField2.setText("");

        }
        else if(e.getSource()== changePassword){
            if(newPasswordField1.getPassword().length == 0 ||  newPasswordField2.getPassword().length == 0){
                JOptionPane.showConfirmDialog(changePasswordDisplay,"Enter new PIN", "Warning",JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE);
            }
//            else if(account.get(newPasswordField1.getText())==null){
//                JOptionPane.showConfirmDialog(changePasswordDisplay,"Invalid PIN", "Warning",JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE);
//            }
            else if(String.valueOf(newPasswordField1.getPassword()).equals(String.valueOf(newPasswordField2.getPassword()))){

                int pin = Integer.parseInt(String.valueOf(newPasswordField2.getPassword()));
                account.replace(accountNo,pin);

                JOptionPane.showConfirmDialog(changePasswordDisplay,"PIN change successful", "Info",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
                new InfoPage(accountNo,account, amount);
                changePasswordFrame.dispose();
            }
            else{
                JOptionPane.showConfirmDialog(changePasswordDisplay,"Invalid PIN", "Warning",JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE);
                newPasswordField2.setText("");
            }
        }
        else if(e.getSource()== back){
            new InfoPage(accountNo,account, amount);
            changePasswordFrame.dispose();
        }
    }
}
