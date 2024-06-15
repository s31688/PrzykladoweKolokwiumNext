import java.util.Date;

public class Sale {
    private String ID;
    private Product product;
    private int cost;
    private int pricePaid;
    private Date date;

    public Sale(String ID, Product product, int cost, int pricePaid, Date date) {
        this.ID = ID;
        this.product = product;
        this.cost = cost;
        this.pricePaid = pricePaid;
        this.date = date;
    }
}