package A2;

import java.util.Arrays;

public class A2 {
	public static void main(String[] args){
		Shape[] shapes1 = {
			new Hexagon("Yellow",true,4.00),
			new Hexagon("Orange",false,8.00),
			new Rectangle("Purple",true,3.00,4.00),
			new Rectangle("Green",true,6.00,5.00),
			new Rectangle("Cyan",false,1.00,2.00)
		};
		int x = 0;
		for (int i = 0; i < shapes1.length; i++){x += shapes1[i].getArea();}
		System.out.println("Total area of all shapes in 'shapes1' is " + x + "\n");
		
		Shape[] shapes2 = shapes1.clone();
		System.out.println("shapes1 has been cloned to shapes2");

		Arrays.sort(shapes2);
		System.out.println("shapes2 has been reordered!\n");

		System.out.println("Areas in shapes1    Areas in shapes2");
		for (int i = 0; i < shapes1.length; i++){
			System.out.printf("%-20.5s%.5s%n",shapes1[i].getArea(), shapes2[i].getArea());

		}
	}

}


