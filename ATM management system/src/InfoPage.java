import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.HashMap;

public class InfoPage {
    JFrame infoFrame;
    JLabel background, welcome, accNo;

    JPasswordField passwordField;
    JPanel infoDisplay ;



    ImageIcon icon = new ImageIcon("atm.jpg");
    Image image = icon.getImage().getScaledInstance(1000,700,Image.SCALE_SMOOTH);
    ImageIcon atmImage = new ImageIcon(image);
    ImageIcon logo = new ImageIcon("SP.jpeg");
    String accountNo;
    HashMap<String,Integer> account;
    HashMap<String, Double> amount;

    InfoPage(String accountNo,HashMap<String,Integer> account, HashMap<String, Double> amount){
        this.accountNo = accountNo;
        this.account = account;
        this.amount = amount;

        setFrame();

    }
    private void setButtons() {

        new InfoButtons(infoDisplay, accountNo,passwordField,infoFrame,account, amount);

    }

    private void setLabels() {
        welcome = new JLabel("Welcome");
        accNo = new JLabel("Acc. no. " +accountNo);

        welcome.setBackground(Color.BLACK);
        welcome.setForeground(new Color(255, 255, 57));
        welcome.setHorizontalAlignment(JLabel.CENTER);
        welcome.setFont(new Font(null,Font.PLAIN,30));
//        welcome.setOpaque(true);
        welcome.setBounds(200,20,170,50);

        accNo.setBackground(new Color(255, 255, 255, 50));
        accNo.setForeground(new Color(255, 255, 57));
        accNo.setHorizontalAlignment(JLabel.CENTER);
        accNo.setFont(new Font(null,Font.PLAIN,20));
        accNo.setOpaque(true);
        accNo.setBounds(150,80,270,30);

        infoDisplay.add(welcome);
        infoDisplay.add(accNo);
    }
    private void setDisplay(){
        infoDisplay = new JPanel();


        infoDisplay.setBounds(100,100,570,300);
        infoDisplay.setBackground(new Color(80, 180, 255));
        infoDisplay.setBorder(new LineBorder(Color.DARK_GRAY,5));
//        infoDisplay.setOpaque(true);
        infoDisplay.setLayout(null);


        setLabels();
        setButtons();
    }


    private void setFrame(){
        infoFrame = new JFrame("ATM");
        background = new JLabel(atmImage);


        background.setBounds(0,0,500,500);

        setDisplay();

        infoFrame.add(infoDisplay);
        infoFrame.add(background);

        infoFrame.setSize(1000,700);;
        infoFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        infoFrame.setLayout(null);
        infoFrame.setIconImage(logo.getImage());
        infoFrame.setResizable(false);
        infoFrame.pack();
        infoFrame.setLocationRelativeTo(null);
        infoFrame.setVisible(true);
    }
}
