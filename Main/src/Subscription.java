import java.util.Objects;

public class Subscription implements Product {

    public static final int MAX_RENEWAL_PERIOD = 6;
    public static final int MIN_RENEWAL_PERIOD = 1;

    private String name;
    private String description;
    private double price;
    private int renewalPeriod;

    public Subscription(String name, String description, double price, int renewalPeriod) {
        setName(name);
        setDescription(description);
        setPrice(price);
        setRenewalPeriod(renewalPeriod);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Subscription that)) return false;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    public int getRenewalPeriod() {
        return renewalPeriod;
    }

    private void setRenewalPeriod(int renewalPeriod) {
        if (renewalPeriod < MIN_RENEWAL_PERIOD || renewalPeriod > MAX_RENEWAL_PERIOD) {
            throw new IllegalArgumentException("Renewal period has to be between 1 and 6 months");
        }
        this.renewalPeriod = renewalPeriod;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be less than zero");
        }
        this.price = price;
    }

    public double calculateTotalCost() {
        return renewalPeriod * price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public double getPrice() {
        return price;
    }
}