/*
Create scanner for source.txt
Assign all lines of source.txt to a String variable
Capitalize all censored words
Create file writer to destination.txt
write destination.txt
*/
import java.io.*;
import java.util.*;

public class Q4 {
    public static void main(String[] args) throws IOException {
        String censoredWords[] = {"ABC", "XYZ"};
        String line = "";
        
        File source = new File("source.txt");
        Scanner readFile = new Scanner(source);

        while (readFile.hasNext()){
            line += readFile.nextLine() + "\n";
        }
        String censoredLine = replaceCensoredWords(line, censoredWords);

        FileWriter writeFile = new FileWriter("destination.txt");
        writeFile.write(censoredLine);
        writeFile.close();
        readFile.close();

    }
    private static String replaceCensoredWords (String line, String[] censoredWords){

        for (int i = 0; i < censoredWords.length; i++){
            line = line.replaceAll(censoredWords[i].toLowerCase(), censoredWords[i]);
        }
        return line;
    }
}
