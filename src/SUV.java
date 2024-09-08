public class SUV extends AbstractCar{
    double weeklyRate;
    double dailyRate;
    boolean rented;

    SUV(String make , String model , int year , double weeklyRate , double dailyRate){
        super.make = make;
        super.model = model;
        super.year = year;
        this.weeklyRate = weeklyRate;
        this.dailyRate = dailyRate;
    }

    @Override
    public String type(){return "SUV";}
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
        if (!rented)
            rented = true;
        else
            System.out.println("car already rented!");
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