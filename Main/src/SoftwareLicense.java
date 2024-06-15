import java.util.Date;

enum UserType {
    SINGLE_USER,
    MULTIPLE_USER
}

public class SoftwareLicense implements Product {
    private String name;
    private String description;
    private String licenseKey;
    private Date activateDate;
    private UserType typeOfLicense;
    private double price;

    public SoftwareLicense(String name, String description, double price, String licenseKey, Date activateDate,
                           UserType typeOfLicense) {
        this.name = name;
        this.description = description;
        this.licenseKey = licenseKey;
        this.activateDate = activateDate;
        this.typeOfLicense = typeOfLicense;
        this.price = price;
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