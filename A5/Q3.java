import java.util.Scanner;
/*
Starting at i = 0,
Check to see if the character at i 
is the same one indicated by the user.
Run the findLetter method with i incremented by 1
*/
public class Q3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter a String");
        String s = input.nextLine();

        System.out.println("Enter a character");
        char ch = input.next().charAt(0);

        int x = 0;
        System.out.println( ch + " appears " + findLetter(s,ch,x,0) + " time(s) in \"" + s + "\"");

        input.close();
    }
    public static int findLetter(String s, char ch, int x, int i){
        if (i < s.length()){
            if (findChar(s, i) == ch){x++;}
            return findLetter(s, ch, x, i + 1);
        }
        return x;
    }
    //helper
    public static char findChar(String s, int i){
        return s.charAt(i);
    }
}
