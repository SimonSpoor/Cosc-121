/*
Copy syllabus to byte array
Create files that can contain 50kb and fill them with bytes until all the bytes have been copied

Go through all syllabus pieces and copy bytes to string
Print string to file
*/


import java.io.*;
import java.nio.file.*;
import java.util.Scanner;

public class Q3 {
    public static void main(String[] args) throws IOException {
        int filenum = backup("syllabus.pdf", 50);
        restore("syllabus.pdf", filenum);
    }

    public static int backup(String filename, double partSize) throws IOException{
        int filenum = 0;

        //kb to b 
        int x = (int) partSize * 1000;
        
        byte[] bytes = Files.readAllBytes(Paths.get(filename));

        int length = (int) Math.ceil(bytes.length / x);

        for (int i = 0; i <= length; i++){
            String s = "syllabus" + i + ".dat";
            filenum = i;
            
            File newFile = new File(s);
            FileWriter writeFile = new FileWriter(newFile);

            for (int j = 0; j < (x); j++){
                try {
                    writeFile.write(bytes[(j) + (x * i)]);
                } catch (Exception e) {
                }
            }
            writeFile.close();
        }


        return filenum;
    }
   public static int restore(String filename, int numberOfPieces) throws IOException{
    File newFile = new File("syllabusRecreation.pdf");
    String completeString = "";
    for (int i = 0; i <= numberOfPieces; i++){

        String s = "syllabus" + (i) + ".dat";
        File file = new File(s);

        Scanner readFile = new Scanner(file);
        while (readFile.hasNext()){
            completeString += readFile.nextLine();
        }

        readFile.close();

    }


    FileWriter writeFile = new FileWriter(newFile);
    writeFile.write(completeString);
    writeFile.close();
    return 1;
   }
}