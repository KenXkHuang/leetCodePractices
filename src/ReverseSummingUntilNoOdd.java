import java.util.Scanner;

public class ReverseSummingUntilNoOdd {
    public static void main(String[] args) {
        try {
            String input = new Scanner(System.in).nextLine();
            int count = 1;
            int sum = Integer.parseInt(input) + reverseInt(Integer.parseInt(input));
            while (checkOdd(sum)) {
                sum = sum + reverseInt(sum);
                count++;
            }
            System.out.println(count + " " + sum);
        } catch (Exception e) {
            System.out.println("add exceeds maximum supported int value");
            System.exit(0);
        }
    }

    public static boolean checkOdd(int number) {
        String parsedString = Integer.toString(number);
        for (char c : parsedString.toCharArray()) {
            if ((c - '0') % 2 != 0) {
                return true;
            }
        }
        return false; //no odd number
    }

    public static int reverseInt(int number) {
        String parsedString = Integer.toString(number);
        String newString = "";
        for (int i = parsedString.length() - 1; i >= 0; i--) {
            newString += parsedString.charAt(i);
        }
        return Integer.parseInt(newString);
    }
}
