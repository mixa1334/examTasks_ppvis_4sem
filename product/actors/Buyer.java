package actors;

import product.Product;
import product.ProductException;
import shelf.Shelf;
import shelf.Shop;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public class Buyer implements interfaces.Buyer {
    private final Shop shop;
    private final Shelf shelf;
    private final List<String> typesOfProduct;

    public Buyer(Shop shop, Shelf shelf) {
        this.shop = shop;
        this.shelf = shelf;
        this.typesOfProduct = this.shelf.getTypes();
    }

    @Override
    public Optional<Product> findProductOnShelf(Shelf shelf, String type) {
        for (var product : shelf.getProducts()) {
            if (product.getType().equals(type)) {
                return Optional.of(product);
            }
        }
        return Optional.empty();
    }

    @Override
    public void takeProductsFromOtherShelves() {
        Date currentDate = new Date();
        for (var shelf : shop.getShelves()) {
            for (var product : shelf.getProducts()) {
                if (typesOfProduct.contains(product.getType()) && product.getExpirationDate().after(currentDate)) {
                    try {
                        shelf.removeProduct(product);
                        this.shelf.addProduct(product);
                    } catch (ProductException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }
    }
}