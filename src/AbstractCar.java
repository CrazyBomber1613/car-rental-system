public abstract class AbstractCar implements Rentable{
    protected String make;
    protected String model;
    protected int year;

    abstract double calculateRentalCost(String rentalType , int amount);
    abstract String type();
    public String getMake() {
        return make;
    }
    public String getModel() {
        return model;
    }
    public int getYear() {
        return year;
    }
}