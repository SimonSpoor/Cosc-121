

import java.util.ArrayList;

public class PatientTestQ12 {
	public static void main(String[] args) {
		ArrayList<Patient> list = new ArrayList<>(5);
		list.add(new Patient(1, "p1", false));
		list.add(new Patient(2, "p2", false));
		list.add(new Patient(3, "p3", true));
		list.add(new Patient(4, "p4", false));
		list.add(new Patient(5, "p5", true));
		
		//before sorting
		System.out.printf("%-15s%25s\n", "Before sorting:", list);	//should be [p1, p2, p3, p4, p5]
		
		
		Sorter.bubbleSort(list);
		System.out.println("Bubble Sort 1: " + list.toString() + "\n");

		//Sorter.bubbleSort(list, new PatientComparator());
		System.out.println("Bubble Sort 2: " + list.toString() + "\n");

		//other sort methods		for Q2
		Sorter.selectionSort(list);
		System.out.println("Selection Sort: " + list.toString() + "\n");

		Sorter.insertionSort(list);
		System.out.println("Insertion Sort: " + list.toString() + "\n");

		//after sorting
		System.out.printf("%-15s%25s\n", "After sorting", list);	//should be [p3, p5, p1, p2, p4]
	
		Sorter.findTime();
	
	}
}
