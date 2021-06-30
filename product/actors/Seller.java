package actors;

import javafx.util.Pair;
import product.Product;
import product.ProductException;
import shelf.Shelf;
import shelf.Shop;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Seller implements interfaces.Seller {
    private final Shop shop;

    public Seller(Shop shop) {
        this.shop = shop;
    }

    @Override
    public void createAndAddProductOnTheShelf(Shelf shelf, String name, String type, Date date) {
        try {
            shelf.addProduct(new Product(name, type, date));
        } catch (ProductException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Pair<Product, Shelf>> findProductByName(String name) {
        ArrayList<Pair<Product, Shelf>> result = new ArrayList<>();
        for (var shelf : shop.getShelves()) {
            for (var product : shelf.getProducts()) {
                if (product.getName().equals(name)) {
                    result.add(new Pair<>(product, shelf));
                }
            }
        }
        return result;
    }

    @Override
    public List<Product> findExpiredGoods() {
        Date currentDate = new Date();
        return shop.getShelves().stream().flatMap(shelf -> shelf.getProducts().stream())
                .filter(product -> product.getExpirationDate().before(currentDate)).collect(Collectors.toList());
    }
}
