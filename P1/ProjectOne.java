import java.util.Arrays;

public class ProjectOne {
    public static void main(String[] args) {
        farm myFarm = new farm();
        for (animal a: myFarm.getAnimals()) //move each animal by random amount
            for (int i = 0; i < (int)(Math.random() * 1000); i++) a.move();
        System.out.println("Before feeding: " + myFarm.getAvailableFood());
        myFarm.feedAnimals();
        System.out.println("After feeding: " + myFarm.getAvailableFood());
        myFarm.makeNoise();
        myFarm.getAnimals()[0].speak("Hello!!");
        System.out.println(Arrays.toString(myFarm.getAnimals()));
    }
}
class animal {
    private String name = "noName";
    private double energy;
    private boolean alive;
    private double mealAmount;
    private double x;
    private double y;
    private double speedx;
    private double speedy;

    public animal() {
        this.energy = 100;
        this.speedx = 1;
        this.speedy = 1;
    }

    public double getEnergy() {
        return energy;
    }
    public double getMealAmount() {
        return mealAmount;
    }
    public String getName() {
        return name;
    }
    public double getSpeedx() {
        return speedx;
    }
    public double getSpeedy() {
        return speedy;
    }
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public boolean getAlive() {
        if (energy > 0) {
            alive = true;
        } else alive = false;

        return alive;
    }

    public void setEnergy(double energy) {
        this.energy = energy;
        if (energy < 50 && energy > 17) {
            System.out.println(this.name + " is hungry");
        } else if (energy < 17) {
            System.out.println(this.name + " is starving");
        }
    }
    public void setMealAmount(double mealAmount) {
        this.mealAmount = mealAmount;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setSpeedx(double speedx) {
        this.speedx = speedx;
    }
    public void setSpeedy(double speedy) {
        this.speedy = speedy;
    }
    public void setX(double x) {
        this.x = x;
    }
    public void setY(double y) {
        this.y = y;
    }

    public String toString() {
        String x;
        if (getAlive()) {
            x = getName() + ": Alive at (" + getX() + " " + getY() + ") Energy= " + getEnergy();
        } else {
            x = getName() + ": Dead at (" + getX() + " " + getY() + ") Energy= " + getEnergy();
        }
        return x;
    }
    void move() {
        if (getAlive()) {
            x += speedx;
            y += speedy;
            this.energy -= 0.1;
        } else {
            System.out.println(this.name + " can't move. It's dead!");
        }
    }
    void speak(String msg) {
        if (getAlive()) {
            System.out.println(getName() + " says: Hi!");
        }
    }
    void sound() {
        if (getAlive()) {
            System.out.println("Unknown Sound");
        }
    }
    double eat() {
        double x = 0;
        if (this.alive){
            if (this.energy == 100){
                System.out.println(getName() + " did not eat because it is full.");
            }
            if (this.energy + getMealAmount() > 100) {
                x = -100 + (this.energy + getMealAmount());
                this.energy = 100;
                System.out.println(getName() + " ate " + x + " units and is now full!");
            }
            if (this.energy + getMealAmount() < 100){
                this.energy += getMealAmount();
                System.out.println(getName() + " ate " + getMealAmount() + " units!");
            }
    
        }
        else {System.out.println(getName() + " is dead!");}

        return x;
    }
}

class cow extends animal {
    private double mealAmount = 20;
    private String cowName;
    static int cowNum = 1;
    cow() {
        mealAmount = 20;
        cowName = "Cow" + cowNum;
        cowNum ++;
    }

    public double getMealAmount() {
        return mealAmount;
    }

    public String getName() {
        return cowName;
    }

    public void setMealAmount(double mealAmount) {
        this.mealAmount = mealAmount;
    }
    public void setName(String name) {
        this.cowName = name;
    }

    void sound() {
        if (getAlive()) {
            System.out.println("Moo!");
        }
    }
    
}

class chicken extends animal {
    private double mealAmount = 20;
    private String chickenName;
    static int chickenNum = 1;
    chicken() {
        mealAmount = 20;
        chickenName = "Chicken" + chickenNum;
        chickenNum ++;
    }

    public double getMealAmount() {
        return mealAmount;
    }

    public String getName() {
        return chickenName;
    }

    public void setMealAmount(double mealAmount) {
        this.mealAmount = mealAmount;
    }
    public void setName(String name) {
        this.chickenName = name;
    }

    void sound() {
        if (getAlive()) {
            System.out.println("Cluck!");
        }
    }
    
}

class llama extends animal {
    private double mealAmount = 20;
    private String llamaName;
    static int llamaNum = 1;
    llama() {
        mealAmount = 20;
        llamaName = "Llama" + llamaNum;
        llamaNum ++;
    }

    public double getMealAmount() {
        return mealAmount;
    }

    public String getName() {
        return llamaName;
    }

    public void setMealAmount(double mealAmount) {
        this.mealAmount = mealAmount;
    }
    public void setName(String name) {
        this.llamaName = name;
    }

    void sound() {
        if (getAlive()) {
            System.out.println("Hmmm!");
        }
    }
    
}



class farm {
    private double AvailableFood;
    animal[] animals = {
        new cow(), new chicken(), new llama(), new llama()
    };

    farm() {
        this.AvailableFood = 1000;
    }

    public void setAvailableFood(double availableFood) {
        AvailableFood = availableFood;
    }

    public double getAvailableFood() {
        return AvailableFood;
    }
    public animal[] getAnimals() {
        return animals;
    }

    public void makeNoise() {
        for (int i = 0; i < animals.length; i++) {
            animals[i].sound();
        }
    }
    public void feedAnimals() {
        for (int i = 0; i < animals.length; i++) {
            AvailableFood -= animals[i].eat();
        }
    }
}