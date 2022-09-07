/*
Create new array with 50 integers
Get user to choose a number
check if number is valid
if number is valid, print corrosponding array element
*/
import java.util.Scanner;

public class Q1__exceptionHandling{
    public static void main(String[] args) {
        int[] numArray = new int[50];
        boolean isValid = false;
        int chosenNum = 0;
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < numArray.length; i++){
            numArray[i] = (int) (Math.random()*100);
        }

        System.out.println("Enter an Integer");

        while (!isValid){
            try {
                chosenNum = input.nextInt();
                System.out.println(numArray[chosenNum]);
                isValid = true;
            } catch (Exception e) {
                System.out.println("Out of bounds. Try again.");
            }
        }
        input.close();
    }
}