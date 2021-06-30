package shelf;

import product.Product;
import product.ProductException;

import java.util.ArrayList;
import java.util.List;

public class Shelf {
    private final String name;
    private final List<String> types;
    private final List<Product> products;

    public Shelf(String name, List<String> types) {
        this.name = name;
        this.types = types;
        this.products = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<String> getTypes() {
        return new ArrayList<>(types);
    }

    public List<Product> getProducts() {
        synchronized (this) {
            return new ArrayList<>(products);
        }
    }

    public void addProduct(Product product) throws ProductException {
        if (!types.contains(product.getType()))
            throw new ProductException("На данной полке не может хранится товар данного типа");
        synchronized (this) {
            products.add(product);
        }
    }

    public void removeProduct(Product product) {
        synchronized (this) {
            products.remove(product);
        }
    }
}