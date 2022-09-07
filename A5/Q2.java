import java.util.Scanner;

/*
With i being the length of the string,
Add the character at length i, then decrement i
Repeat until i = 0
*/

public class Q2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String s = input.nextLine();
        String reversed = "";

        String x = reverse(s,reversed,4);
        System.out.println(x);
        input.close();
    }
    public static String reverse(String s, String reversed, int i){
        reversed += s.charAt(i);
        if (i > 0){
            return reverse(s,reversed,i-1);
        }
        else {
            return reversed;
        }
    }
}