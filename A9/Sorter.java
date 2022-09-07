import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class Sorter {
    public static void bubbleSort(ArrayList < Patient > list) {
        boolean sorted = false;
        for (int k = 0; k < list.size(); k++){
            for (int i = 0; i < list.size() - k - 1; i++){
                if (list.get(i).compareTo(list.get(i + 1)) > -1){
                    Patient temp = list.get(i);
                    list.set(i, list.get(i + 1));
                    list.set(i + 1, temp);
                }
            }
        }
    }
    public static void bubbleSort(ArrayList < Patient > list, Comparator < Patient > comparator) {

        for (int i = 0; i < list.size(); i++){
            for (int j = 0; j < list.size() - 1; j++){
                if (comparator.compare(list.get(i), list.get(i + 1)) > 0){
                    Patient temp = list.get(i);
                    list.set(i, list.get(i + 1));
                    list.set(i+1, temp);
                }
            }
        }
    }
    public static void selectionSort(ArrayList < Patient > list) {

        for (int i = 0; i < list.size(); i++) {

            int smallest = i;

            for (int scan = i + 1; scan < list.size(); scan++) {
                if (list.get(scan).compareTo(list.get(smallest)) < 0) {
                    smallest = scan;
                }
            }
            Patient temp = list.get(i);
            list.set(i, list.get(smallest));
            list.set(smallest, temp);
        }

    }
    public static void insertionSort(ArrayList < Patient > list) {
        for (int i = 1; i < list.size(); i++){
            Patient item = list.get(i);
            int pos;
            for(pos = i; pos > 0; pos--){
                if (list.get(pos-1).compareTo(item) > 0){
                    list.set(pos, list.get(pos-1));
                }
                else{
                    list.set(pos, item);
                }
            }
        }



        for (int i = 0; i < list.size(); i++) {
            Patient current = list.get(i);
            int j = i - 1;
            while ((j > -1) && (list.get(j).compareTo(current) == 1)) {
                list.remove(j + 1);
                list.add(j + 1, list.get(j));
                j--;
            }
        }
    }

    public static void findTime() {
        System.out.println("\n Time (seconds)");
        System.out.printf("%-8s %-8s %-8s %-8s", "N", "Bubble", "Selection", "Insertion\n");
        for (int i = 0; i <= 9; i++) {
            int n = 5000 + (i * 5000);
            ArrayList < Patient > list = new ArrayList < Patient > ();
            ArrayList < Patient > list2 = new ArrayList < Patient > ();
            ArrayList < Patient > list3 = new ArrayList < Patient > ();
            for (int j = 0; j < n; j++) {
                Random rd = new Random();
                boolean x = rd.nextBoolean();
                list.add(new Patient((int) Math.random() * 100, "Patient " + j, x));
                list2.add(new Patient((int) Math.random() * 100, "Patient " + j, x));
                list3.add(new Patient((int) Math.random() * 100, "Patient " + j, x));
            }
            long startTime = System.currentTimeMillis();
            bubbleSort(list);
            long endTime = System.currentTimeMillis();
            double bubbleTime = ((endTime - startTime));

            startTime = System.currentTimeMillis();
            selectionSort(list2);
            endTime = System.currentTimeMillis();
            double selectionTime = ((endTime - startTime));

            startTime = System.currentTimeMillis();
            insertionSort(list3);
            endTime = System.currentTimeMillis();
            double insertionTime = ((endTime - startTime));



            System.out.printf("%-8d %-4f %-4f %-4f\n", n, bubbleTime / 1000, selectionTime / 1000, insertionTime / 1000);
        }
    }

}