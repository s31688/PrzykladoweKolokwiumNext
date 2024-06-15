public class Subscription implements Product {
    private String name;
    private String description;
    private double price;
    private int renewalPeriod;

    public Subscription(String name, String description, double price, int renewalPeriod) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.renewalPeriod = renewalPeriod;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }
}