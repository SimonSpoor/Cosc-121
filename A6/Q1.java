package A6;
import java.util.ArrayList;
import java.util.Scanner;

/*
Prompt user for input
Add user input to a list
Create blank list
Check to see if new list contains each element in old list
If the new list contains the element, don't add it. Otherwise, add the element.
Return new list
*/

public class Q1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<Integer>();

        try {
            System.out.println("Enter 5 Integers: ");

            for (int i = 0; i < 5; i++){
                list.add(input.nextInt());
            }

        } catch (Exception e) {
            System.out.println("Invalid Input");
        }

        System.out.println(noDuplicates(list).toString());

        input.close();
    }

    public static ArrayList < Integer > noDuplicates(ArrayList < Integer > list) {
        ArrayList < Integer > listWithoutDuplicates = new ArrayList < Integer > ();

        for (int i: list) {
            if (!listWithoutDuplicates.contains(i)) {
                listWithoutDuplicates.add(i);
            }
        }
        return listWithoutDuplicates;
    }
}