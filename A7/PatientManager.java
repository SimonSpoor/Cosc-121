import java.util.PriorityQueue;
import java.util.Scanner;

public class PatientManager {
    PriorityQueue < Patient > waitingList = new PriorityQueue();
    public void start() {
        int order = 0;
        boolean Exited = false;

        while (!Exited) {
            Scanner input = new Scanner(System.in);
            System.out.println("(1) New Patient\n(2) Next Patient\n(3) Waiting List\n(4) Exit");
            
            int in = 0;
            try {
                in = input.nextInt();
            } catch (Exception e) {}

            switch ( in ) {
                case 1: //New Patient

                    System.out.println("Input patient name");
                    String name = input.next();

                    boolean exit = false;
                    int emergencyLevel = 0;

                    while (!exit){
                        try {
                            Scanner getLevel = new Scanner(System.in);
                            System.out.println("Input emergency level");
                            emergencyLevel = getLevel.nextInt();
                            if (emergencyLevel <= 5 && emergencyLevel > 0) exit = true;
                            else {System.out.println("Wrong value. Try again");}
                        } catch (Exception e) {
                            System.out.println("Wrong value. Try again");
                        }
                    }

                    Patient e = new Patient(order, name, emergencyLevel);

                    waitingList.offer(e);
                    order++;
                    break;
                case 2: //Next Patient
                if (!waitingList.isEmpty()){
                    System.out.println(waitingList.peek() + " is treated");
                    waitingList.poll();
                }
                else System.out.println("No more patients,");

                    break;
                case 3: //Waiting List
                    PriorityQueue < Patient > tempQueue = new PriorityQueue < Patient > (waitingList);
                    for (int i = 0; i < tempQueue.size(); i++) {
                        System.out.println(tempQueue.poll());
                    }
                    break;
                case 4: //Exit
                System.out.println("Program Terminated. Goodbye!");
                    Exited = true;
                    break;
                default:
                    System.out.println("(x) Wrong Choice");
                    break;
            }
        }

    }

}