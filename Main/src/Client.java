import java.util.ArrayList;

public class Client {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private int discount;
    private static ArrayList<SoftwareLicense> softwareLicenses = new ArrayList<>();

    public Client(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void buySoftwareLicense(SoftwareLicense softwareLicense) {
        if(softwareLicenses.contains(softwareLicense)) {
            throw new IllegalArgumentException("Software license already bought");
        }
        softwareLicenses.add(softwareLicense);
    }

    public void buySubscription(Subscription subscription) {

    }

    public void pay(SoftwareLicense softwareLicense, int amount) {

    }

    public void pay(Subscription subscription, int amount) {

    }

    public double calculateTotalPaidCost() {
        return 0;
    }

    public double calculateTotalCostToBePaid() {
        return 0;
    }
}