package product;

import java.util.Date;

public class Product {
    private final String name;
    private final String type;
    private final Date expirationDate;

    public Product(String name, String type, Date date) {
        this.name = name;
        this.type = type;
        this.expirationDate = date;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }
}
