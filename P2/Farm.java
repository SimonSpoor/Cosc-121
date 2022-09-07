package P2;

import java.util.Arrays;

public class Farm{
	private double availableFood;
	private Animal[] animals = new Animal[100];
	private static int i;
	public Farm() {
		setAvailableFood(1000);
	}

	public int numChicken(){
		return Chicken.getId();
	}
	public int numCow(){
		return Cow.getId();
	}
	public int numLlama(){
		return Llama.getId();
	}

	public boolean add(Animal anim) {
		if (i <= 100) {
			animals[i] = anim;
			i++;
			return true;
		} else return false;
	}

	public boolean addClone(Animal anim)throws CloneNotSupportedException { 
		if (i <= 100) { 
			animals[i] = (Animal) anim.clone();
			i++;
			return true;
		} else return false;
	}

	public void animSort() {
		Arrays.sort(animals, 0 , i);
	}

	public void makeNoise() { // all animals make their sound (Moo, Cluck, etc)
		for (int j = 0; j < i; j++)
			animals[j].sound();
	}
	public void feedAnimals() { // restore energy of all animals and deduct amount eaten from availableFood
		for (int j = 0; j < i; j++)
			if (availableFood >= Math.min(animals[j].getMealAmount(), (100 - animals[j].getEnergy())))
				// no penalty if student uses:  if(availableFood >= animal.getMealAmount())
				availableFood -= animals[j].eat();
			else
				System.out.println("Not enough food for your animals! You need to collect more food items.");
	}
	public double getAvailableFood() {
		return availableFood;
	}
	public void setAvailableFood(double availableFood) {
		if (availableFood >= 0 && availableFood <= 1000)
			this.availableFood = availableFood;
	}
	public Animal[] getAnimals() {
		Animal[] animalList = new Animal[4];
		for (int j = 0; j < i; j++) {
			animalList[j] = animals[j];
		}
		return animalList;
	}

	public void printAnimals(){
		for (int j = 0; j < i; j++){
			String x = "";
			if (animals[j].isAlive()){x = "alive";} else {x = "dead";}
 		System.out.println(animals[j].getName() + ": " + x + " at (" + animals[j].getX() + "," + animals[j].getY() + ") Energy= " + animals[j].getEnergy());
		}
	}

	public void printSummary(){
		System.out.print("The farm has:\n -" + (numChicken()+numCow()+numLlama()) + " animals (" + numChicken() + " Chicken(s), " + numCow() + " Cow(s), and " + numLlama() + " Llama(s)\n-" + getAvailableFood() + " units of avaliable food");
	}

	
}