import java.util.ArrayList;

/*
If k is over 0, do the following:
Add 1/k to the ArrayList
Call the method with k reduced by 1
*/

public class Q1 {
    public static void main(String[] args) {
        ArrayList<Double> numList = new ArrayList<Double>();
        test(f(5, numList));
    }
    public static ArrayList f(double k, ArrayList numList) {
        if (k > 0) {
            numList.add(1/(2 * k));
            f(k-1, numList);
        }
        return numList;
      }
      public static void test(ArrayList x){
          for (int i = x.size()-1; i >= 0; i--){
              String j = x.get(i).toString();
            System.out.printf("i = %d   f(i) = %s\n", i+1, j);
          }   
      }
}