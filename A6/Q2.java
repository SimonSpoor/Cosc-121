package A6;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

/*
Prompt user for input
Create blank arraylist with length of (char number / 50)
Read file using delimiter specified
Add sentances + punctuation to arraylist
Shuffle using collections.shuffle
Print all sentances in arraylist
*/

public class Q2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter file name: ");

        try {
            printShuffled(input.nextLine());
        } catch (Exception e) {
            System.out.println("Invalid Input");
        }

        input.close();
    }
    public static void printShuffled(String filename) throws FileNotFoundException {
        File file = new File(filename);
        Scanner readFile = new Scanner(file);

        ArrayList < String > sentances = new ArrayList < String > ((int)(file.length() / 50));

        readFile.useDelimiter("[.:!?]");
        while (readFile.hasNext()) {
            sentances.add(readFile.next() + readFile.findInLine("[.:!?]"));
        }
        Collections.shuffle(sentances);

        for (int i = 0; i < sentances.size(); i++){
            System.out.print(sentances.get(i));
        }
        readFile.close();
    }
}