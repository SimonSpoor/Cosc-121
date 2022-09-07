/*
Create new array with 50 integers
Get user to choose a number
check if number is valid
if number is valid, print corrosponding array element
*/
import java.util.Scanner;

public class Q1_defensive{
    public static void main(String[] args) {
        int[] numArray = new int[50];
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < numArray.length; i++){
            numArray[i] = (int) (Math.random()*100);
        }

        System.out.println("Enter an Integer");
        int chosenNum = input.nextInt();

        while ((chosenNum < 0) | (chosenNum > 50)){
            System.out.println("Out of bounds. Try again.");
            chosenNum = input.nextInt();
        }
        System.out.println(numArray[chosenNum]);
        input.close();
    }
}