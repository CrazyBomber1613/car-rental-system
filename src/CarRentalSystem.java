import java.util.ArrayList;
import java.util.Scanner;
public class CarRentalSystem {

    static ArrayList<AbstractCar> cars = new ArrayList<>() {{
        add(new Sedan("Toyota", "Camry", 2019, 7, 40));
        add(new SUV("Honda", "CR-V", 2020, 14, 90));
    }};

    static void run(){
        Scanner input = new Scanner(System.in);
        int carNumber = 0;
        for(AbstractCar a : cars){
            carNumber++;
            System.out.printf("%d.\t %s %s (%d) - %s" , carNumber , a.getMake() , a.getModel() , a.getYear() , a.type());
            if (a.isRented()) System.out.print("(Rented)");
            System.out.print("\n");
        }
        System.out.print("type \"rent\" to rent a car or \"return\" to return a car: ");
        switch (input.nextLine()) {
            case "rent": {
                System.out.print("enter the number of the car to rent: ");
                int chosenCarNumber = input.nextInt() - 1;
                cars.get(chosenCarNumber).rent();
                break;
            }
            case "return": {
                System.out.print("enter the number of the car to return: ");
                int chosenCarNumber = input.nextInt() - 1;
                cars.get(chosenCarNumber).returnCar();
                break;
            }
        }
        run();
    }
}