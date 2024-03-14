package zaliczenie.wzorceProjekt.models;

public class SingleRent implements RentComponent {
    private Rent rent;
    
    public SingleRent(Rent rent){
        this.rent = rent;
    }
    
    @Override
    public void printRentDetails() {
        System.out.println("Rent ID: " + rent.getId());
        System.out.println("Car: " + rent.getCar().getModel());
        System.out.println("Customer: " + rent.getCustomerName());
        System.out.println("Start Date: " + rent.getStartDate());
        System.out.println("End Date: " + rent.getEndDate());
        System.out.println();
    }
}
