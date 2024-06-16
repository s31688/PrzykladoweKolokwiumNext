import java.util.ArrayList;
import java.util.Date;

public class Client {

    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private int discount;
    private ArrayList<Sale> sales = new ArrayList<>();

    public Client(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Client(String firstName, String lastName, String email, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }

    public double buySoftwareLicense(SoftwareLicense product) {
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }

        Sale s = findSaleForProduct(product);
        if (s != null) {
            throw new IllegalArgumentException("Product has been already bought");
        }

        double price = product.getPrice();
        if (discount > 0) {
            price *= 1 - discount;
        }

        Date now = new Date();
        Sale newSale = new Sale(product, now, price);
        this.sales.add(newSale);

        return price;
    }

    public double buySubscription(Subscription product) {
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }

        Sale s = findSaleForProduct(product);
        if (s != null) {
            throw new IllegalArgumentException("Product has been already bought");
        }

        double price = product.calculateTotalCost();
        if (discount > 0) {
            price *= 1 - discount;
        }

        Date now = new Date();
        Sale newSale = new Sale(product, now, price);
        this.sales.add(newSale);

        return price;
    }

    public void pay(Product p, double amount) {
        if (p == null) {
            throw new IllegalArgumentException("Product is null");
        }

        if (amount < 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        }

        Sale s = findSaleForProduct(p);
        if (s == null) {
            throw new IllegalArgumentException("Sale was not found");
        }

        s.pay(amount);
    }

    private Sale findSaleForProduct(Product p) {
        for (Sale s : sales) {
            if (s.getProduct().equals(p)) {
                return s;
            }
        }

        return null;
    }

    public double calculateTotalPaidCost() {
        double totalCost = 0;
        for (Sale s : sales) {
            totalCost += s.getTotalCost();
        }

        return totalCost;
    }

    public double calculateTotalCostToBePaid() {
        double totalCost = 0;
        for (Sale s : sales) {
            totalCost += s.getCostToBePaid();
        }

        return totalCost;
    }


    public String getFullName() {
        return firstName + " " + lastName;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        if (discount < 0 || discount > 100) {
            throw new IllegalArgumentException("Discount has to be between 0 and 100");
        }
        this.discount = discount;
    }

    public String getFirstName() {
        return firstName;
    }

    private void setFirstName(String firstName) {
        if (firstName == null) {
            throw new IllegalArgumentException("First name cannot be null");
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    private void setLastName(String lastName) {
        if (lastName == null) {
            throw new IllegalArgumentException("Last name cannot be null");
        }
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    private void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    private void setPhone(String phone) {
        this.phone = phone;
    }
}