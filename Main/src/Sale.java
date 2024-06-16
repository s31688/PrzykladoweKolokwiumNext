import java.util.Calendar;
import java.util.Date;

public class Sale {
    private static int NEXT_ID = 1;

    private int id;
    private Product product;
    private Date dateOfSale;
    private Date deadline;
    private double totalCost;
    private double pricePaid;


    public Sale(Product product, Date dateOfSale, double price) {
        this.id = NEXT_ID++;
        this.product = product;
        this.dateOfSale = dateOfSale;
        this.deadline = calculateDeadline(dateOfSale);
        this.totalCost = price;
    }

    private Date calculateDeadline(Date dateOfSale) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateOfSale);
        calendar.add(Calendar.MONTH, 1); // Add one month to the dateOfSale
        return calendar.getTime();
    }

    public void pay(double amount) {
        if (pricePaid >= totalCost) {
            throw new IllegalArgumentException("Sale has been already paid");
        }

        if (pricePaid + amount > totalCost) {
            throw new IllegalArgumentException("Amount is too high");
        }

        Date now = new Date();
        if (deadline.before(now)) {
            throw new IllegalArgumentException("Deadline for this sale has already passed.");
        }

        this.pricePaid += amount;
    }

    public double getCostToBePaid() {
        return totalCost - pricePaid;
    }

    public double getPricePaid() {
        return pricePaid;
    }

    public int getId() {
        return id;
    }

    public String getProductName() {
        return this.product.getName();
    }

    private void setId(int id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    private void setProduct(Product product) {
        this.product = product;
    }

    public Date getDateOfSale() {
        return dateOfSale;
    }

    private void setDateOfSale(Date dateOfSale) {
        this.dateOfSale = dateOfSale;
    }

    public double getTotalCost() {
        return totalCost;
    }

    private void setTotalCost(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        this.totalCost = price;
    }
}