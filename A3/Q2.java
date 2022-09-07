/*
Ask user for operator, number 1, and number 2
If all 3 are valid, do corrosponding math equation
*/
import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {
        //Initialize variables
        String operator = "";
        double num1 = 0;
        double num2 = 0;
        boolean isValid1 = false;
        boolean isValid2 = false;
        int type = 0;
        // 0 = NO OPERATOR, 1 = ADD, 2 = SUBTRACT, 3 = MULTIPLY, 4 = DIVIDE

        Scanner input = new Scanner(System.in);


        // This is really janky and I couldn't fix it
        //Could you tell me why it's behaving like this on an invalid input?
        while ((type == 0) || (isValid1 == false) || (isValid2 == false)) {

            operator = input.nextLine();
            switch (operator) {
                case "+":
                    type = 1;
                    break;
                case "-":
                    type = 2;
                    break;
                case "*":
                    type = 3;
                    break;
                case "/":
                    type = 4;
                    break;
                default:

            }
            try {
                num1 = input.nextDouble();
                isValid1 = true;
                num2 = input.nextDouble();
                isValid2 = true;
            } catch (Exception e) {
                System.out.println("Invalid input. Please try again");
            }
            if (type == 0) {
                System.out.println("Invalid operator. Please try again");
            }
        }

        switch (type) {
            case 1:
                System.out.println("Result: " + (num1 + num2));
                break;
            case 2:
                System.out.println("Result: " + (num1 - num2));
                break;
            case 3:
                System.out.println("Result: " + (num1 * num2));
                break;
            case 4:
                System.out.println("Result: " + (num1 / num2));
                break;
        }



        input.close();
    }
}