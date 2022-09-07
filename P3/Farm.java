package P3;

import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Farm {
	private double availableFood;
	private Animal[] animals;
	private final int MAX_ANIMAL_COUNT = 100;
	private int animalsCount = 0;
	//animalsCount is used to track the number of animals in the animals array.
	//animalsCount should be incremented whenever we add a new animal to animals array.
	public Farm() {
		setAvailableFood(1000);
		animals = new Animal[MAX_ANIMAL_COUNT];
		//add(new Chicken());
		//add(new Cow());
		//add(new Llama());
		//add(new Llama());
	}

	void exit(String fileName) {
		File saveFile = new File(fileName);
		try (FileWriter writeFile = new FileWriter(saveFile)) {
			String animals = "";

			for (int i = 0; i < getAnimals().length; i++) {
				animals += this.animals[i] + "\n";
			}

			String s = animals + getAvailableFood();
			writeFile.write(s);
			System.out.println("Data saved successfully.");
		} catch (IOException e) {
			System.out.println("An error has occured. Please try again.");
		}
	}

	void load(String fileName) throws FileNotFoundException {
		File saveFile = new File(fileName);
		Scanner readFile = new Scanner(saveFile);

		String s = "";
		while (readFile.hasNext()) {
			s += readFile.nextLine();
		}
		System.out.println(s);

		readFile.close();

	}


	public void makeNoise() { // all animals make their sound (Moo, Cluck, etc)
		for (Animal animal: getAnimals())
			animal.sound();
	}
	public void feedAnimals() { // restore energy of all animals and deduct amount eaten from availableFood
		for (Animal animal: getAnimals())
			if (availableFood >= Math.min(animal.getMealAmount(), (100 - animal.getEnergy())))
				availableFood -= animal.eat();
			else
				System.out.println("Not enough food for your animals! You need to collect more food items.");
	}
	public void animSort() {
		/* sorts animals according to their natural ordering criteria
		 * Note that we cannot apply Arrays.sort to animals directly if it has null values (i.e. when the farm is not full). 
		 */
		if (animalsCount < MAX_ANIMAL_COUNT) {
			Animal[] temp = getAnimals();
			Arrays.sort(temp);
			System.arraycopy(temp, 0, animals, 0, animalsCount);
		} else
			Arrays.sort(animals);
	}
	public boolean addClone(Animal anim) throws CloneNotSupportedException {
		//this method creates a clone of an animal and adds it to the list of animals in the farm
		return add((Animal) anim.clone());
	}
	public boolean add(Animal anim) { //add an animal object to animals, return true if added successfully and false otherwise
		if (animalsCount < MAX_ANIMAL_COUNT) {
			animals[animalsCount++] = anim;
			return true;
		} else {
			System.out.println("Farm is full. can't add more animals.");
			return false;
		}
	}
	public void printAnimals() {
		for (int i = 0; i < animalsCount; i++)
			System.out.println(animals[i]);
	}
	public int getNumChicken() {
		int num = 0;
		for (Animal a: getAnimals())
			if (a instanceof Chicken) num++;
		return num;
	}
	public int getNumCows() {
		int num = 0;
		for (Animal a: getAnimals())
			if (a instanceof Cow) num++;
		return num;
	}
	public int getNumLlamas() {
		int num = 0;
		for (Animal a: getAnimals())
			if (a instanceof Llama) num++;
		return num;
	}
	public void printSummary() {
		System.out.println("The farm has:");
		System.out.printf("- %d animals (%d Chicken, %d Cows, and %d Llamas)\n", animalsCount, getNumChicken(), getNumCows(), getNumLlamas());
		System.out.printf("- %.2f units of available food\n", availableFood);
	}
	public double getAvailableFood() {
		return availableFood;
	}
	public void setAvailableFood(double availableFood) {
		if (availableFood >= 0 && availableFood <= 1000)
			this.availableFood = availableFood;
	}
	public Animal[] getAnimals() {
		//returns an array with only the animals existing in the farm - i.e. doesn't return the full animals array if it has null values.
		if (animalsCount < MAX_ANIMAL_COUNT) {
			Animal[] temp = new Animal[animalsCount];
			System.arraycopy(animals, 0, temp, 0, animalsCount);
			return temp;
		} else
			return animals;
	}
}