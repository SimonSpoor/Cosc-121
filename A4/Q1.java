/*
Get number from count.dat
increment
write number to count.dat
*/

import java.io.*;
import java.util.*;


public class Q1 {
    public static void main(String[] args) throws IOException {
        File count = new File("count.dat");
        Scanner readFile = new Scanner(count);
        
        Integer x = Integer.parseInt(readFile.nextLine());

        x +=1;

        FileWriter writeFile = new FileWriter("count.dat");
        writeFile.write(x.toString());

        System.out.println("This program has been run " + x + " time(s)");

        readFile.close();
        writeFile.close();
    }
}