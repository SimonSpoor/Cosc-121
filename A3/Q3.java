/*
Ask user for a math equation
Check for valid operator and save position to variable
Check for valid number before and after operator
if all are valid, do corrosponding math equation
*/

import java.util.Scanner;

public class Q3 {
    public static void main(String[] args) {
        //Initialize variables
        int operatorPosition = 0;
        String mathString = "";
        double num1 = 0;
        double num2 = 0;
        boolean isValid1 = false;
        boolean isValid2 = false;
        int type = 0;
        // 0 = NO OPERATOR, 1 = ADD, 2 = SUBTRACT, 3 = MULTIPLY, 4 = DIVIDE

        Scanner input = new Scanner(System.in);

        System.out.println("Enter a simple mathamatical formula");

        //check if contains operator then set type
        do {
            mathString = input.nextLine();

            for (int i = 0; i < mathString.length(); i++) {
                if (mathString.charAt(i) == '+') {
                    operatorPosition = i;
                    type = 1;
                    break;
                }
                else if (mathString.charAt(i) == '-') {
                    operatorPosition = i;
                    type = 2;
                    break;
                }
                else if (mathString.charAt(i) == '*') {
                    operatorPosition = i;
                    type = 3;
                    break;
                }
                else if (mathString.charAt(i) == '/') {
                    operatorPosition = i;
                    type = 4;
                    break;
                }
            }
        
            //I spend half an hour learning about regex only to reread the instructions and find out I have to use try catch :(
            //matches() worked damn well too

            //sets String x to 1st number
            String x = "";
            for (int i = 0; i < operatorPosition - 1; i++) {
                x += mathString.charAt(i);
            }
            //checks if String x contains non-digit
            try {
                    num1 = Double.parseDouble(x);
                    isValid1 = true;
            } 
            catch (Exception e) {
                isValid1 = false;
            } 
            

            //clear string
            x = "";

            //Sets String x to 2nd number
            for (int i = operatorPosition + 1; i < mathString.length(); i++) {
                x += mathString.charAt(i);
            }

            //checks if String x contains non-digit
            try {
                    num2 = Double.parseDouble(x);
                    isValid2 = true;
            } 
            catch (Exception e) {
                isValid2 = false;
            } 
            if ((isValid1 == false) || (isValid2 == false)){
                System.out.println("Invalid number format. Please try again");
            }
            if (type == 0) System.out.println("Invalid operator. Please try again");
        }
        while ((type == 0) || (isValid1 == false) || (isValid2 == false));

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