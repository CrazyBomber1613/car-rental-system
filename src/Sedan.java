import java.util.Scanner;

public class Sedan extends AbstractCar{
    double weeklyRate;
    double dailyRate;
    boolean rented = false;
    Scanner input = new Scanner(System.in);

    Sedan(String make , String model , int year , double weeklyRate , double dailyRate){
        super.make = make;
        super.model = model;
        super.year = year;
        this.weeklyRate = weeklyRate;
        this.dailyRate = dailyRate;
    }

    @Override
    public String type(){return "Sedan";}
    @Override
    double calculateRentalCost(String rentalType , int amount) {
        double finalCost = 0;
        switch (rentalType){
            case "weekly":
                finalCost = weeklyRate * (double)amount;
                break;
            case "daily":
                finalCost = dailyRate * (double)amount;
                break;
            default:
                System.out.println("please try again");
                break;
        }
        return finalCost;
    }
    @Override
    public void rent() {
        if (!rented) {
            System.out.print("How are you going to rent the car? (weekly / daily): ");
            String rentalType = input.nextLine();
            if (!rentalType.equalsIgnoreCase("weekly") && !rentalType.equalsIgnoreCase("daily")) {
                System.out.println("Invalid rental type. Exiting...");
                return;
            }
            int amount = 0;
            boolean validInput = false;
            while (!validInput) {
                System.out.print("Enter the number of " + rentalType + "s: ");
                try {
                    amount = Integer.parseInt(input.nextLine());
                    if (amount <= 0) {
                        System.out.println("Please enter a positive number.");
                    } else {
                        validInput = true;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid number. Please try again.");
                }
            }

            double cost = calculateRentalCost(rentalType, amount);
            System.out.println("The rental cost is: " + cost);
            rented = true;
            System.out.println("Car rented successfully!");
        } else {
            System.out.println("Car already rented!");
        }
    }
    @Override
    public void returnCar() {
        if(rented)
            rented = false;
        else
            System.out.println("you haven't rented the car!");
    }
    @Override
    public boolean isRented() {return rented;}
}