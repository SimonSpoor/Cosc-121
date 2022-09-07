/* Read bytes to string
convert to hex
print and format
*/

import java.io.File;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) throws IOException{
        viewHex("data.dat");
    }

    private static void viewHex(String filename) throws IOException {
        try {
            
        File data = new File(filename);
        Scanner readFile = new Scanner(data);
        String hexString = "";
        String fString = "";

        byte[] file = Files.readAllBytes(Paths.get("data.dat"));
        System.out.println(file.toString());

        for (int i = 0; i < file.length; i++) {
            hexString += Integer.toHexString(file[i]).toUpperCase();
        }

        for (int i = 0, j = 1; i < hexString.length(); i++, j++) {
            fString += hexString.charAt(i);
            i++;
            fString += hexString.charAt(i) + " ";
            if ((j % 4 == 0) && (!(j % 8 == 0))) {
                fString += "| ";
            } else if (j % 8 == 0) {
                fString += "\n";
            }
        }

        System.out.println(fString);

        readFile.close();

        } catch (IOException e) {
            System.out.println("An error has occured");
        }
    }
}