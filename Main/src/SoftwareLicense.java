import java.util.Date;
import java.util.Objects;

public class SoftwareLicense implements Product {


    private String name;
    private String description;
    private double price;
    private String licenseKey;
    private Date activationDate;
    private UserType userType;

    public SoftwareLicense(String name, String description, double price, String licenseKey, Date activationDate, UserType userType) {
        setName(name);
        setDescription(description);
        setPrice(price);
        setLicenseKey(licenseKey);
        setLicenseKey(licenseKey);
        setUserType(userType);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SoftwareLicense that)) return false;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    private void setLicenseKey(String licenseKey) {
        this.licenseKey = licenseKey;
    }

    private void setActivationDate(Date activationDate) {
        this.activationDate = activationDate;
    }

    private void setUserType(UserType userType) {
        this.userType = userType;
    }

    public void setName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null");
        }
        this.name = name;
    }

    public void setDescription(String description) {
        if (description == null) {
            throw new IllegalArgumentException("Description cannot be null");
        }
        this.description = description;
    }

    public void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be less than zero");
        }
        this.price = price;
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