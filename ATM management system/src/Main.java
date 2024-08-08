import java.util.HashMap;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        HashMap<String,Integer>account = new HashMap<String,Integer>();

        account.put("123456789123", 1234);
//        account.put("1", 1);

        HashMap<String, Double>amount = new HashMap<String, Double>();

        amount.put("123456789123", 10000.00);
//        amount.put("1",200.00);

        new LoginPage(account, amount);
    }
}